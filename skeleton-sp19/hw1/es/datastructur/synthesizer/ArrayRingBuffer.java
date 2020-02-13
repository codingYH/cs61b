package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T>  implements BoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        if(isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }else {
            rb[last] = x;
            if(last + 1 > rb.length -1){
                last = 0;
            }else {
                last ++;
            }
            fillCount ++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }else {
            T r = rb[first];
            if(first + 1 > rb.length -1){
                first = 0;
            }else {
                first ++;
            }
            fillCount --;
            return r;
        }
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T r = rb[first];
        return r;
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator{
        private int i;
        public BufferIterator(){
            i = 0;
        }
        @Override
        public boolean hasNext() {
            return i < rb.length;
        }

        @Override
        public T next() {
            T t = rb[i];
            i ++;
            return t;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == ArrayRingBuffer.class){
            ArrayRingBuffer ia = (ArrayRingBuffer)obj;
            T[] ra = (T[]) ia.rb;
            if(ra.length == rb.length){
                for(int i = 0; i < rb.length; i++){
                    if(ra[i] != rb[i]) return false;
                }
                return true;
            }
        }
        return false;
    }
}
