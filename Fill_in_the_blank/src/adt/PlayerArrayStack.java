
package playermodules;

public class PlayerArrayStack<P> implements PlayerStackInterface<P>{
    
    public P[] stack;                           //stack array to store data
    private int top;                            //as a counter
    private static final int maxSize = 100;
    
    public PlayerArrayStack() {
        this(maxSize);
    }

    public PlayerArrayStack(int n) {
        stack = (P[]) new Object[maxSize];      //maxSize is 100, 0-99
        top = 0;                                //start empty stack from 0,stack[0]
    }
    
    @Override
    public void push(P data) {
        if(top < maxSize)                       //check the stack is not full
        {
            stack[top] = data;                  //add element into stack array
            top++;
        }
        else
        {
            System.out.println("Stack Overflow!!");//if top>maxSize mean the stack on top
                                                   //already over the max capacity,Eg stack[100] > stack[99]
        }
    }

    @Override
    public P peek() {
        
        if (top > 0) {              //check top=0>1, so that 0-1 not equal to -1 and get error
            return stack[top-1];    //return last element,
        }
        else
        {
            return null;            //if stack is empty, return null
        }
        
    }

    @Override
    public P pop() {
        
        if (!this.Empty()) {        //check the stack is not empty
            P data = this.peek();   //declare temporary variable to access same code from peek method
            stack[top-1] = null;    //to clear last element
            top--;
            return data;            //return temporary variable and return last stack element
        }
        else
        {
            return null;            //if stack is empty return null
        }
        
    }

    @Override
    public boolean Empty() {
        if(top == 0)                //check the stack is empty
        {
            return true;            //empty stack
        }
        else
        {
            return false;           //have elements inside the stack
        }
    }
    
    //

    
    
}
