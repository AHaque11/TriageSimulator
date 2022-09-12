// Arefa Haque
// CIS 2353
// Spring 2022
// Prof. John P. Baugh
package project4;



interface QueueInterface<T> {
    
    public void enQueue(T newEntry);
    public T deQueue();
    public Boolean isEmpty();
    public void clear();
}



public class LinkedQueue<T> implements QueueInterface<T> {
  
    private class Node{
        private T data;
        private Node next;
        
        public Node(T data, Node next){
            
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }  
    }
    
    
    
    private Node firstNode;
    private Node lastNode;
    
    public LinkedQueue(){
        
        firstNode = null;
        lastNode = null;
    }
    
    @Override
    public void enQueue(T newEntry) {        
        
        Node newNode = new Node(newEntry, null);
        
        if(isEmpty()){
            firstNode = newNode;
        }
        else{
            lastNode.setNext(newNode);
        }
        
        lastNode = newNode;
    }
    
    @Override
    public T deQueue() {
       
        T front = firstNode.getData();
        
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNext();
        
        if(firstNode == null){
            lastNode = null;
        }
 
        return front;
    }
     
    @Override
    public Boolean isEmpty() {
        
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        
        firstNode = null;
        lastNode = null;
    }
    
}
