import java.util.Arrays;

public class ResizeableArrayStack<T> implements stackInterface<T> {
    private T[] stack;
    private int topIndex =0;
    private int default_capacity = 10;

    public ResizeableArrayStack(){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[default_capacity];
        stack = tempStack;
        topIndex = -1;
    }

    public ResizeableArrayStack(int init_cap){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[init_cap];
        stack = tempStack;
        topIndex = -1;
    }

    public void push(T newEntry){
        if(topIndex + 1 == stack.length){
            resize();
        }
        stack[++topIndex] = newEntry;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        else{
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public T peek(){
        return stack[topIndex];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public void clear(){
        for(int i=0; i<stack.length; i++){
            stack[i] = null;
        }
    }

    public int getSize(){
        return topIndex + 1;
    }

    private void resize(){
        stack = Arrays.copyOf(stack, 2 * stack.length);
    }
}
