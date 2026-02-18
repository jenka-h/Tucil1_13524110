/*
    This is the solver and the logic for the program.

    For the flow, might as well look at main.java :D
 */

import java.util.*;

public class method{

    private boardMatrix board;
    private int nInterval;

    public method(boardMatrix board, int nInterval){
        this.board = board;
        this.nInterval = nInterval;
    }

    private List<List<item>> buildColorOrder() {
        List<List<item>> colorOrder  = new ArrayList<>();
        List<Character>  colorKeys   = new ArrayList<>();  

        for (int i = 0; i < board.nRows; i++) {
            for (int j = 0; j < board.nCols; j++) {
                char color = board.mat[i][j].getColor();  

                // Cari di list colorKey, ada yang baru ngga, kaya dia
                int idx = -1;
                for (int k = 0; k < colorKeys.size(); k++) {
                    if (colorKeys.get(k) == color) {
                        idx = k;
                        break;
                    }
                }
                
                // Kalau emang baru, tambah
                if (idx == -1) {
                    colorKeys.add(color);
                    colorOrder.add(new ArrayList<>());
                    idx = colorKeys.size() - 1;
                }
                
                // Tambah ke list
                colorOrder.get(idx).add(new item(i, j));
            }
        }

        return colorOrder;
    }

    private boolean isSafe(int row, int col, List<item> placedQueens){
        for (item q : placedQueens){
            int qRow = q.getRow();
            int qCol = q.getCol();

            if (qRow == row) return false;
            if (qCol == col) return false;
            if (Math.abs(qRow - row) <= 1 && Math.abs(qCol - col) <= 1)
                return false;
        }
        return true;
    }

    private boolean isSolved(List<item> placedQueens, int totalColors){
        if (placedQueens.size() != totalColors) return false;

        for (int i = 0; i < placedQueens.size(); i++){
            int row = placedQueens.get(i).getRow();
            int col = placedQueens.get(i).getCol();

            // // Cek dengan Queen lainnya
            // if (!(isSafe(row,col,placedQueens))) return false;

            for (int j = 0; j < placedQueens.size(); j++) {
                if (i == j) continue;

                int jRow = placedQueens.get(j).getRow();
                int jCol = placedQueens.get(j).getCol();

                if (jRow == row) return false;
                if (jCol == col) return false;
                if (Math.abs(jRow - row) <= 1 && Math.abs(jCol - col) <= 1) return false;
            }

        }

        return true;
    }

    private void applyQueensToBoard(List<item> placedQueens, boolean value){
        for (item q : placedQueens) {
            board.get(q.getRow(), q.getCol()).setQueen(value);
        }
    }
    
    // Fungsi temporary
    private void printQueens(List<item> placedQueens, int iteration) {
        System.out.println("*** Iteration " + iteration + " ***");
        applyQueensToBoard(placedQueens, true);
        System.out.print(board.tulisBoardMatrix(board));
        applyQueensToBoard(placedQueens, false);
    }

    public boolean solve(int nInterval){
        List<List<item>> colorOrder = buildColorOrder();
        int totalColors = colorOrder.size();
        int iteration = 0;

        int[] pointer = new int[totalColors];
        Arrays.fill(pointer, 0);
        while(true){
            List<item> placedQueens = new ArrayList<>();
            for (int c = 0; c < totalColors; c++) {
                item q = colorOrder.get(c).get(pointer[c]);
                placedQueens.add(q);
                applyQueensToBoard(placedQueens,true);
            }

            iteration++;

            if (nInterval > 0 && iteration % nInterval == 0) {
                System.out.println("*** Iteration " + iteration + " ***");
                System.out.print(board.tulisBoardMatrix(board));
                                System.out.println("");

            }

            if (isSolved(placedQueens, totalColors)) {
                System.out.println("*** Solved! (Iteration " + iteration + ") ***");
                System.out.print(board.tulisBoardMatrix(board));
                System.out.println("");
                return true;
            }

            applyQueensToBoard(placedQueens,false);

            int carry = totalColors - 1;
            while (carry >= 0) {
                pointer[carry]++;

                if (pointer[carry] < colorOrder.get(carry).size()){
                    break; 
                }

                pointer[carry] = 0;
                carry--;
            }

            if (carry < 0) {
                System.out.println("No solution found after " + iteration + " iterations.");
                return false;
            }
        }
    }

}