import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile{
  public static void main(String[] args) throws FileNotFoundException {
    File f = new File(args[0]);
    Scanner in = new Scanner(f);

    while (in.hasNext()) {
      String out = in.nextLine();
      System.out.println(out);
    }
  }
}
