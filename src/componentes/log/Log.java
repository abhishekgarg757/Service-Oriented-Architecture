package componentes.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	private String URL;
	private String fId;
	
	private static String clog = "";
	
	public Log(String location, String identifiyer){
		this.URL = location;
		this.fId = identifiyer;
	}
	
	static public String log(String type, String text){
		
		switch(type){
			case "warn":
				clog += "<-WaRnInG!!->: " + text + " at: " + System.currentTimeMillis() + "";
				break;
			case "info": 
				clog += "((Info)): " + text + " at: " + System.currentTimeMillis() + "";
				break;
			case "succ":
				clog += "__success: " + text + " at: " + System.currentTimeMillis() + "";
				break;
			default:
				clog += "--default: " + text + " at: " + System.currentTimeMillis() + "";
				break;
		}
		
		return clog;
	}
	
	public void writeLog (){
		
		File f = new File(URL + "JLog-" + fId + " -at:" + System.currentTimeMillis() +".txt");
		System.out.println(clog);
		try {
			FileWriter fw = new FileWriter(f);			
			fw.write(clog);
			fw.flush();;
			System.out.println("writting");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
