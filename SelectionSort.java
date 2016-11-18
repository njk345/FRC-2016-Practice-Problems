// Correct. Nice work
import java.util.Arrays;
public class SelectionSort {
  public static void main(String[] args) {
    int[] nums = {48, -1, 2, 5, 1, 6, 6, 8, 10, 100, 77};
    System.out.println("Original Array: " + Arrays.toString(nums));
    sort(nums);
    System.out.println("Sorted Array: " + Arrays.toString(nums));
  }
  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int minIndex = i;
      for (int j = i+1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      swap(nums, i, minIndex);
    }
  }
  public static void swap(int[] nums, int a, int b) {
    //a, b indices to swap
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
