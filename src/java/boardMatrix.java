/*
    TO DO: 
    1. Validation Input, was the input legal? Was there any spacing?
    2. What if it was numbers instead of characters from A-Z?
 */

public class boardMatrix
{
    public cell[][] mat;
    public int nRows, nCols;

    public boardMatrix(int R, int C)
    {
        this.nRows = R;
        this.nCols = C;
        this.mat = new cell[R][C];
    }

    // Selector 
    public int getnRows() 
    {
        return nRows;
    }
    public int getnCols() 
    {
        return nCols;
    }

    // Function
    public void set(int i, int j, cell val) 
    {
        mat[i][j] = val;
    }

    public cell get(int i, int j)
    {
        return mat[i][j];
    }
    
    // Beberapa fungsi berikut merupakan hasil utilisasi Tubes 1 Algeo :D

    public void debugBoardMatrix(boardMatrix m) { // konsol
        if (m == null || m.mat == null) {
            System.out.println("(boardMatrix kosong atau tidak valid)");
            return;
        }

        for (int i = 0; i < m.nRows; i++) {
            for (int j = 0; j < m.nCols; j++) {
                System.out.print(m.mat[i][j]);
                if (j < m.nCols - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public String tulisBoardMatrix(boardMatrix boardMatrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < boardMatrix.nRows; i++) {
            for (int j = 0; j < boardMatrix.nCols; j++) {

                cell cell = boardMatrix.mat[i][j];

                if (cell.hasQueen()) {
                    sb.append("#");
                } else {
                    sb.append(cell.getColor());
                }

                if (j < boardMatrix.nCols - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean isSquare(boardMatrix mat){
        boolean square = false;
        if (mat.nRows == mat.nCols){square = true;}
        return square;
    }

    public static String[] splitRow(String line) {
        line = line.trim();
        line = line.replace(" ", ""); 
        return line.split("");
    }
    
    public boolean validateLetters(String[] lines, int expectedCols){
        boolean valid = true;
        for (int i = 0; i < lines.length; i++) {

            String[] tokens = splitRow(lines[i]);

            if (tokens.length != expectedCols){
                System.out.print("There are some columns that is different.");
                valid = false;
            }

            for (int j = 0; j < tokens.length; j++) {

                if (tokens[j].length() != 1) {
                    System.out.print("Invalid token length.");
                    valid = false;
                }

                char c = tokens[j].charAt(0);

                if (!Character.isLetter(c)) {
                    System.out.print("Invalid character at row" + i + " col" + j + ".");
                    valid = false;
                }
            }
        }
        return valid;
    }

    public static boardMatrix textToBoardMatrix(String input){ //Mengubah input String menjadi boardMatrix
        if (input == null || input.isBlank()) return null;
        String[] lines = input.trim().split("\\r?\\n+");
        int nRows = lines.length;

        // Jika spasi kosong akan dihilangkan
        for (int i = 0; i < nRows; i++) lines[i] = lines[i].trim();
        if (lines[0].isEmpty()) return null;

        // Deteksi kolom
        String[] firstLine = splitRow(lines[0]);
        int nCols = firstLine.length;
        
        // Buat matrix kosong
        boardMatrix board = new boardMatrix(nRows, nCols);
        for (int i = 0; i < nRows; i++) {
            String[] tokens = splitRow(lines[i]);

            for (int j = 0; j < nCols; j++) {
                char color = tokens[j].charAt(0);  

                board.mat[i][j] = new cell(i, j, color);
            }
        }

        return board;
    }   
}