package componentes.test;

public class ToReflex {
	public ToReflex(){
	}
	
	public String method1 (String x,String  y){
		System.out.println("El parametro enviado es: " + x);
		System.out.println("El parametro enviado es: " + y);
		
		return x+" "+y;
	}
	
	public float method2 (int x, float y){
		float num = x+y;
		return num;
	}
}