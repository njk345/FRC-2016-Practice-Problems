import java.util.ArrayList;
import java.util.Scanner;
public class RecFact {
  private static ArrayList<Long> store;
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    boolean cont = true;
    while (cont) {
      System.out.print("Enter An Integer (<=20) to Calculate its Factorial: ");
      int x = s.nextInt();
      store = new ArrayList<>(); //reset the lookup table
      store.add((long)1);  //0! = 1
      long answer = fact(x);
      System.out.println("" + answer);
      s.nextLine();
      System.out.print("Go Again (y/n)?");
      cont = s.nextLine().equals("y");
    }
  }
  public static long fact(int x) {
    if (x <= store.size() - 1) {
      return store.get(x);
    } else {
      long newVal = x * fact(x-1);
      store.add(newVal);
      return newVal;
    }
  }
}
