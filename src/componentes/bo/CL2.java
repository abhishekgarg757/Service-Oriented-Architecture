package componentes.bo;

import componentes.JSONB.Jbuilder;

public class CL2 {
	
	Jbuilder res = new Jbuilder();
		
		public Jbuilder m1(String a){
			
			res.add("name", a);
			return res;
			
		}
		
		public Jbuilder m2(int a, int b){
			
			res.add("result", a+b);
			return res;
			
		}	
	
}
