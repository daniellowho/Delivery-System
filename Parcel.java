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


