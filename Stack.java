// defines the structure for a stack

// stack class adt
public interface Stack {
    public void clear();
    public boolean push(Object it); // push to top of stack
    public Object pop(); // remove and return element at TOS
    public Object topValue(); // return copy of top element
    public int length(); // return num of elements in stack
    public boolean isEmpty(); // return true if stack empty
}
