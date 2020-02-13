import java.text.DecimalFormat;
import java.util.Objects;

public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    //array's pointer differ with linkedList
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque(){
        array = (T[])new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }
    public ArrayDeque(ArrayDeque other){
        array = (T[])new Object[other.array.length];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
        System.arraycopy(other.array, 0 , array, 0 ,other.array.length);
    }
    private void resize(int length){
        T[] newArray = (T[]) new Object[length];
        //newArray start from 0
        int ni = 0;
        for(int i = 0; i < array.length; i++){
            if (!(array[i] == null)){
                newArray[ni] = array[i];
                ni ++;
            }
        }
        nextFirst = length - 1;
        nextLast = size;
        array = newArray;
    }
    private void controlUsage(){
        float usageRate = (float)size/(float)array.length;
        if (size == array.length){
            resize(array.length*2);
        }else if ((usageRate < 0.25) && (size >= 16)){
            resize(array.length/2);
        }

    }
    @Override
    public void addFirst(T item) {
        controlUsage();
        // size ++ should after controlUsage
        size ++;
        array[nextFirst] = item;
        if(nextFirst - 1 <0){
            nextFirst = array.length -1;
        }else {
            nextFirst = nextFirst - 1;
        }
    }

    @Override
    public void addLast(T item) {
        controlUsage();
        size++;
        array[nextLast] = item;
        if(nextLast + 1 > array.length -1){
            nextLast = 0;
        }else {
            nextLast = nextLast + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for(int i = 0; i < array.length; i++){
            if(!(array[i] == null)){
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T item;
        controlUsage();
        size--;
        if(nextFirst + 1 > array.length-1){
            item = array[0];
            array[0] = null;
            nextFirst = 0;
        }else {
            item = array[nextFirst + 1];
            array[nextFirst + 1] = null;
            nextFirst = nextFirst + 1;
        }
        return item;
    }

    @Override
    public T removeLast() {
        T item;
        controlUsage();
        size --;
        if (nextLast -1 < 0){
            item = array[array.length-1];
            array[array.length-1] = null;
            nextLast = array.length-1;
        }else {
            item = array[nextLast -1];
            array[nextLast -1] = null;
            nextLast = nextLast - 1;
        }
        return item;
    }

    @Override
    public T get(int index) {
//        resize(array.length);
        if((index > array.length - 1)||(index < 0)){
            return null;
        }
        else{
            return array[index];
        }
    }
}
