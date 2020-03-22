
public class LightOn extends Light {

	private Light light;
	String obj = "an";
	
	   public LightOn(Light light){
	      this.light = light;
	   }

	   public void execute() {
	      light.on();
	      stack.configdata.stack_push("es ist " +obj);
		}

		@Override
		public void redo() {
			stack.configdata.stack_push(stack.configdata.stack_peek());
		}

		@Override
		public void undo() {
			stack.configdata.stack_pop();
		}
}
