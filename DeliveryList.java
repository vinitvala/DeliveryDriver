
/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * Recitation 02
 * Delivery List Class that contains methods that will alter the Delivery lists according to data entered by user.
 */

public class DeliveryList {

    private DeliveryListNode head;
    private DeliveryListNode tail;
    private DeliveryListNode cursor;
    private int count;

    /**
     * Default constructor of DeliveryList
     * head reference of the Delivery list
     * tail reference of the Delivery list
     * cursor to allow a user to traverse the list
     * count of the number of deliveries
     */
    public DeliveryList() {
        head = null;
        tail = null;
        cursor = null;
        count = 0;
    }

    /**
     * methods for getting number of deliveries in the list
     * @return count which gives numbers of deliveries in the list
     */
    public int numDeliveries() {
        return this.count;
    }
       /* DeliveryListNode nodePtr=head;
        int answer=0;
        while(nodePtr!=null){       // does not run in O(1) time!!
            answer++;
            nodePtr=nodePtr.getNext();
        }
        return answer;
*/
    /**
     * Accessor method for head
     * @return head
     */
    public DeliveryListNode getHead() {
        return head;
    }

    /**
     * Accessor method for Tail
     * @return tail
     */
    public DeliveryListNode getTail() {
        return tail;
    }

    /**
     * Accessor method for cursor
     * @return data at cursor
     * @throws EmptyListException is thrown if cursor is null
     */
    public Delivery getCursor() throws EmptyListException {
        if (this.cursor.getData() == null)
            return null;
        else
            return this.cursor.getData();
    }

    /**
     * Mutator method for cursor
     * @param input of DeliveryListNode
     */
    public void setCursor(DeliveryListNode input) {
        this.cursor = input;
    }

    /**
     * method which resets the cursor to head
     * return type is void
     */
    public void resetCursorToHead() {
        cursor = this.head;
        if (head == null) {
            cursor = null;
        }
    }

    /**
     * method which resets the cursor to tail
     * return type is void
     */
    public void resetCursorToTail() {
        cursor = this.tail;
        if (tail == null) {
            cursor = null;
        }

    }

    /**
     * method moves the cursor forward to the next node in the delivery
     * @throws EndOfListException is thrown is lift is fall
     */
    public void cursorForward() throws EndOfListException{
         if(this.cursor==null){
            throw new EndOfListException("The list is null");
        }
         else if(this.cursor==tail){
             throw new EndOfListException("The cursor cannot go forward!");
         }
        else {
            this.cursor = this.cursor.getNext();
            System.out.println("The cursor has moved forward");
        }
    }

    /**
     * method moves the cursor backward to the previous node in the delivery
     * @throws EndOfListException is thrown as cursor cannot be moved backward
     */
    public void cursorBackward() throws EndOfListException{
        if (this.cursor == this.head) {
            throw new EndOfListException("Cursor is at Head or cannot be moved backward");
        } else if(this.cursor==null){
            throw new EndOfListException("The list is null");
        }
        else {
            this.cursor = this.cursor.getPrev();
            System.out.println("The cursor has moved backward");
        }
    }

    /**
     * method that inserts the delivery in the list after the cursor
     * @param newDelivery is the delivery information entered by the user
     * @throws IllegalArgumentException is thrown if the entry is null
     */
    public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException {

        if (newDelivery == null) {
            throw new IllegalArgumentException("The entry is null!");
        } else {
            DeliveryListNode box = new DeliveryListNode(newDelivery);
            // DeliveryList newD=new DeliveryList();     // if we want to use appendToTail
            if (this.cursor == null) {
                this.head = box;
                this.tail = box;
                this.cursor = box;

                count++;

            } else if (this.cursor == this.tail) {

                cursor.setNext(box);
                box.setPrev(this.cursor);
                tail = box;
                count++;
        // newD.appendToTail(newDelivery); will be used if we want to use appendToTail here
            } else {

                box.setPrev(this.cursor);
                box.setNext(this.cursor.getNext());
                cursor.getNext().setPrev(box);
                cursor.setNext(box);

                count++;
            }
            //System.out.println("count: " + count);                    reference for count
        }
    }

    /**
     * method that adds the delivery to the tail of the list
     * @param newDelivery has the delivery information ed by the user
     * @throws IllegalArgumentException is thrown if data entered is null
     */
    public void appendToTail(Delivery newDelivery) throws IllegalArgumentException {
        if (newDelivery == null) {
            throw new IllegalArgumentException("Null data entered!");
        } else {
            DeliveryListNode box = new DeliveryListNode(newDelivery);
            if (this.tail == null) {
                this.head = box;
                this.tail = box;
                this.cursor = box;
            } else {
                box.setPrev(this.tail);
                this.tail = box;
            }
            count++;
        }
    }

    /**
     * method to remove the delivery at the cursor
     * @return data of the temporary object created
     * @throws EmptyListException is thrown if the cursor is null
     */
    public Delivery removeCursor() throws EmptyListException {

        if (this.cursor == null) {
            throw new EmptyListException("Cursor is null");
        } else if (this.cursor == tail) {
            DeliveryListNode temp = cursor;
            cursor.setNext(null);
            tail = cursor.getPrev();
            count--;
            { if(count==0){
                setCursor(null);
            }
            else cursor=cursor.getPrev();}
            return temp.getData();
        } else if (this.cursor == head) {
            DeliveryListNode temp = cursor;
            head = cursor.getNext();
            cursor.getNext().setPrev(null);
            count--;
            cursor = cursor.getNext();
            return temp.getData();
        } else {
            DeliveryListNode temp = cursor;
            this.cursor.getPrev().setNext(this.cursor.getNext());
            this.cursor.getNext().setPrev(this.cursor.getPrev());
            count--;
            cursor=cursor.getNext();
            return temp.getData();
        }

    }

    /**
     * toString method that prints the delivery list with all information
     * @return the holder string which is printed in the DeliveryDriver class
     */
    public String toString() {
        String holder = "------------------------------------------- \n";
        DeliveryListNode tempDelivery = this.head;        //tempDelivery is a temp node that stores info of head
        if (tempDelivery == null) {
            return holder + "[no input]";
        } else {
            for (int i = 0; i < this.count; i++) {

                if(i != 0 && tempDelivery != this.cursor){
                    holder += "~";
                }
                if (tempDelivery == this.cursor) {
                    holder = holder + "-->";
                }
                    try {
                        holder = holder + tempDelivery.getData().toString() + "\n";
                    } catch (EmptyListException e) {
                        e.printStackTrace(); // nested try catch handled properly?
                    }
                    tempDelivery = tempDelivery.getNext();
                }
            }
            return holder;
        }

    }


//    public void insertInfo(String name, String rfidTag, double price, String initPosition) throws EmptyListException {
//        //As you insert each info into the sorted list, traverse the list to figure out where the new info should go
//        // and insert there. Then the new list is still sorted without running a sorting algorithm.
//
//        //Order of Complexity=
//
//        cursor=head;
//        if(rfidTag==null)
//            throw new IllegalArgumentException("The entry is null");
//        else{
//            ItemInfo itemInfo=new ItemInfo(name,rfidTag,price,initPosition);
//            ItemInfoNode item=new ItemInfoNode(itemInfo);
//            if(cursor==null){
//                head=item;
//                tail=item;
//                cursor=item;
//
//                count++;
//            }
//
//            else {
//                count++;
//                for(int i=1;i<count;i++){
//
//                    System.out.println("count="+count);
//                    if (rfidTag.compareTo((cursor.getData().getRfidTagNumber()))<0) {//<=
//                        // append before cursor
//                        if(cursor==head){ // && count<=2
//                            cursor.setPrev(item);
//                            item.setNext(cursor);
//                            head=item;
//                            i=i*10;        //
//                        }
////                        if(cursor==tail){
////                            cursor.setNext(item);
////                            item.setPrev(cursor);
////                            tail=item;
////                        }
//                        else {
//                            item.setNext(cursor);
//                            item.setPrev((cursor.getPrev()));
//                            cursor.getPrev().setNext(item);
//                            cursor.setPrev(item);
//                        }
//                    }   else {      //if (rfidTag.compareTo(cursor.getData().getRfidTagNumber()) >= 0) {
//                        //append after cursor
//                        if(cursor==tail){       //&& count<=2
//                            cursor.setNext(item);
//                            item.setPrev(cursor);
//                            tail=item;
//                            i=i*10;
//                            System.out.println("Here");
//                        }
////                        else if(cursor.getNext()==tail){
////                            cursor.setNext(item);
////                            item.setPrev(cursor);
////                            tail=item;
////                            System.out.println("done");
////                        }
//                        else{
//                            item.setPrev(cursor);
//                            item.setNext(cursor.getNext());
//                            cursor.getNext().setPrev(item);
//                            cursor.setNext(item);
//                            if(cursor.getNext().getNext()!=null) // ! Avoid null pointer exception if the element is last
//                                cursor=cursor.getNext().getNext(); // .getNext()
////                            if(cursor.getNext()==null)
////                                tail=item;
//                            System.out.println("cursor at: "+cursor.getData().getName());
//                        }
//                    }
//                }
//            }
//        }
//    }



