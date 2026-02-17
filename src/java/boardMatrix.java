public class boardMatrix
{
    public cell[][] mat;
    public int nRows, nCols;

    public boardMatrix(int R, int C)
    {
        this.nnRows = R;
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

    public void debugboardMatrix(boardMatrix m) { // konsol
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

    public String tulisboardMatrix(boardMatrix boardMatrix) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boardMatrix.nRows; i++) {
            for (int j = 0; j < boardMatrix.nCols; j++)
            {
                cell val = boardMatrix.mat[i][j];
                if (Math.abs(val - Math.round(val)) < 0.000000001)
                {
                    sb.append((int) val);
                }
                else
                {
                    sb.append(String.format("%.4f", val).replaceAll("0+$", "").replaceAll("\\.$", ""));
                }
                if (j < boardMatrix.nCols - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // FIX
    public static boardMatrix textToboardMatrix(String input) //Mengubah input String menjadi boardMatrix
    {
        if (input == null || input.isBlank()) return null;
        String[] lines = input.trim().split("\\r?\\n+");
        int totalnRows = lines.length;

        // Jika spasi kosong akan dihilangkan
        for (int i = 0; i < totalnRows; i++) lines[i] = lines[i].trim();
        if (lines[0].isEmpty()) return null;

        // Deteksi kolom
        String[] firstLine = lines[0].split("\\s+");
        int nCols = firstLine.length;

        // Mengambil derajat regresi/interpolasi
        String[] lastTokens = lines[totalnRows - 1].split("\\s+");
        boolean lastIsDegree= (lastTokens.length == 1 && lastTokens[0].matches("-?\\d+(\\.\\d+)?"));
    }
}
