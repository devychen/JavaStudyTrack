/**
 A class to store and manipulate generic circularly linked lists

 @author 阿夏
 */
public class CircularlyLinkedList<T> {

    private ListNode cur;
    private ListNode prev;
    private int size;

    /**
     *  Default constructor.  Creates an empty list
     */
    public CircularlyLinkedList() {
        // TODO - ???
        // 初始化一个空的循环链表
        // this关键字用于引用当前对象的实例变量或方法, 明确表明我们正在初始化当前对象的实例变量，而不是局部变量
        this.cur = null;
        this.prev = null;
        this.size = 0;
    }

    /**
     * Get the size of the list.
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     *  Removes all of the elements from this list.
     */
    public void clear() {
        // TODO - ???
        this.cur = null;
        this.prev = null;
        this.size = 0;
    }

    /**
     *  Add an element after current. After this call, current
     *  is the element added.
     *  @param newData the data to add
     */
    public void add(T newData) {

        // TODO - Done
        ListNode newNode = new ListNode(newData);

        if (cur == null) {  // add first element to the list
            cur = newNode;
            cur.link = cur; // circular link
            prev = cur;
        } else {           // add element after current to existing list
            // now: n1 -> n2(cur) -> n3
            // to: n1 -> n2 -> n3, & new -> n3
            newNode.link = cur.link;
            // to: n1 -> n2 -> new -> n3
            cur.link = newNode;
            prev = cur; // update prev to be the old cur
            cur = newNode; // move cur to the new node
        }

        // increment size of the list
        size ++;
    }

    /**
     *  Get the data at the current node in this list.
     *  @return data at current.
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T getCurrent() throws CircularlyLinkedListException {

        // TODO - ???
        if (cur == null) {
            throw new CircularlyLinkedListException("Attempt to get current element from an empty list");
        }
        return cur.data;
    }

    /**
     *  Advance n positions in this list.  After this call,
     *  current is n positions farther along the list. (i.e.向尾部移动n个节点)
     *  @param n the number of positions to advance
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public void advance(int n) throws CircularlyLinkedListException {

        // TODO - ???
        if (cur == null) {
            throw new CircularlyLinkedListException("Attempt to advance an empty list");
        } else if (n < 0) {
            throw new CircularlyLinkedListException("Attempt to advance a negative number");
        } else if (n > size - 1) {
            throw new CircularlyLinkedListException("Attempt to advance a number that is greater than the size of the list");
        } else {
            for (int i = 0; i < n; i++) {
                prev = cur;
                cur = cur.link;
            }
        }
        /*
        通过循环for (int i = 0; i < n; i++) {prev = cur; cur = cur.link}，
        我们在每次迭代中将cur节点向后移动一个位置，同时将prev更新为当前的cur。
        经过n次迭代后，cur指向原链表中的第n个位置，从而实现了向后移动n个节点的功能。
        初始状态:
        A -> B -> C -> D -> A
        ^
        cur

        第一次迭代:
        A -> B -> C -> D -> A
        ^    ^
        prev cur

        第二次迭代:
        A -> B -> C -> D -> A
             ^    ^
            prev  cur

        第三次迭代:
        A -> B -> C -> D -> A
                  ^    ^
                 prev  cur
         */

    }

    /**
     *  Advance to element in this list, testing for equality
     *  using the `equals` method.  After this call, the node
     *  containing element is current.
     *  @param element the element to advance to
     *  @throws CircularlyLinkedListException if the element is not in the list.
     */
    public void advance(T element) throws CircularlyLinkedListException {

        // TODO


    }

    /**
     *  Remove the current node in this list and return the element
     *  removed.  After this call, current is the element after the
     *  removed element.
     *  @return the deleted element
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T remove() throws CircularlyLinkedListException {

        // TODO

        // this is a stub - so that we can compile during the test phase
        return null;
    }

    /**
     *  Get a string representation of this list, starting at
     *  the current element.
     *  @return a string representation of this list.
     */
    public String toString() {

        String rval = "";
        ListNode position = cur;

        for (int i = 0; i < size; i++) {
            rval += position.data + " ";
            position = position.link;
        }

        return rval;
    }

    private class ListNode {
        private T data;
        private ListNode link;

        public ListNode() {
            data = null;
            link = null;
        }
        public ListNode(T newData) {
            data = newData;
            link = null;
        }
        public ListNode(T newData, ListNode aLink) {
            data = newData;
            link = aLink;
        }
    }
}
