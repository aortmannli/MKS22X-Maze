import java.util.*;
import java.io.*;
public class Maze{

  private char[][]maze;
  private boolean animate;//false by default
  private int[][] moves;
  private int[] S;

  public static void main(String[] args) throws FileNotFoundException{
       Maze yeet = new Maze (args[0]);
       System.out.println(yeet.S[0] + "," + yeet.S[1]);
       System.out.println(yeet.solve());
       System.out.println(yeet);

   }
    /*Constructor loads a maze text file, and sets animate to false by default.
      When the file is not found then:
         throw a FileNotFoundException

      You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      You ma also assume the maze has a border of '#' around the edges.
      So you don't have to check for out of bounds!
    */
    public Maze(String filename) throws FileNotFoundException{
      animate = true;
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int height = 0;
      int length = 0;
      S = new int[2];

      while (in.hasNextLine()){
        String out = in.nextLine();
        height ++;
        length = out.length();
      }
      maze = new char[height][length];

      in = new Scanner(f);
      for(int x = 0; in.hasNextLine(); x++){
        String line = in.nextLine();
        for(int y = 0; y < length; y++){
           if (line.charAt(y) == 'S'){
             S[0] = x;
             S[1] = y;
           }
           maze[x][y] = line.charAt(y);
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





   /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
    public String toString(){
       String output = "";
       for(char[] i: maze){
           for (char j: i){
               output += j + " ";
           }
           output += '\n';
       }
       return output;
   }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S.
            maze[S[0]][S[1]] = ' ';
            //erase the S

            //and start solving at the location of the s.
            return solve(S[0],S[1]);
    }

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
    private int solve(int row, int col){ //you can add more parameters since this is private
        int out = 0;
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(100);
        }
        if (maze[row][col] == 'E') return 1;
        if (maze[row][col] != ' ') return -1;

        maze[row][col] = '@';
        out++;

        for (int[] i : moves){
            if(solve(row + i[0], col + i[1]) != -1){
                return out;
            }
        }
        //if the branch fails, reset the spot to 0 and move on to other brances
        maze[row][col] = '.';
        out--;

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}
