// Similar to Data Structure

public class cell{
    private int row;
    private int col;
    private char color;
    private boolean hasQueen;

    public cell(int row, int col, char color){
        this.row = row;
        this.col = col;
        this.color = color;
        this.hasQueen = false;
    }

    public int getRow(){ 
        return row; 
    }

    public int getCol(){ 
        return col; 
    }

    public char getColor(){ 
        return color; 
    }

    public boolean hasQueen(){
        return hasQueen; 
    }
    
    public void setQueen(boolean value){ 
        this.hasQueen = value; 
    }
}