package algorithm.sorting.tree;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<T> {
    protected ArrayList<T> items; //array to store our heap items
    private Comparator<? super T> comparator;

    public MaxHeap() {
        items = new ArrayList<T>();
    }

    public MaxHeap(Comparator<? super T> comparator) {
        items = new ArrayList<T>();
        this.comparator = comparator;
    }

    public MaxHeap(ArrayList<T> arr) {
        items = arr;
        this.heapifyUp();
    }

    //O(1)
    public boolean isEmpty() {
        return (items.size() != 0);
    }

    //O(1)
    public T peek() {
        if (isEmpty()) {
            return items.get(0);
        }
        return null;
    }

    //insert O(log n)
    public void insert(T item) throws HeapException {
        if (!items.add(item)) {
            throw new HeapException("Heap Insertion Failed");
        }
        int loc = items.size() - 1; //calculate location of the item by finding the last valid index of the arraylist...that it was added to
        int parentIndex = (loc - 1) / 2; //calculate parent index

        while ((parentIndex >= 0) && (compareItems(items.get(loc), items.get(parentIndex)) > 0)) {
            swap(loc, parentIndex, items);
            loc = parentIndex;
            parentIndex = (loc - 1) / 2; //calculate the new parent index
        }
    }

    //O(log n)
    public T heapDelete() {
        T rootItem = null;
        if (isEmpty()) {
            rootItem = items.get(0);//get and store root item
            int loc = items.size() - 1;//calculate index of last item
            items.set(0, items.get(loc)); //place item from last index into the root at index 0
            items.remove(loc);//remove the last value from the items arraylist
            heapRebuild(0);
        }

        return rootItem;
    }


    protected void heapRebuild(int rootIndex) {
        int childIndex = (2 * rootIndex) + 1;
        if (childIndex < items.size()) {
            int rightChildIndex = childIndex + 1;
            if ((rightChildIndex < items.size()) &&
                    (compareItems(items.get(rightChildIndex), items.get(childIndex)) > 0)) {
                childIndex = rightChildIndex; //use rightChild to compare against the parent since it is the larger of the 2 children
            }
            if (compareItems(items.get(rootIndex), items.get(childIndex)) < 0) {
                swap(rootIndex, childIndex, items);//child is greater than the parent so we need to swap
                heapRebuild(childIndex);//recursive call to make the subtree into a heap (MOVE DOWNWARD and compare)
            }
        }
    }

    private void swap(int i, int j, ArrayList<T> arr) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    @SuppressWarnings("unchecked")
    private int compareItems(T item1, T item2) {
        if (comparator == null) {
            return (((Comparable<T>) item1).compareTo(item2));
        }
        return comparator.compare(item1, item2);
    }

    private void heapifyUp() {
        for (int i = items.size() - 1; i >= 0; i--) {
            heapRebuild(i);
        }

    }

    //O ( n log n)
    public static <T> ArrayList<T> heapSort(ArrayList<T> arr) {
        MaxHeap<T> tempHeap = new MaxHeap<T>(arr);
        ArrayList<T> tempArr = new ArrayList<T>();
        while (tempHeap.isEmpty()) {
            T item = tempHeap.heapDelete();
            tempArr.add(item);
        }
        return tempArr;
    }
}