import model.PowerOfTwoMaxHeap;

public class Main {
    public static void main(String[] args) {

            PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(3);
            heap.insert(100);
            heap.insert(50);

            heap.printHeap();
            System.out.println(heap.popMax());
            System.out.println(heap.popMax());
            heap.printHeap();
        }
}