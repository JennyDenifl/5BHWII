
public class Light implements Command{
	private String an = "an";
	private String aus = "aus";

	   public void on(){
	      System.out.println("Das Licht ist "+an);
	   }
	   public void aus(){
	      System.out.println("Das Licht ist "+aus);
	   }
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
