public class LinkedStack<T> implements stackInterface<T> {
    private Node topNode;
    private int numberOfEntries;
    
    public LinkedStack(){
        topNode = null;
        numberOfEntries =0;
    }

    public LinkedStack(T newEntry){
        topNode = new Node(newEntry);
        numberOfEntries =0;
    }

    public String show(){
        String line = "";
        Node currentNode = topNode;
        while(currentNode != null){
            line += currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return line;
    }

    public void push(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.setNext(topNode);
        topNode = newNode;
        numberOfEntries++;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        else{
            T top = topNode.getData();
            topNode = topNode.getNext();
            numberOfEntries--;
            return top;
        }
    }

    public T peek(){
        return topNode.getData();
    }

    public boolean isEmpty(){
        return topNode == null;
    }

    public void clear(){
        topNode = null;
    }

    public int getSize(){
        return numberOfEntries;
    }

    private class Node{
        private T data;
        private Node next;

        private Node(){
            data = null;
            next = null;
        }

        private Node(T entry){
            data = entry;
            next = null;
        }

        public T getData() {
            return data;
        }
        
        /* 
        public void setData(T data){
            this.data = data;
        }
        */

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }
}
