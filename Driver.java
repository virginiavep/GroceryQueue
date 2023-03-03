//Store simulation
//60 minutes 
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        //create linked queue
        LinkedListQueue line = new LinkedListQueue();
        Random rand = new Random();
        int serviced = 0; // to count the number of customers serviced
        int maxLength = 0; //to count the max length of the line
        int length = 0; //track the changes in length of the line
        
        for (int i =0; i <60; i++){ //60 minutes of activity at the store
            
            if(rand.nextInt(4)==0){//25% chance of a new customer addition
                line.enqueue(new Customer());
                length++;
                System.out.println("New customer added! Queue length "
                        + "is now " +line.getLength());
                if(line.getLength()> maxLength){
                    maxLength = line.getLength();
                }
            }
            //remove a customer from the queue when they have completed the transaction
            Customer current = line.getFirst();
            if (current != null){
                if(current.getServiceTime() <=0){
                    line.dequeue();
                    serviced++;
                    System.out.println("Customer serviced and removed from queue."
                            + " Queue length is now " + line.getLength());
                }
            
            current.decServiceTime();//update the customer serviced
            }
            System.out.println("-------------------------------"); //passing time
        }
        //print total number of customers serviced and maximum line length reached
        System.out.println("Total number of customers serviced " + serviced 
                + "\nMaximum line length " + maxLength);
    }
    
}
