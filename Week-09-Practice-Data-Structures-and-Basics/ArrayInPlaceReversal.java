import java.util.Arrays;

public class ArrayInPlaceReversal {
    public static void reverseInPlace(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};
        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}