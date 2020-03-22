import java.util.Stack;

public class Stacks<S> {

	private Stack<S> stack;

	public Stacks() {
		stack=new Stack<S>();
	}

		    void stack_push(S value){    
		            stack.push(value);
		            System.out.println(value);
		    } 

		    void stack_pop(){        
		            stack.pop();   
		    } 

		    S stack_peek(){ 
		    	System.out.println(stack.peek());
		        return (S) stack.peek();
 		    } 

		    S stack_search( int elem){ 
		        int pos =  stack.search(elem); 
		        if(pos == -1) { 
		            System.out.println("not found");
		        return null;
		        }
		        else {
		        	System.out.println(stack.peek());
		        	return stack.get(pos);
		        }

		   } 
}
