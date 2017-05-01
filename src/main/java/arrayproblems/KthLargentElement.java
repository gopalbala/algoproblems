package arrayproblems;

import java.util.Arrays;

/**
 * Created by gopalbala on 1/5/17.
 */
public class KthLargentElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        HeapSort sort = new HeapSort(arr.length);
        Arrays.stream(arr).forEach(sort::insert);
        System.out.println(sort.heap[3 -1]);
        //sort.heapSort();
    }
}

class HeapSort {
    int[] heap;
    int currentPosition = -1;

    public HeapSort(int size) {
        heap = new int[size];
    }

    public void insert(int item) {
        if (currentPosition == heap.length)
            throw new RuntimeException("Heap is full");
        heap[++currentPosition] = item;
        fixUp(currentPosition);
    }

    public void fixUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && heap[index] > heap[parentIndex]) {
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public void fixDown(int index, int upto) {
        if (upto < 0) {
            upto = currentPosition;
        }
        while (index <= upto) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (leftChild <= upto) {
                int childToSwap;
                if (rightChild > upto) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[childToSwap];
                    heap[childToSwap] = heap[index];
                    heap[index] = temp;
                } else
                    break;

                index = childToSwap;
            } else
                break;
        }
    }

    public void heapSort() {
        for (int i = 0; i < currentPosition; i++) {
            int temp = heap[0];
            System.out.print(temp + " ");
            heap[0] = heap[currentPosition - i];
            heap[currentPosition - i] = temp;
            fixDown(0, currentPosition - i - 1);
        }

        Arrays.stream(heap).forEach(System.out::print);
    }
}
