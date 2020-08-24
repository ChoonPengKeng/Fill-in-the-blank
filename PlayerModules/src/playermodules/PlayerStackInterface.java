
package playermodules;

/**
 * An interface for the ADT stack.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface PlayerStackInterface<P> {
    
    /**
    * Task: Adds a new entry to the top of the stack.
    *
    * @param data an object to be added to the stack
    */
    public void push(P data);
    
    /**
    * Task: Retrieves the stack's top entry.1       
    *
    * @return either the object at the top of the stack or null if the stack is
    * empty
    */
    public P peek();
    
    /**
    * Task: Removes and returns the stack's top entry.
    *
    * @return either the object at the top of the stack or, if the stack is empty
    * before the operation, null
    */
    public P pop();
    
    /**
    * Task: Detects whether the stack is empty.
    *
    * @return true if the stack is empty
    */
    public boolean Empty();
}
