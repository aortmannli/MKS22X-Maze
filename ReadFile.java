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
      char[][] maze = new char[height][length];

      for(int x = 0; in.hasNextLine(); x++){
        String line = in.nextLine(0);
        for(int y = 0; y < length; y++){
          maze[x][y] = line.charAt(y);
        }
      }
    }

  }
}
