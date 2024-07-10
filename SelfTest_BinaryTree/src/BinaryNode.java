/**
 * A class that represents a node in a binary tree.
 */

class BinaryNode<T> implements java.io.Serializable {
    
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    
    /**
     * Construct an empty binary node.
     */
    public BinaryNode() {
        this(null); // call next constructor
    } 
    
    /**
     * Construct a new node with the specified data.
     * @param dataPortion the data object to add
     */
    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null); // call next constructor
    }
    
    /**
     * Construct a new node with the specified data and children
     * @param dataPortion the data contained in the new node
     * @param leftChild the left node
     * @param rightChild the right node
     */
    public BinaryNode(T dataPortion,
                      BinaryNode<T> leftChild,
                      BinaryNode<T> rightChild) {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    }
    
    /**
     * Get the data at this node
     * @return the data at this node
     */
    public T getData() {
        return data;
    }
    
    /**
     * Set the data at this node
     * @param newData the data to store at this node
     */
    public void setData(T newData) {
        data = newData;
    }
    
    /**
     * Get the left child of this node
     * @return the left child of this node
     */
    public BinaryNode<T> getLeftChild() {
        return left;
    }
    
    /**
     * Get the right child of this node
     * @return the right child of this node
     */
    public BinaryNode<T> getRightChild() {
        return right;
    }
    
    /**
     * Set the left child of this node
     * @param leftChild the new left child
     */
    public void setLeftChild(BinaryNode<T> leftChild) {
        left = leftChild;
    }
    
    /**
     * Set the right child of this node
     * @param rightChild the new right child
     */
    public void setRightChild(BinaryNode<T> rightChild) {
        right = rightChild;
    }
    
    /**
     * Determine if this node has a left child
     * @return true if this node has a left child, false otherwise
     */
    public boolean hasLeftChild() {
        return left != null;
    }
    
    /**
     * Determine if this node has a right child
     * @return true if this node has a right child, false otherwise
     */
    public boolean hasRightChild() {
        return right != null;
    }
    
    /**
     * Return true if it's a leaf, otherwise false
     * @return true if this node is a leaf, false otherwise
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
    
    /**
     * Get a String representation of this node
     * @return a String representation of this node
     */
    public String toString() {
        return data.toString();
    }
}
