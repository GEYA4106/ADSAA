import java.util.*;
public class MinHeap {
    static int[] heap;
    static int size;
    static void insert(int value) {
        size++;
        heap[size] = value;
        int i = size;
        while (i > 1 && heap[i / 2] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[i / 2];
            heap[i / 2] = temp;
            i = i / 2;
        }
    }
    static int delete() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        int i = 1;
        while (2 * i <= size) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int smallest = i;
            if (left <= size && heap[left] < heap[smallest])
                smallest = left;
            if (right <= size && heap[right] < heap[smallest])
                smallest = right;
            if (smallest != i) {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;
                i = smallest;
            } else {
                break;
            }
        }
        return min;
    }
    static void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum size of heap: ");
        int n = sc.nextInt();
        heap = new int[n + 1]; // 1-based indexing
        size = 0;
        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Display  4.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    insert(val);
                    break;

                case 2:
                    int deleted = delete();
                    if (deleted != -1)
                        System.out.println("Deleted element: " + deleted);
                    break;

                case 3:
                    System.out.print("Heap: ");
                    display();
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}