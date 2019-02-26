import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile{
  public static void main(String[] args) throws FileNotFoundException {
    File f = new File(args[0]);
    Scanner in = new Scanner(f);
    int height = 0;
    int length = 0;
    while (in.hasNext()) {
      String out = in.nextLine();
      height ++;
      length = out.length();
      System.out.println(out);

    }
    char[][] maze = new char[height][length];

    for(int i = 0; i < maze.length; i++){
      for(int x = 0; x < maze[0].length; x++){
        System.out.print(maze[i][x]);
      }
    }

  }
}
