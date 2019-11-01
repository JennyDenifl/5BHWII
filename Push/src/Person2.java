public class Person2 implements Observer {

		public int temp=0;

		public int interest=30;
		
		public int notinterest = 35;

		@Override

		public void update(int i) {

				temp=i;

				System.out.println("Lara: yeah! meine temp:" +i + "°C");

		}

		@Override

		public int getInterest() {

			return interest;

		}

		@Override
		public int getNotInterest() {
			return notinterest;
		}



	
	
}
