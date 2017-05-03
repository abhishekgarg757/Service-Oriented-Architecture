package componentes.dispatcher;

import java.util.ArrayList;

public class DataParser {
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getArrs(String data){
		
		ArrayList send = new ArrayList();
		
		String x[] = data.split("\\[",2);
		
		String y[] = x[1].split("\\]",2);
		
		String z[] = y[0].split(",");
		
		int index = 0;
		for(String a: z){
			if (a.charAt(0) == '"'){
				String nw[] = a.split("\"",3 );
				z[index] = nw[1];
			}
			
			index++;
		}
		
		for(Object a: z){
			send.add(a);
		}
		
		return send;
	}


}