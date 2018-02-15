import java.util.*;
public class ArrayBasedStack<T> implements StackInterface<T>{
   private T[] data;
   private int topOfStack;
   private static final int INITIAL_CAPACITY = 5;
   private boolean initialized;
   
   public ArrayBasedStack(int size) throws IllegalArgumentException{
      if (size < 1){
         throw new IllegalArgumentException("Size is Wrong");
      }
      else{
         @SuppressWarnings("unchecked")
         T[] tempData = (T[]) new Object[size];
         topOfStack = -1;
         data = tempData;
         initialized = true;
         
      }
   }
   
   public ArrayBasedStack(){
      this(INITIAL_CAPACITY);
   }
   
   private void doubleArray(){
      data = Arrays.copyOf(data, 2 * data.length);  
   }
   
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry){
      if(data[data.length - 1] != null){
         doubleArray();
      }
      topOfStack++;
      data[topOfStack] = newEntry;
   }
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop(){
      if(isEmpty() == true){
         throw new EmptyStackException();
      }
      else{
         T pop = data[topOfStack];
         topOfStack--;
         data[topOfStack] = null;
         return pop;
      }
      
   }
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek(){
      if(isEmpty() == true){
         throw new EmptyStackException();
      }
      else{
         return data[topOfStack];
      }
   }
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      if(topOfStack < 0)
         return true;
      else
         return false;
   }
   /** Removes all entries from this stack. */
   public void clear(){
      while(!isEmpty()){
         pop();
      }
   }
}