import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class Ex8 {

  public static void main(String[] args) {
    try {
      RandomAccessFile answ = new RandomAccessFile("answ.txt", "rw");
      int n = MyIO.readInt();

      for(int i=0; i<n; i++){
        answ.seek(i*8);
        answ.writeDouble(MyIO.readDouble());
      }

      answ.close();

      RandomAccessFile answ2 = new RandomAccessFile("answ.txt", "r");

      for(int i=n-1; i>-1; i--){
        answ2.seek(i*8);
        double tmp = answ2.readDouble();
        if (tmp % 1 != 0)
          MyIO.println(tmp);
        else
          MyIO.println((int) tmp);
      }

      answ2.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}