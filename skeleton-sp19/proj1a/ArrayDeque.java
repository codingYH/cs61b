import java.text.DecimalFormat;
import java.util.Objects;

public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private  int nextFirst;
    private  int nextLast;
    private int size;

    public ArrayDeque(){
        int size = 0;
        nextFirst = 3;
        nextLast = 4;
        array = (T[])new Object[8];

    }
    public ArrayDeque(ArrayDeque other){
        //is Object!!! not Objects!!!
        array = (T[])new Object[other.array.length];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
        System.arraycopy(other.array,0,array,0,other.array.length);
        //array
//        for(int i =0; i < other.array.length; i++){
//            array[i] = (T) other.array[i];
//        }
    }
    //resize
    //s is the size of resized arrayList
    private void resize(int s){
        T[] arrayL = (T[])new Object[s];
        System.arraycopy(array, 0, arrayL, 0, size);
        array = arrayL;
    }

    private void controlUsage(){
        if(size == array.length){
            resize(array.length * 3);
        }else if(((float)size/(float) array.length < 0.25)&&(array.length >= 16)){
            resize(array.length/2);
        }
    }

    @Override
    public void addFirst(T item) {
        controlUsage();
        array[nextFirst] = item;
        size = size + 1;
        if (nextFirst -1 == -1){
            nextFirst = array.length-1;
        }
        else {
            nextFirst --;
        }
    }

    @Override
    public void addLast(T item) {
        controlUsage();
        array[nextLast] = item;
        size ++;
        if (nextLast + 1 == array.length){
            nextLast = 0;
        }else {
            nextLast ++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i =0; i < array.length; i++){
            if (!(array[i]== null)) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        controlUsage();
        T t = (T) new Object();
        if (nextFirst +1 == array.length){
            t = array[0];
            array[0] = null;
            size --;
            return t;
        }
        else {
            t = array[nextFirst + 1];
            array[nextFirst + 1] = null;
            size --;
            return t;
        }
    }

    @Override
    public T removeLast() {
        controlUsage();
        T t = (T) new Object();
        if(nextLast -1 == -1){
            t = array[array.length -1];
            array[array.length -1] = null;
            size --;
            return  t;
        }
        else {
            t = array[nextLast -1];
            array[nextLast -1] = null;
            size --;
            return t;
        }
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}
