import java.util.Scanner;

public class decToBin {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Base-10 Integer To Convert To Base-2: ");
    int n = s.nextInt();
    convert(n);
  }

  public static void convert(int n) {
    printArray(decToBin(n));
  }
  
  public static int[] decToBin(int n) {
    if (n < 0) n = -n;
    int maxPV = maxBinaryPlaceValue(n);
    int[] bin = new int[maxPV];
    int total = 0;
    for (int i = 0; i < bin.length; i++) {
      int currentPow = (bin.length - 1) - i;
      double nextVal = Math.pow(2,currentPow);
      if (total + nextVal <= n) {
        total += nextVal;
        bin[i] = 1;
      }
      if (total >= n) break; //break if it's equal or greater than the target sum of powers
    }

    return bin;
  }

  public static void printArray(int[] a) {
    for (int i : a) {
      System.out.print(i + " ");
    }
    System.out.print("\n");
  }

  public static int maxBinaryPlaceValue(int n) {
    double l = Math.log10(n) / Math.log10(2);
    //gives log base 2 of n
    return (int)(l+1);
  }

}
