package composite;

import java.io.InputStream;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 * Class for managing items.
 * 
 */

public class ItemManager {
	private Composite root; // Root list

	public ItemManager() {
		this.root = new Composite("root");

	}

	/**
	 * Reads the xml data from the input stream or throws an Exception if anything
	 * goes wrong (e.g., the xml code is invalid or some price attribute cannot be
	 * converted to type double).
	 * Items are assumed to have a unique name.
	 * The input stream is allowed to have empty lists.
	 * This is the only method where xml is handled in this assignment. No other
	 * method in this class should contain (or call)
	 * xml-specific code.
	 */
	public void readXml(InputStream xmlData) throws Exception {
		// 1. Creating DocumentBuilderFactory i DocumentBuilder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		// 2. Parsing XML in DOM document
		Document doc = db.parse(xmlData);

		// 3. Getting the root element with getDocumentElement method
		Element rootElement = doc.getDocumentElement();

		// 4. Creating the hierarchy recursively with out parseElement method
		Composite root = parseElement(rootElement);

		// 5. Setting the root object for further use
		this.root = root;
	}

	private Composite parseElement(Element element) {
		// Create Composite object for current <list> tag
		Composite composite = new Composite(element.getAttribute("name"));

		// Go through children of the current element
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);

			// Process only elements, ignore anything else
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element childElement = (Element) node;

				// Check the element type according to tag type
				String tagName = childElement.getTagName();
				switch (tagName) {
					case "book":
						// Create Book object
						String bookName = childElement.getAttribute("name");
						double bookPrice = Double.parseDouble(childElement.getAttribute("price"));
						String isbn = childElement.getAttribute("isbn");
						composite.addItem(new Book(bookName, bookPrice, isbn));
						break;

					case "cd":
						// Create CD object
						String cdName = childElement.getAttribute("name");
						double cdPrice = Double.parseDouble(childElement.getAttribute("price"));
						composite.addItem(new CD(cdName, cdPrice));
						break;

					case "list":
						// Recursively call parseElement for nested lists
						composite.addItem(parseElement(childElement));
						break;

					default:
						throw new IllegalArgumentException("Unsupported tag: " + tagName);
				}
			}
		}
		return composite;
	}

	/**
	 * Returns an {@code Optional} instance representing the price of the item (cd,
	 * book, or list) with the given name; the {@code Optional} is empty, if
	 * no such item exists
	 */
	public Optional<Double> getPrice(String item) {
		Item found = root.findItem(item);
		return found != null ? Optional.of(found.getPrice()) : Optional.empty();
	}

	/**
	 * removes the item with the given name, unless it's the root
	 * returns true if the operation succeeded (item found and removed)
	 * returns false if item is the root, or it is not found, or it cannot be
	 * removed due to some other error
	 */
	public boolean removeItem(String item) {
		if (root.getName().equals(item)) {
			return false; // Root cannot be removed
		}
		return root.removeItem(item);
	}

	/**
	 * changes the price of the item with the given name;
	 * returns false if item is not found or it is a list, or if the price is
	 * smaller than or equal to 0,
	 * returns false if the price could not be changed for any other reason;
	 * returns true if the price was changed successfully (i.e., the item had a
	 * different price before);
	 */
	public boolean changePrice(String item, double newPrice) {
		if (newPrice <= 0) {
			return false; // Price cannot be negative or zero
		}

		Item found = root.findItem(item); // Find the item in hierarhcy
		return found != null && found.changePrice(newPrice); // Call changePrice
	}
}