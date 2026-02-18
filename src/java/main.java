/*
    ** Main Program **
    This program will be based on the color rule first, I will prioritize region over columns or rows (This doesn't really effect the complexity).

    Created by: Jenka
    NIM: 13524110

    PS: I cannot really use Vim, I do hope I can type without using Mouse or Touchpad. Have fun Kak :D

    I thanked for that one lonely karaoke timeline, a big W to my ex.
 */


/*
    Flow state for the program:
    1. Inputs, minimum of 4, you can do 1, but not 2 and 3. Make the board.
    2. Find the first ever color to be found. Place the queen.
    3. Do another region, and iterate rule number 2 until all queens are placed.
    4. Validate, is the position right? Yes --> stop program; No --> Continue

    Some constraints:
    1. No backtracking, no early pruning.
    2. No heuristics :D 
    3. Be naive as possibly as you can.

    Sksksksk biuw.
 */

import java.util.Scanner;
import java.io.*;

public class main{
    static boolean isValidOutputPath(String path) {
        if (path == null || path.isBlank()) {
            System.out.println("Path cannot be empty.");
            return false;
        }

        if (!path.endsWith(".txt")) {
            System.out.println("File must end with .txt, try again.");
            return false;
        }

        File file = new File(path);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            System.out.println("Folder does not exist, " + parentDir.getAbsolutePath());
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Input mode:");
            System.out.println("1. Manual input");
            System.out.println("2. Read from .txt file");
            System.out.print("Choose: ");
            int inputMode = Integer.parseInt(sc.nextLine().trim());
            
            String rawInput = "";

            if (inputMode == 1){
                System.out.println("Enter the board (empty line to finish):");
                StringBuilder sb = new StringBuilder();
                String line;
                while (sc.hasNextLine()){
                    line = sc.nextLine();
                    if (line.isBlank()) break;
                    sb.append(line).append("\n");
                }
                rawInput = sb.toString();
            } else if (inputMode == 2){
                System.out.print("Enter input .txt file path: (Use absolute path :D)");
                String filePath = sc.nextLine().trim();

                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                rawInput = sb.toString();
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            boardMatrix board = boardMatrix.textToBoardMatrix(rawInput);
            if (board == null) {
                System.out.println("Invalid board input.");
                return;
            }

            if (!board.isSquare(board)) {
                System.out.println("Board must be a square.");
                return;
            }

            System.out.print("Print every N iterations (0 = only final): ");
            int interval = sc.nextInt();
            while (interval < 0){
                System.out.print("Hey, why are you putting negative numbers...");
                interval = sc.nextInt();
            }

            method solver = new method(board, interval);
            long startTime = System.currentTimeMillis();
            boolean solved = solver.solve(interval);
            long endTime = System.currentTimeMillis();

            System.out.println("Time elapsed: " + (endTime - startTime) + " ms\n\n");

            if (!solved){
                System.out.println("Thank you for participating!");
            }

            if (solved) {
                System.out.print("Save result to .txt file? (y/n): ");
                String saveLine = sc.nextLine().trim();
                while (saveLine.isEmpty()){
                    saveLine = sc.nextLine().trim();
                }
                char save = saveLine.charAt(0);

                if (save == 'y' || save == 'Y') {
                    System.out.print("Enter output .txt file path: ");
                    String outPath = sc.nextLine().trim();

                    while(!(isValidOutputPath(outPath))){
                        System.out.print("\nEnter again output .txt file path: ");
                        outPath = sc.nextLine().trim();
                    }

                    BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
                    writer.write(board.tulisBoardMatrix(board));
                    writer.close();
                    System.out.println("Saved!\n");
                }
            }
                    
            System.out.println("Retry? (y/n)");
            char x = sc.next().charAt(0);

            if (x == 'n' || x == 'N') break; 
        }
        
    }
}