class Node {
    //for linked list
    Parcel data;
    Node next;

    Node(Parcel data) {
        this.data = data;
        this.next = null;
    }
}

class Parcel {
    int weight;
    int index;

    Parcel(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }
}


class ParcelQueue {
    Node front;
    Node rear;

    ParcelQueue() {
        front = null;
        rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Parcel p) {
        Node newNode = new Node(p);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    Parcel dequeue() {
        if (isEmpty()) {
            return null;
        }

        Parcel removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return removed;
    }
}
