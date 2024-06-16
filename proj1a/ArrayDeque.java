/** Array based list.
 *  @author WYG
 */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private void resize(){}
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize();
        }
        size++;
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length-1;
        } else {
            nextFirst--;
        }
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        size++;
        items[nextLast] = item;
        if (nextLast==items.length-1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T res;
        if (nextFirst == items.length-1) {
            res = items[0];
            items[0] = null;
            nextFirst = 0;
        } else {
            res = items[nextFirst+1];
            items[nextFirst+1] = null;
            nextFirst++;
        }
        return res;

    }
    public T removeLast(){
        if (size == 0) {
            return null;
        }
        size--;
        T res;
        if (nextLast == 0) {
            res = items[items.length-1];
            items[items.length-1] = null;
            nextLast = items.length-1;
        } else {
            res = items[nextLast-1];
            items[nextLast-1] = null;
            nextLast--;
        }
        return res;
    }
    public T get(int index) {
        if (nextFirst+index+1 < items.length) {
            return items[nextFirst+index+1];
        } else {
            return items[index-items.length+nextFirst+1];
        }
    }
    public void printDeque() {
        if (nextFirst < nextLast) {
            for (int i = nextFirst+1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = nextFirst+1; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }

}
