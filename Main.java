import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter truck capacity (kg): ");
        int capacity = sc.nextInt();

        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();

        ParcelQueue queue = new ParcelQueue();
        MaxHeap maxHeap = new MaxHeap(n);
        AVLTree avl = new AVLTree();
        HashMap<Integer, String> statusMap = new HashMap<>();
        ArrayList<Parcel> rejected = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter weight of parcel " + i + ": ");
            int weight = sc.nextInt();

            Parcel parcel = new Parcel(weight, i);
            queue.enqueue(parcel);
            avl.insert(weight);
            statusMap.put(i, "PENDING");
        }

        while (!queue.isEmpty()) {
            maxHeap.insert(queue.dequeue());
        }

        int remainingCapacity = capacity;

        System.out.println("\nLoaded Parcels:");
        while (!maxHeap.isEmpty()) {
            Parcel best = maxHeap.extractMax();

            if (best.weight <= remainingCapacity) {
                remainingCapacity -= best.weight;
                statusMap.put(best.index, "LOADED");
                avl.delete(best.weight);
                System.out.println("Weight: " + best.weight);
            } else {
                statusMap.put(best.index, "REJECTED");
                avl.delete(best.weight);
                rejected.add(best);
            }
        }

        System.out.println("\nRemaining Capacity: " + remainingCapacity);

        System.out.println("\nRejected Parcels:");
        if (rejected.isEmpty()) {
            System.out.println("None");
        } else {
            for (Parcel p : rejected) {
                System.out.println("Weight: " + p.weight);
            }
        }

        System.out.println("\nParcel Status:");
        for (int i = 1; i <= n; i++) {
            System.out.println("Parcel " + i + ": " + statusMap.get(i));
        }
    }
}
