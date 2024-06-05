/**
 A class to store and manipulate generic circularly linked lists
 */
public class CircularlyLinkedList<T> {
    
    private ListNode cur;
    private ListNode prev;
    private int size; 
    
    /**
     *  Default constructor.  Creates an empty list
     */
    public CircularlyLinkedList() {
        cur = null;
        prev = null;
        size = 0;
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
        cur = prev = null;
        size = 0;
    }
    
    /**
     *  Add an element after current. After this call, current
     *  is the element added.
     *  @param newData the data to add
     */
    public void add(T newData) {
        
        ListNode newNode = new ListNode(newData); 
        
        if (cur == null) {  // add first element to the list
            cur = newNode;
            cur.link = cur;
            prev = cur;
        } else {           // add element after current to existing list
            newNode.link = cur.link;
            cur.link = newNode;
            prev = cur;
            cur = newNode;
        }
        
        // increment size of the list
        size++;  
    }
    
    /**
     *  Get the data at the current node in this list.
     *  @return data at current.
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T getCurrent() throws CircularlyLinkedListException {
        
        // Empty list - can't get
        if (cur == null) {
            throw new CircularlyLinkedListException
                ("Attempting to get element from an empty list.");
        }
        return cur.data;
    }
    
    /**
     *  Advance n positions in this list.  After this call, 
     *  current is n positions farther along the list.
     *  @param n the number of positions to advance
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public void advance(int n) throws CircularlyLinkedListException {
        
        // Empty list - can't advance
        if (cur == null) {
            throw new CircularlyLinkedListException
                ("Attempting to advance in an empty list.");
        }
        
        // Advance n times,setting cur and prev each time
        for (int i=0; i<n; i++) {
            prev = cur;
            cur = cur.link;
        }
    }
    
    /**
     *  Advance to element in this list, testing for equality
     *  using the equals method.  After this call, the node
     *  containing element is current.
     *  @param element the element to advance to
     *  @throws CircularlyLinkedListException if the element is not in the list.
     */
    public void advance(T element) throws CircularlyLinkedListException {
        ListNode position = cur;
        ListNode beforePos = prev;
        
        // Empty list - can't advance
        if (cur == null) {
            throw new CircularlyLinkedListException
                ("Attempting to advance in an empty list.");
        }
        
        // Find the element and set cur and prev accordingly
        for (int i=0; i<size; i++) {
            if (position.data.equals(element)) {
                cur = position;
                prev = beforePos;
                return;
            }
            beforePos = position;
            position = position.link;
        }
        
        // If we get here, the element wasn't found
        throw new CircularlyLinkedListException
            (element + " not in the list.");
    }
    
    /**
     *  Remove the current node in this list and return the element
     *  removed.  After this call, current is the element after the
     *  removed element.
     *  @return the deleted element
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T remove() throws CircularlyLinkedListException {
        
        T rval = null;
        
        // Empty list - nothing to delete
        if (cur == null) {
            throw new CircularlyLinkedListException
                ("Attempting to remove from an empty list.");
        }
        
        if (cur.link == cur) {
            // Only 1 element in this list
            rval = cur.data;
            cur = null;
            prev = null;
        } else {
            // More than 1 element in this list
            rval = cur.data;
            cur = cur.link;
            prev.link = cur;
        }
        
        // Decrement size
        size--;
        
        return rval;
    }
    
    /**
     *  Get a string representation of this list, starting at
     *  the current element.
     *  @return a string representation of this list.
     */
    public String toString() {
        
        String rval = "";
        ListNode position = cur;
        
        for (int i=0; i<size; i++) {
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
