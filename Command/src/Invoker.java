import java.util.ArrayList;
import java.util.List;

public class Invoker {

		Command c;
		   private List<Command> LL = new ArrayList<Command>(); 

		   public void Licht(Command order){
		      LL.add(order);		
		   }

		   public void Lichtpos(){
		   
		      for (Command order : LL) {
		         order.execute();
		      }
		      LL.clear();
		   }
		   
		   
		   public void setC(Command c){
			    this.c= c;
			  }
			  
			  public Command getC() {
				  return c;
			  }
			  
			public void execute(){
				c.execute();
			}
		   
		   public void redo() {
			c.redo();
		   }

		   public void undo() {
			c.undo();
		   }

}