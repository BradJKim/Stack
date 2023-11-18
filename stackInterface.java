public interface stackInterface<T> {

    /**
     * Adds a new entry to the stack
     * @param newEntry data for new data entry/item
     */
    public void push(T newEntry);

    /**
     * Removes 1st data item on stack and return it
     * @return 1st data item on stack 
     */
    public T pop();

    /**
     * return first data item on stack without removing
     * @return first data item on stack
     */
    public T peek();

    /**
     * checks if stack is empty and has no data items
     * @return true or false based on if stack is empty
     */
    public boolean isEmpty();

    /**
     * removes all data items from stack
     */
    public void clear();

}