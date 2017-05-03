package componentes.JFLEX;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class JFlex {

	Class r = null;
	
	public JFlex(String nObj, String nMethod,ArrayList params, ArrayList<String> pTypes) throws ClassNotFoundException{
		
		System.out.println(nObj + " " + nMethod + " " + params + " " + pTypes);
		r = Class.forName(nObj);
		
		try {
			
			invoke(nMethod, params, pTypes);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public JFlex(String nObj) throws ClassNotFoundException{
		r = Class.forName(nObj);
		System.out.println("jflex inst");
	}
	
	@SuppressWarnings("unchecked")
	public Object invoke(String nMethod,ArrayList params, ArrayList pTypes) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		Method m = r.getMethod(nMethod, getParamTypes(pTypes));
		return m.invoke(r.newInstance(), getParams(params, pTypes));
		
	}
	
	
	public Object[] getParams(ArrayList<Object> p, ArrayList pTypes){
		
		Object[] ox = new Object[p.size()];
		for (int i = 0; i<pTypes.size(); i++){
			
			switch((String) pTypes.get(i)){
				
				case "string":
					String t = (String) p.get(i);
					ox[i] = t;
					break;
				case "int":
					int t1    = Integer.parseInt((String) p.get(i));
					ox[i] = t1;
					break;
				case "double":
					double t2 = Double.parseDouble((String) p.get(i));
					ox[i] = t2;
					break;
				case "float":
					float t3 = Float.parseFloat((String) p.get(i));
					ox[i] = t3;
					break;
				case "long":
					long t4 = Long.parseLong((String) p.get(i));
					ox[i] = t4;
					break;
//				case "string[]":
//					String[] t4 = (String[]) p.get(i);
//					ox[i] = t4;
//					break;
//				case "int[]":
//					int[] t5 = (int[]) p.get(i);
//					ox[i] = t5;
//					break;
//				case "double[]":
//					double[] t6 = (double[]) p.get(i);
//					ox[i] = t6;
//					break;
//				case "float[]":
//					float[] t7 = (float[]) p.get(i);
//					ox[i] = t7;
//					break;
				default:
					System.out.println("Tipo no reconocido");
						
			}
			
		}
		
		return ox;
	}
	
	public Class[] getParamTypes(ArrayList x){
		
		int size = x.size();
		
		Class[] classes = new Class[size];
		
		int item = 0;
		for (Object a: x){
			switch((String) a){
				case "string":
					classes[item] = String.class;
					break;
				case "int":
					classes[item] = int.class;
					break;
				case "boolean":
					classes[item] = Boolean.class;
					break;
				case "double":
					classes[item] = double.class;
					break;
				case "float":
					classes[item] = float.class;
					break;
//				case "string[]":
//					classes[item] = String[].class;
//					break;
//				case "int[]":
//					classes[item] = int[].class;
//					break;
//				case "boolean[]":
//					classes[item] = Boolean[].class;
//					break;
//				case "double[]":
//					classes[item] = double[].class;
//					break;
//				case "float[]":
//					classes[item] = float[].class;
//					break;
				default: 
					System.out.println("default getParamTypes");
			}
			item++;
		}
		
		return classes;
		
	}

}