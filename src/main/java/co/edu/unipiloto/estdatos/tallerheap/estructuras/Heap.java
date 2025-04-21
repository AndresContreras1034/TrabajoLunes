package co.edu.unipiloto.estdatos.tallerheap.estructuras;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> heap;
    private boolean isMaxHeap;

    public Heap(boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
        this.heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        swim(heap.size() - 1);
    }

    public T extract() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");

        T top = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, last);
            sink(0);
        }

        return top;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void swim(int k) {
        while (k > 0 && compare(k, parent(k)) > 0) {
            exch(k, parent(k));
            k = parent(k);
        }
    }

    private void sink(int k) {
        int n = heap.size();
        while (left(k) < n) {
            int j = left(k);
            if (j + 1 < n && compare(j + 1, j) > 0) j++;
            if (compare(k, j) >= 0) break;
            exch(k, j);
            k = j;
        }
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int left(int k) {
        return 2 * k + 1;
    }

    private int right(int k) {
        return 2 * k + 2;
    }

    private void exch(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int compare(int i, int j) {
        return isMaxHeap
            ? heap.get(i).compareTo(heap.get(j))
            : heap.get(j).compareTo(heap.get(i));
    }
}
