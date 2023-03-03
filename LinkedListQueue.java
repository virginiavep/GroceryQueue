//linked queue that holds customer objects

public class LinkedListQueue {
    private Customer first, last;
    private int length;
    
    public LinkedListQueue(){
        first = last = null;
        length =0;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void enqueue (Customer c){
        length ++;
        //add customer c to the back of the queue
        if(isEmpty()){
            first = c;
        }else{
            last.setNext(c);
        }
        last = c;
    }
    public Customer dequeue(){
        //removes and returns the first Customer in the queue
        if(isEmpty()){
            return null;
        }
        //store a temporary reference to the object to be removed
        Customer temp = first;
        
        //set first to the current first objects next reference
        first = first.getNext();
        
        //if the queue is empty, set last to null
        if(isEmpty()){
            last=null;
        }
        length--;
        return temp;
    }
    public Customer getFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            Customer object =first;
            return object;
        }
    }
    public int getLength(){
        return length;
    }
    
}
