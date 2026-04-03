import java.util.*;
public class MergeSort {
    private static int[] b;
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    public static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= high) {
            b[k++] = a[j++];
        }
        for (int h = low; h <= high; h++) {
            a[h] = b[h];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num of array elements");
        int n = sc.nextInt();
        int[] array = new int[n];
        b = new int[n];
        System.out.println("enter array elements");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        mergeSort(array, 0, array.length - 1);
        System.out.println("sorted array");
        for (int e : array) {
            System.out.println(e + " ");
        }
        sc.close();
    }
}
