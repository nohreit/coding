package algorithm.crud.array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayManip<T> {
    private int size;
    private Object[] array;
    private int numElements;

    public ArrayManip() {
        this.size = 1;
        this.array = new Object[size];
        this.numElements = 0;
    }

    private boolean isEmpty() {
        return this.numElements == 0;
    }

    private int size() {
        return this.array.length;
    }

    private boolean isFull(){
        return this.numElements == this.size();
    }

    @Test
    public void run(){
        ArrayManip<Integer> intArr = new ArrayManip<>();
        intArr.addAll(new Object[]{-8, -9, 57, 10, 23, 89, -36});
//        intArr.remove();
        intArr.display();
    }

    public void add(T value) {
        if(isFull()) this.expand();
        this.array[numElements] = value;
        this.numElements++;
    }

    public void addAll(Object[] items){
        for (Object item: items) {
            this.add((T)item);
        }
    }

    public void insertAt(T value, int index){
        if(isFull()) this.expand();
        for (int i = this.numElements; i > index; i--) {
            this.array[i] = this.array[i-1];
        }
        this.array[index] = value;
        this.numElements++;
    }

    public void insertAllAt(Object[] items, int index){
        for (Object item: items){
            this.insertAt((T)item, index);
        }
    }

    public void updateAt(int index, T value){
        this.array[index] = value;
    }

    public void updateFromTo(int start, int end, Object[] items){
        int i = 0;
        while(start <= end){
            this.array[start++] = items[i++];
        }
    }

    public void updateAll(Object[] items){
        this.updateFromTo(0, this.size(), items);
    }

    public void addAtBegin(T value){
        this.insertAt(value, 0);
    }

    public void addAtEnd(T value){
        this.add(value);
    }

    public void remove(T value){
        this.removeAt(this.findIndex(this.array, value));
    }

    public void removeFromTo(int start, int end){
        while (start <= end) {
            this.removeAt(start++);
        }
    }
    public void removeAt(int index){
        this.array[index] = null;
        this.numElements--;
        this.shrink();
    }

    public void removeAtBegin(T value){
        this.removeAt(0);
    }

    public void removeAtEnd(T value){
        this.removeAt(this.numElements);
    }

    private void expand(){
        Object[] sub = this.array;
        this.array = new Object[this.size()*2];
        System.arraycopy(sub, 0, this.array, 0, sub.length);
    }
    
    private void shrink(){
        Object[] sub = this.array;
        this.array = new Object[this.numElements];
        System.arraycopy(sub, 0, this.array,0, this.size());
    }

    private int findIndex(Object[] array, T value){
        int index = 0;
        while (index < this.numElements){
            if(array[index] == value){

                break;
            }
            index++;
        }
        return index;
    }

    private boolean isFound(){
        return false;
    }

    public void clear(){
        this.array = new Object[this.size()];
        this.numElements = 0;
    }

    public void display(){
        p(Arrays.asList(this.array));
    }

    public static void pln(Object o){
        System.out.println(o);
    }

    public static void p(Object o){
        System.out.print(o);
    }

}
