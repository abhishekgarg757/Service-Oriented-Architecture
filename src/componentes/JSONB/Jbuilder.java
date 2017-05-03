package componentes.JSONB;

import java.util.ArrayList;

public class Jbuilder {
	
	private String body = null;
	
	public Jbuilder(){
		this.body = "{";
	}
//  arraylist
	
	public String add(String name,ArrayList vals, Boolean nested){
		String main = "[";
		if(nested == false){
			
			for(Object val: vals){
				main+="[";
				for (Object val2:(ArrayList) val ){
					if(main.charAt(main.length()-1) == '['){
						main += "\"" + val2.toString() + "\"";
					}else{
						main += ",\"" + val2.toString() + "\"";
					}
				}
				if(vals.get(vals.size()-1)==val){
					main+="]";
				}else{
					main+="],";
				}
			}
			main+="]";
			if(this.body == "{"){
				return this.body += "\"" + name + "\"" + ":" + main;
			}else{
				return this.body += ",\"" + name + "\"" + ":" + main;
			}
			
		}else{
			
			for (Object val: vals ){
				if(main == "["){
					main += "\"" + val.toString() + "\"";
				}else{
					main += ",\"" + val.toString() + "\"";
				}
			}
			main+="]";
			
			if(this.body == "{"){
				return this.body += "\"" + name + "\"" + ":" + main;
			}else{
				return this.body += ",\"" + name + "\"" + ":" + main;
			}
			
		}
		
	}
	
//	cadenas
	public String add(String name, String val){
		if(this.body == "{"){
			return this.body += "\"" + name + "\":\"" + val + "\"";
		}else{
			return this.body += ","+ "\"" + name + "\":\"" + val + "\"";
		}
	}
	
	public String add(String name, String... vals){
		if(this.body == "{"){
			this.body += "\"" + name + "\"" + ":["; 
			for (String a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += "\"" + a + "\"";
				}else{
					this.body += ",\"" + a + "\"";
				}
			}
		}else{
			this.body += "," + "\"" + name + "\"" + ":[";
			for (String a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += "\"" + a + "\"";
				}else{
					this.body += ",\"" + a + "\"";
				}
			}
		}
		return this.body+="]";
	}
//	enteros
	public String add(String name, int val){
		System.out.println("int");
		if(this.body == "{"){
			return this.body += "\"" + name + "\":\"" + val + "\"";
		}else{
			return this.body += ","+ "\"" + name + "\":\"" + val + "\"";
		}
	}
	
	public String add(String name, int... vals){
		if(this.body == "{"){
			this.body += "\"" + name + "\"" + ":[";  
			for (int a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}else{
			this.body += "\"" + name + "\"" + ":["; 
			for (int a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}
		return this.body+="]";
	}
//	floats
	public String add(String name, float val){
		System.out.println("float");
		if(this.body == "{"){
			return this.body += "\"" + name + "\":\"" + val + "\"";
		}else{
			return this.body += ","+ "\"" + name + "\":\"" + val + "\"";
		}
	}
	
	public String add(String name, float... vals){
		if(this.body == "{"){
			this.body += "\"" + name + "\"" + ":["; 
			for (float a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}else{
			this.body += "\"" + name + "\"" + ":["; 
			for (float a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}
		return this.body+="]";
	}
//	doubles
	public String add(String name, double val){
		System.out.println("double");
		if(this.body == "{"){
			return this.body += "\"" + name + "\":\"" + val + "\"";
		}else{
			return this.body += ","+ "\"" + name + "\":\"" + val + "\"";
		}
	}
	
	public String add(String name, double... vals){
		if(this.body == "{"){
			this.body += "\"" + name + "\"" + ":["; 
			for (double a : vals){
				if(vals[0] == a){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}else{
			this.body += "\"" + name + "\"" + ":["; 
			for (double a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a;
				}else{
					this.body += "," + a ;
				}
			}
		}
		return this.body+="]";
	}
//	jsons
	public String add(String name, Jbuilder val){
		if(this.body == "{"){
			return this.body += "\"" + name + "\":\"" + val.Stringify() + "\"";
		}else{
			return this.body += ","+ "\"" + name + "\":\"" + val.Stringify() + "\"";
		}
	}
	public String add(String name, Jbuilder... vals){
		if(this.body == "{"){
			this.body += "\"" + name + "\"" + ":["; 
			for (Jbuilder a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a.Stringify();
				}else{
					this.body += "," + a.Stringify() ;
				}
			}
		}else{
			this.body += "\"" + name + "\"" + ":["; 
			for (Jbuilder a : vals){
				if(this.body.charAt(this.body.length()-1) == '['){
					this.body += a.Stringify();
				}else{
					this.body += "," + a.Stringify() ;
				}
			}
		}
		return this.body+="]";
	}
	
	public String Stringify(){
		return this.body + "}";
	}

}