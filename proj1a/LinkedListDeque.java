public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node next;
        public Node last;

        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new Node(null, null);//需要修复
        sentinel.last=sentinel;
        sentinel.next=sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(item, sentinel.next);
        sentinel.next.last = sentinel;
        sentinel.next.next.last = sentinel.next;
    }

    public void addLast(T item) {
        size += 1;
        sentinel.last.next= new Node(item, sentinel);
        sentinel.last.next.last = sentinel.last.next;
        sentinel.last=sentinel.last.next;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){//感觉有问题
        while(sentinel.next.item != null){
            System.out.print(sentinel.item+" ");
            sentinel = sentinel.next;
        }
    }
    public T removeFirst(){
        T front =sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.last=sentinel;
        return front;
    }
    public T removeLast(){
        T back=sentinel.last.item;
        sentinel.last=sentinel.last.last;
        sentinel.last.next=sentinel;
        return back;
    }
    public T get(int index){
        Node temp=sentinel.next;
        while(index!=0){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }
    public T getRecursive(int index) {
        if (index>0){
            return sentinel.next.item;
        } else{
            return getRecursive(--index);
        }
    }
}
