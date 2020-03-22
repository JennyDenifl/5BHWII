public class LightOff extends Light {
	private Light light;

	String obj = "aus";

	   public LightOff(Light light){
	      this.light = light;
	   }

	   public void execute() {
	      light.aus();
	      stack.commanddata.stack_push("Es ist "+ obj);
	   }

	   @Override
		public void redo() {
			stack.commanddata.stack_push(stack.commanddata.stack_peek());
		}

		@Override
		public void undo() {
			stack.commanddata.stack_pop();
		}

}
