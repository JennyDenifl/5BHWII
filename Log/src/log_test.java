import java.io.IOException;

public class log_test {

	public static void main(String[] args) throws IOException {
		System.out.println(log.getInstance());
		log.setFile("test.txt");
		log.log("hallo");
		
//		log.setLogLevel(debug)		debug<info<warning<error
		
		log.setLogLvl(Loglvl.INFO);
		log.debug("Debug");
		log.error("Error");
		log.info("Info");
		log.warning("Warning");
	}

}

