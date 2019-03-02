import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default
    public int len;
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
      int x = 0;
      int y = 0;
      animate = false;
      File f = new File(args[0]);
      Scanner in = new Scanner(f);
      int height = 0;
      int length = 0;
      int[] path = new
      while (in.hasNext()) {
        String out = in.nextLine();
        height ++;
        length = out.length();
        char[][] maze = new char[height][length];

        for(int x = 0; in.hasNextLine(); x++){
          String line = in.nextLine(0);
          for(int y = 0; y < length; y++){
            maze[x][y] = line.charAt(y);
             if (line.charAt(y) == 'S') s = new int[] {x,y};
          }
        }

        moves = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
      }



    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */


    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int num){ //you can add more parameters since this is private
        int out;

        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        if (maze[row][col] == 'E') return 1;
        if (maze[row][col] != ' ') return -1;

        maze[row][col] = '@';
        out++;
        
        for(int[] i : moves){
          if solve(row+i[0],col+i[1], num+1) != -1){
            return out;
          }
        }
        board[row][col] = '.';
        out--;
        return -1;
    }


}
