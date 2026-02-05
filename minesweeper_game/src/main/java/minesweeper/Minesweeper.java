package minesweeper;

public class Minesweeper {
     
    private char[][] field;              // Matrix for minefield;
    private boolean[][] visible;         // Matrix for storing information about the visibility of cells;
    private int rows;                    // Number of rows;
    private int cols;                    // Number of cols.

    
    public Minesweeper() {
        this.field = null;
        this.visible = null;
        this.rows = 0;
        this.cols = 0;
    }

    /**
     * Initializes the mine field from given multiline string representation
     * A line represents a row of the field
     * All lines must have the same number of characters, which is the number of columns of the field
     * A character can be either '*' for a mine cell, or '.' for an empty cell
     * The number of rows must be smaller than or equal to the number of columns
     * Rows are indexed top-down with the top row index equal to zero.
     * @param s the string
     * @return true if initialization succeeds, i.e., field is valid, or false otherwise.
     */
    public boolean setMinefield(String s) {
    
        String[] lines = s.split("\n");           // Division of the multiline string into rows;
        rows = lines.length;
        
        if(rows == 0){                                  // Check if string is empty;
            return false;
        }
        cols = lines[0].length();
        
        for(String x : lines){                          // Check if every row has the same amount of columns;
            if(x.length() != cols){
                return false;
            }
        }
        if(rows > cols){                                // Number of rows must be smaller or equal to the number of columns;
            return false;
        }
        field = new char[rows][cols];                   // Initialization of the fields
        visible = new boolean[rows][cols];   
        
        for(int i = 0; i < rows; i++){                  // Loops for iterating through lines and filling of the field
            for(int j = 0; j < cols; j++){
                char c = lines[i].charAt(j);
                if(c == '*' || c == '.'){               // Checking if the character is valid
                    field [i][j] = c;   
                } else {
                    return false;
                }
                visible[i][j]=false;                    // All cells should initially be invisible
            }
        }

     return true;

        
    }

    /**
     *
     * @return the number of bombs in the field, or -1 if the field is invalid
     */
    public int getNumberOfBombs() {

        if(field==null || rows <= 0 || cols <= 0){
            return -1;
        }

        int bombs = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(field[i][j]== '*'){
                    bombs++;
                }
            }
        }
        return bombs;
    }

    /**
     * Returns the hint at coordinate (row, column)
     * @param row
     * @param col
     * @return the hint (>=0) if successful and cell has no bomb, -1 otherwise
     */
    public int getHintAt(int row, int col) {

        if(row >= rows || col >= cols || row < 0 || col < 0 ){
            return -1;
        }
        if(field [row][col] == '*'){
            return -1;
        }
        int count = 0;

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j<=1; j++){
                int newRow = i + row;
                int newCol = j + col;

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && field[newRow][newCol] == '*'){
                count++;
                }
            }
        }
        return count;
    }

    /**
     * Checks the visibility of a cell.
     * @param row
     * @param col
     * @return true if the cell (row,column) is visible, false otherwise
     */
    public boolean isVisible(int row, int col) {

        if(row < 0 || col < 0 || row >= rows || col >= cols){
            return false;
        }
        return visible[row][col];
    }

    /**
     * Simulates a user click on a cell. If this is a bomb cell, all the bomb cells in the entire field become visible.
     * Otherwise only this cell becomes visible.
     * @param row
     * @param col
     * @return true if the cell has no bomb, false if it's a bomb cell
     */
    public boolean clickOn(int row, int col) {

        if(row < 0 || col < 0 || row >= rows || col >= cols){
            return false;
        }
        if(field[row][col]=='*'){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(field[i][j]=='*'){
                        visible[i][j] = true;
                    }
                }
            }
            return false;
        }
        visible[row][col]=true;
        return true;
    }

    /**
     *
     * @return the number of rows of the field
     */
    public int getHeight() {
        return rows;
    }

    /**
     *
     * @return the number of columns of the field
     */
    public int getWidth() {
        return cols;
    }
	
}
