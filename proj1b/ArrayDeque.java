/** Array based list.
 *  @author WYG
 */
public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private double usage_ratio() {
        return (double) size / items.length;
    }
    private void help_resize_down(double usageRatio){
        if (usageRatio <0.25 && items.length >16) {
            T[] a = (T[]) new Object[items.length / 2];
            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst+1, a, 0, nextLast-nextFirst-1);
            } else {
                System.arraycopy(items, nextFirst+1, a, 0, items.length-nextFirst-1);
                System.arraycopy(items, 0, a, items.length-nextFirst-1, nextLast);
            }
            items = a;
            nextFirst = items.length -1;
            nextLast = size;
        }
    }
    private void resize(){
        T[] a = (T[]) new Object[items.length*4];
        if (nextFirst == items.length - 1) {
            System.arraycopy(items, 0, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst+1, a, 0, size-nextFirst-1);
            System.arraycopy(items, 0, a, size-nextFirst-1, nextLast);
        }
        items = a;
        nextFirst = items.length -1;
        nextLast = size;
    }
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
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
    @Override
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
    @Override
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
        help_resize_down(usage_ratio());
        return res;

    }
    @Override
    public T removeLast(){
        if (size == 0) {
            return null;
        }
        size--;
        T res;
        if (nextLast == 0) {
            res = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length-1;
        } else {
            res = items[nextLast-1];
            items[nextLast-1] = null;
            nextLast--;
        }
        help_resize_down(usage_ratio());
        return res;
    }
    @Override
    public T get(int index) {
        if (nextFirst+index+1 < items.length) {
            return items[nextFirst+index+1];
        } else {
            return items[index-items.length+nextFirst+1];
        }
    }
    @Override
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
//    public static void main(String[] args){
//        ArrayDeque test=new ArrayDeque();
//        test.addFirst(0);
//        test.addLast(1);
//        test.addLast(2);
//        test.addLast(3);
//        test.addFirst(4);
//        test.addFirst(5);
//        test.size();
//        test.addFirst(7);
//        test.addFirst(8);
//        test.addLast(9);
//        test.addFirst(0);
//        test.addLast(1);
//        test.addLast(2);
//        test.addLast(3);
//        test.addFirst(4);
//        test.addFirst(5);
//        test.size();
//        test.addFirst(7);
//        test.addFirst(8);
//        test.addLast(9);
//        test.addFirst(7);
//        test.addFirst(8);
//        test.addLast(9);
//        test.addFirst(0);
//        test.addLast(1);
//        test.addLast(2);
//        test.addLast(3);
//        test.addFirst(4);
//        test.addFirst(5);
//        test.size();
//        test.addFirst(7);
//        test.addFirst(8);
//        test.addLast(9);
//        test.printDeque();
//        System.out.println(test.get(1));
//    }
}
