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
        
        /****************  To Do  *************/
        
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
        
        /****************  To Do  *************/
        
    }
    
    /**
     *  Add an element after current. After this call, current
     *  is the element added.
     *  @param newData the data to add
     */
    public void add(T newData) {
        
        /****************  To Do  *************/
        
        if (cur == null) {  // add first element to the list
            
        } else {           // add element after current to existing list
            
        }
        
        // increment size of the list

    }
    
    /**
     *  Get the data at the current node in this list.
     *  @return data at current.
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T getCurrent() throws CircularlyLinkedListException {
        
        /****************  To Do  *************/

        // this is a stub - so that we can compile during the test phase
        return null;
    }
    
    /**
     *  Advance n positions in this list.  After this call, 
     *  current is n positions farther along the list.
     *  @param n the number of positions to advance
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public void advance(int n) throws CircularlyLinkedListException {
        
        /****************  To Do  *************/

    }
    
    /**
     *  Advance to element in this list, testing for equality
     *  using the equals method.  After this call, the node
     *  containing element is current.
     *  @param element the element to advance to
     *  @throws CircularlyLinkedListException if the element is not in the list.
     */
    public void advance(T element) throws CircularlyLinkedListException {
        
        /****************  To Do  *************/

    }
    
    /**
     *  Remove the current node in this list and return the element
     *  removed.  After this call, current is the element after the
     *  removed element.
     *  @return the deleted element
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T remove() throws CircularlyLinkedListException {
        
        /****************  To Do  *************/

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
