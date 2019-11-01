import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class log {

static log instance;

public static log getInstance() throws IOException{
	if( instance == null){
	 
		instance = new log();
	}
	return instance;
}

static PrintWriter writer;
private log() throws IOException{
	try {
		writer = new PrintWriter(new FileWriter("log.txt", true));
		writer.println("Hallo");
	}catch (FileNotFoundException | UnsupportedEncodingException e){
		e.printStackTrace();
	}
}

public static void log(String mesg){
	writer.println(mesg);
	writer.flush();
}

public static void setFile(String file) throws IOException{
	writer = new PrintWriter(new FileWriter(file, true));
}



	
	@Override
	protected void finalize() throws Throwable{
		writer.close();
		super.finalize();
	}
	
	
	private static int loggedlvl=0;
	private static int loglvl=0;
	
	public static void debug(String mesg) throws IOException{
		if(loggedlvl!=4) {
			setFile("debug.txt");
			loggedlvl=4;
		}
		log(mesg);
	}
	
	public static void info(String mesg) throws IOException{
		if(loggedlvl!=3) {
			setFile("info.txt");
			loggedlvl=3;
		}
		log(mesg);
	}
	
	public static void warning(String mesg) throws IOException{
		if(loggedlvl!=2) {
			setFile("warning.txt");
			loggedlvl=2;
		}
		log(mesg);
	}
	
	public static void error(String mesg) throws IOException{
		if(loggedlvl!=1) {
			setFile("error.txt");
			loggedlvl=1;
		}
		log(mesg);
	}

	public static void setLogLvl(Loglvl l) {
		if(l==Loglvl.ERROR) {
			loglvl=1;
		}
		if(l==Loglvl.WARNING) {
			loglvl=2;
		}
		if(l==Loglvl.INFO) {
			loglvl=3;
		}
		if(l==Loglvl.DEBUG) {
			loglvl=4;
		}
		
	}
}

