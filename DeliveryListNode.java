
/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * Recitation 02
 * DeliveryListNode Class that creates the links between Nodes.
 */


public class DeliveryListNode{

    /**
     * data field of Delivery Class
     * next reference of DeliveryListNode class serves as link
     * prev reference of DeliveryListNode class serves as link
     */
    private Delivery data;
    private DeliveryListNode next;
    private DeliveryListNode prev;

    /**
     * Parameterized Constructor for DeliveryListNode
     * @param initialData of Delivery Class.
     * @throws IllegalArgumentException is thrown if data is null
     */
    public DeliveryListNode(Delivery initialData) throws IllegalArgumentException{
        if(initialData==null){
            throw new IllegalArgumentException("The data is null");
        }
        data=initialData;
        this.next=null;
        this.prev=null;

    }

    /**
     * Accessor method for Data
     * @return data
     * @throws EmptyListException is thrown if data is empty
     */
    public Delivery getData()throws EmptyListException {
        if(data==null)throw new EmptyListException("Data entered is Empty"); //
        return this.data;
    }
    /**
     * Accessor method for next
     * @return next
     */
    public DeliveryListNode getNext(){
        return this.next;
    }
    /**
     * Accessor method for prev
     * @return prev
     */
    public DeliveryListNode getPrev() {
        return this.prev;
    }

    /**
     * Mutator method for next
     * @param data of DeliveryListNode
     */
    public void setNext(DeliveryListNode data) {
        this.next = data;
    }

    /**
     * Mutator method for prev
     * @param data of DeliveryListNode
     */
    public void setPrev(DeliveryListNode data) {
        this.prev = data;
    }

}
