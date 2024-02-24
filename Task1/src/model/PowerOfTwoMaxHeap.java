package model;
import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap {
    private List<Integer> heap;
    private int x;

    public PowerOfTwoMaxHeap(int var1) {
        this.x = var1;
        this.heap = new ArrayList();
    }

    public void insert(int var1) {
        this.heap.add(var1);
        this.heapifyUp(this.heap.size() - 1);
    }

    private void heapifyUp(int var1) {
        for(int var2 = (var1 - 1) / (1 << this.x); var1 > 0 && (Integer)this.heap.get(var1) > (Integer)this.heap.get(var2); var2 = (var2 - 1) / (1 << this.x)) {
            this.swap(var1, var2);
            var1 = var2;
        }

    }

    public int popMax() {
        if (this.heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        } else {
            int var1 = (Integer)this.heap.get(0);
            int var2 = (Integer)this.heap.remove(this.heap.size() - 1);
            if (!this.heap.isEmpty()) {
                this.heap.set(0, var2);
                this.heapifyDown(0);
            }

            return var1;
        }
    }

    private void heapifyDown(int var1) {
        for(int var2 = this.findMaxChildIndex(var1); var2 != -1 && (Integer)this.heap.get(var1) < (Integer)this.heap.get(var2); var2 = this.findMaxChildIndex(var2)) {
            this.swap(var1, var2);
            var1 = var2;
        }

    }

    private int findMaxChildIndex(int var1) {
        int var2 = -1;
        int var3 = var1 * (1 << this.x) + 1;
        int var4 = Math.min(this.heap.size(), (var1 + 1) * (1 << this.x) + 1);

        for(int var5 = var3; var5 < var4; ++var5) {
            if (var2 == -1 || (Integer)this.heap.get(var5) > (Integer)this.heap.get(var2)) {
                var2 = var5;
            }
        }

        return var2;
    }

    private void swap(int var1, int var2) {
        int var3 = (Integer)this.heap.get(var1);
        this.heap.set(var1, this.heap.get(var2));
        this.heap.set(var2, var3);
    }
    public void printHeap() {
        System.out.print("\nmodel.PowerOfTwoMaxHeap = ");
        for (Integer integer : heap) System.out.print(integer + " ");
        System.out.println();
    }
}
