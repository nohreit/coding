package algorithm.sorting.tree;

public class HeapSort<T extends Comparable<? super T>> {
    private T[] heap;
    private int lastIndex;

    public void sort(T[] arrayToSort){
        this.heap = arrayToSort;
        this.lastIndex = arrayToSort.length-1;
        heapSort();
        showArray(arrayToSort, 0, this.heap.length-1);
    }

    private void heapSort() {
        for(int i = lastIndex - 1; i > 0; i--){
            T temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapify();
        }
    }

    private void heapify() {
        int last = lastIndex;
        int parent = (last - 1)/2;
        while (parent >=0){
            siftDown(parent);
            parent--;
        }
    }

    private void siftDown(int node) {
        while (node < lastIndex){
            int lc = (2*node) + 1;
            int rc = (2*node) + 2;
            int swap = node;
            if((lc < lastIndex) && (heap[node].compareTo(heap[lc]) < 0))
                swap = lc;
            if((rc < lastIndex) && (heap[swap].compareTo(heap[rc]) < 0))
                swap = rc;
            if (swap == node)
                return;
            else{
                T temp = heap[node];
                heap[node] = heap[swap];
                heap[swap] = temp;
                node = swap;
            }
        }
    }

    private void showArray(T[] arr, int first, int last) {
        p("array( " + first + ", "+ last + ") = [ ");
        for(int i= first; i<= last; i++) {
            if(i!= last) { //for the trailing comma
                p(arr[i]+ ", ");
            }else {
                p(arr[i]);
            }
        }
        pln("]");
    }

    public static void pln(Object o){
        System.out.println(o);
    }

    public static void p(Object o){
        System.out.print(o);
    }
}
