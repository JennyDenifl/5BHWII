public class Singleton {

	static Singleton instance;
	
	public static Singleton getInstanc(){
		if( instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
