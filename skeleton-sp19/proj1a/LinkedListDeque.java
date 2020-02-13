public class LinkedListDeque<T> implements Deque<T>  {
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        size = 0;
        //initial sentinel
        sentinel = new Node(null, null , null );
        //circular list
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public LinkedListDeque(LinkedListDeque other){
        size = 0;
        //initial sentinel
        sentinel = new Node(null, null , null );
        //circular list
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        for (int i = 0; i < other.size; i++){
            addLast((T) other.get(i));
        }
    }

    @Override
    public void addFirst(T item) {
        //change sentinel.next new node
        sentinel.next = new Node(item, sentinel, sentinel.next);
        //list has been modified. change sentinel.next.next.prev
        sentinel.next.next.prev = sentinel.next;
        size = size + 1;
    }
    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size = size + 1;
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
        if(sentinel.next.equals(sentinel)){
            return null;
        }else {
            //get item
            Node n = sentinel.next;
            //change sentinel.next
            sentinel.next = sentinel.next.next;
            //list has been modified. change sentinel.next
            sentinel.next.prev = sentinel;
            size--;
            return n.item;
        }
    }
    @Override
    public T removeLast() {
        if (sentinel.prev.equals(sentinel)){
            return null;
        }else {
            Node n = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size--;
            return n.item;
        }
    }
    /*
    * use iteration
    * */
    @Override
    public T get(int index) {
        Node n = sentinel;
       for(int i = 0; i <= index; i++){
           n = n.next;
       }
       return n.item;
    }

    public void printDeque() {
        Node n = sentinel;
        for (int i = 0; i < size; i++){
            n = n.next;
            System.out.print(n.item + " ");
        }
        System.out.println();
    }
    //start from sentinel.next
    public T getRecursive(int index){
        if(index > size-1){
            throw new IllegalArgumentException("out of range of list");
        }else{
            return pointer(sentinel.next, index);
        }

    }
    // start from p, find index times next
    public T pointer(Node p, int index){
        if (index ==0 ){
            return p.item;
        } else {
            return pointer(p.next, index-1);
        }

    }


    private  class Node {
        public T item;
        public Node prev;
        public Node next;

        private Node(T i, Node n1, Node n2){
            item = i;
            prev = n1;
            next = n2;
        }

    }
}
