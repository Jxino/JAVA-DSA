package sort;
import java.util.Scanner;

class HeapSort {
    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    static void downHeap(int[] a, int left, int right) {
        String.format("leftNodeIndex: %d | rightNodeIndex: %d", left, right);
        int temp = a[left];
        int biggerChild;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = biggerChild) {
            int leftChild = parent * 2 + 1;
            int rightChild = leftChild + 1;
            biggerChild = (rightChild <= right && a[rightChild] > a[leftChild]) ? rightChild : leftChild;
            if (temp >= a[biggerChild])
                break;
            a[parent] = a[biggerChild];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int arrSize) {
        for (int i = (arrSize - 1) / 2; i >= 0; i--) {
            downHeap(a, i, arrSize - 1);
        }

        for (int i = arrSize - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Heap Sort");
        System.out.print("arr size: ");
        int arrSize = stdIn.nextInt();
        int[] x = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            System.out.print(String.format("x[%d]: ", i));
            x[i] = stdIn.nextInt();
        }

        heapSort(x, arrSize);

        System.out.println("Sorted in ascending order.");
        for (int i = 0; i < arrSize; i++) {
            System.out.println(String.format("x[%d] = %d", i, x[i]));
        }
    }
}