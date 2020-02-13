import java.security.PublicKey;

public class LinkedListDeque<T> implements Deque<T>  {
    private class Node{
        private T item;
        private Node next;
        private Node prev;

        private Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev =  sentinel;
        size = 0;

    }
    public LinkedListDeque(LinkedListDeque other){
        //init deque, all thing should start from zero include size
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev =  sentinel;
        //start from size o , but not other.size
        size = 0;
        Node pOfOther = other.sentinel.next;
        for(int i = 0; i < other.size; i++){
            //can't pOfThis.next =pOfOther.next , it would change other
            addLast(pOfOther.item);
            pOfOther = pOfOther.next;
        }

    }
    @Override
    public void addFirst(T item) {
        size ++;
        sentinel.next = new Node(item, sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }
    @Override
    public void addLast(T item) {
        size ++;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
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
    public T removeFirst() {
        size --;
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return  item;
    }
    @Override
    public T removeLast() {
        size --;
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return  item;
    }
    /*
    * use iteration
    * */
    @Override
    public T get(int index) {
        if((index > size-1)||(index < 0)){
            return null;
        }else {
            //need a pointer
            Node p = sentinel;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    public void printDeque() {
        //need a pointer
        Node p = sentinel.next;
        for (int i =0; i < size ; i++){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println();
    }
    //recursive method should have a  param can be recursive. Like the Node p of method getStartFromPointer
    // start from sentinel.next
    public T getRecursive(int index){
        return getStartFromPointer(sentinel.next, index);
    }
    //start from a pointer
    public T getStartFromPointer(Node p, int index){
        if(index == 0){
            return p.item;
        }
        else {
            return getStartFromPointer(p.next, index-1);
        }
    }
}
