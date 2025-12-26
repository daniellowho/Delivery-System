class MaxHeap {

    Parcel[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new Parcel[capacity];
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void insert(Parcel p) {
        if (size == capacity) {
            return;
        }

        heap[size] = p;
        int i = size;
        size++;

        while (i > 0 && heap[parent(i)].weight < heap[i].weight) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    Parcel extractMax() {
        if (size <= 0) {
            return null;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        Parcel root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }

    void heapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left].weight > heap[largest].weight) {
            largest = left;
        }

        if (right < size && heap[right].weight > heap[largest].weight) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    void swap(int i, int j) {
        Parcel temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
