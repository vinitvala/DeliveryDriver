
import java.util.Scanner;

/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * Recitation 02
 * DeliveryDriver CLass which handles the changes to the delivery lists according to user input
 */

public class DeliveryDriver {

        public static void main(String[] args) {

                DeliveryList billyList = new DeliveryList();
                DeliveryList mikeList = new DeliveryList();

                DeliveryList currentList= new DeliveryList();
                currentList=billyList;
               Delivery temp= new Delivery();
                int changeCount=0;
                int cutCount=0;

                String ListName= "Biz Billy's Deliveries";

                int counter = 0;
                System.out.println("By default you are accessing Billy Business' Delivery List ");
                System.out.println("Access another Delivery List from the menu by pressing 'S' ");
/**
 * while loop is for printing the method continuously. It will reprint unless the user makes a relevant input from the menu
 */
                while (counter == 0) {
                        System.out.println("\n********************************************************");
                        System.out.println("Welcome to Billy's Campus food stop scheduler");
                        System.out.println("Menu: \n\tA) Add a Delivery after cursor \n\tR) Remove Delivery At Cursor \n\tX) Cut Cursor \n\tV) Paste After Cursor " +
                                "\n\tH) Cursor to Head \n\tT) Cursor to Tail \n\tF) Cursor Forward " +
                                "\n\tB) Cursor Backward \n\tS) Switch Delivery Lists \n\tP) Print current list \n\tQ) Quit \n");

                        Scanner stdin = new Scanner(System.in);
                        System.out.print("Please Select an option: ");
                        char userInput = stdin.next().charAt(0);
                        stdin.nextLine();
                        userInput = Character.toUpperCase(userInput);

                       // DeliveryList tempList=new DeliveryList();

                        try {
                                switch (userInput) {
                                /**
                                * Adds the delivery after the cursor
                                */

                                        case 'A': {
                                                System.out.print("Please enter a source: ");
                                                String source = stdin.nextLine();
                                                System.out.print("Please enter a destination: ");
                                                String dest = stdin.nextLine();
                                                System.out.print("Please enter any special instructions: ");
                                                String instruction = stdin.nextLine();

                                                Delivery obj=new Delivery(source,dest,instruction);

                                                currentList.insertAfterCursor(obj);
                                                System.out.println("Order inserted.");
                                        }
                                        break;
                                        /**
                                        * resets cursor to head
                                        */
                                        case 'H': {
                                                currentList.resetCursorToHead();
                                                System.out.println("The cursor is at the head");

                                        }
                                        break;
                                        /**
                                        * resets cursor to tail
                                        */
                                        case 'T': {
                                                currentList.resetCursorToTail();
                                                System.out.println("The cursor is at the tail");

                                        }
                                        break;
                                        /**
                                        * moves the cursor forward
                                        */
                                        case 'F': {
                                                currentList.cursorForward();
                                        }
                                        break;
                                        /**
                                        * moves the cursor backward
                                        */
                                        case 'B': {
                                                currentList.cursorBackward();
                                        }
                                        break;
                                        /**
                                        * removes the delivery at the cursor
                                        */
                                        case 'R': {
                                                String temporary=currentList.getCursor().getDest();
                                                currentList.removeCursor();
                                                System.out.println("Delivery to "+temporary+" has been removed");

                                        }
                                        break;
                                        /**
                                        * To switch the delivery route. The two lists are Mike's list and Billy's List
                                        */
                                        case 'S': {

                                                ++changeCount;
                                                if(changeCount%2==0){
                                                        System.out.println("The list has been changed to Billy's List");
                                                        currentList=billyList;
                                                        ListName="Biz Billy's Deliveries";

                                                }
                                                else{
                                                        System.out.println("THe list has been changed to Mike's List");
                                                        currentList=mikeList;
                                                        ListName="Money Mike's Deliveries";
                                                }
                                        }
                                        break;
                                        /**
                                        * Cuts the delivery at cursor and save the delivery object in a temp variable
                                        */
                                        case 'X': {
                                                temp=currentList.removeCursor();
                                                //check
                                                System.out.println("cursor is cut");
                                                cutCount++;

                                        }
                                        break;
                                        /**
                                        * Inserts the last object to be cut after the cursor
                                        */
                                        case 'V':{
                                                if(cutCount!=0) {
                                                      currentList.insertAfterCursor(temp);
                                                }
                                                else
                                                        System.out.println("There is nothing to paste! Please cut the cursor first");
                                        }
                                        break;
                                        /**
                                        * Prints the delivery List
                                        */
                                        case 'P':{
                                                System.out.println(ListName+": ");
                                                System.out.println(currentList.toString());
                                                System.out.println("------------------------------------------- ");
                                                if(currentList.numDeliveries()==0){
                                                        System.out.println("There are no deliveries in this list!");
                                                }

                                        }
                                        break;
                                        /**
                                        * quits the menu
                                        */
                                        case 'Q':{

                                                System.out.println("Thank you! Next time try UPS!");
                                                counter++;
                                        }
                                        break;
                                        default:
                                                System.out.println("Wrong option. Enter again.");
                                }

                        }catch(EndOfListException e) {
                                System.out.println("Error! not in the range of the Delivery List ");
                        }
                        catch(EmptyListException ef){
                                System.out.println("Error! This list is empty!");
                        }

                }
        }
}



