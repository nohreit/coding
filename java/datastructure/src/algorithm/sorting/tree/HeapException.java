package algorithm.sorting.tree;

public class HeapException extends Exception {

    public HeapException(){
        super("HeapException");
    }
    public HeapException(String message){
        super("HeapException: " + message);
    }
}
