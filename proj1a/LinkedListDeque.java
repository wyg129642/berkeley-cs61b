public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new Node(null, null);//需要修复
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(T item) {
        size += 1;
        sentinel.prev.next= new Node(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev=sentinel.prev.next;
    }
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }else{
            size--;
            T front =sentinel.next.item;
            sentinel.next=sentinel.next.next;
            sentinel.next.prev=sentinel;
            return front;
        }
    }
    public T removeLast(){
        if (isEmpty()){
            return null;
        }else{
            size--;
            T back=sentinel.prev.item;
            sentinel.prev=sentinel.prev.prev;
            sentinel.prev.next=sentinel;
            return back;
        }
    }
    public T get(int index){
        if (index>=size){
            return null;
        }
        Node ptr=sentinel.next;
        while(index!=0){
            ptr=ptr.next;
            index--;
        }
        return ptr.item;
    }
    public void printDeque(){//感觉有问题
        while(sentinel.next.item != null){
            System.out.print(sentinel.item+" ");
            sentinel = sentinel.next;
        }
    }

    public T getRecursive(int index) {
            return getRecursive_help(sentinel, index);
    }
    public T getRecursive_help(Node ptr, int index){
        if (index==0){
            return ptr.next.item;
        }
        else{
            return getRecursive_help(ptr.next, --index);
        }
    }
}
