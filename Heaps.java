//Java Program to implement Heaps
public class MaxHeap {
    private int[] heap;
    private int size;
    public int capacity;
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity + 1]; // index starts from 1
        size = 0;
    }
    void insert(int item) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        int i = ++size;
        while (i > 1 && item > heap[i / 2]) {
            heap[i] = heap[i / 2];
            i = i / 2;
        }
        heap[i] = item;
    }
    public int deleteMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int max = heap[1];
        heap[1] = heap[size];
        size--;
        adjust(1);
        return max;
    }
    void adjust(int i) {
        int j = 2 * i;
        int item = heap[i];
        while (j <= size) {
            if (j < size && heap[j] < heap[j + 1])
                j++;
            if (item >= heap[j])
                break;
            heap[j / 2] = heap[j];
            j = 2 * j;
        }
        heap[j / 2] = item;
    }
    public int searchMax() {
        if (size == 0)
            return -1;
        return heap[1];
    }
    public void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(10);
        h.insert(40);
        h.display();
        h.insert(35);
        h.display();
        h.insert(80);
        h.display();
        h.insert(70);
        h.display();
        h.insert(85);
        h.display();
        System.out.println("Deleted element: " + h.deleteMax());
        h.display();
    }
}
