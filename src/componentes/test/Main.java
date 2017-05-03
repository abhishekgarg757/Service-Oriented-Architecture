package componentes.test;

import componentes.test.ToReflex;
import componentes.xmlParser.*;


import componentes.dispatcher.DataParser;
import componentes.JSONB.Jbuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.Timer;

import componentes.JFLEX.JFlex;

import componentes.log.Log;

import componentes.db.DBCon;
import componentes.db.conPool;
import componentes.db.RSTable;

public class Main {
	private static Timer t = null;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		System.out.println("main beign main");
		
//		xmlParse asd = new xmlParse("/home/juan/Desktop/dbconfig.xml","postgres2");
//		
//		System.out.println(asd.getEl("dbname"));
//		
//		JFlex newflex = new JFlex("componentes.test.ToReflex");
//		
//		newflex.invoke("method1", DataParser.getArrs("[\"juan\",\"urdaneta\"]"), DataParser.getArrs("[\"string\",\"string\"]"));
		
//		float[] qwe =  {1f,2f,3f,4f,5f}; 
//		
//		ArrayList param = new ArrayList();
//		param.add(qwe);
//		ArrayList<String> paramType = new ArrayList<String>();
//		paramType.add("float[]");
//		
//		JFlex newflex = new JFlex("componentes.test.ToReflex","method2",param,paramType);
//		
//		JFlex newflex2 = new JFlex("componentes.test.ToReflex");
//		
//		ArrayList p2 = new ArrayList();
//		p2.add("juan");
//		p2.add("urdaneta");
//		ArrayList p3 = new ArrayList();
//		p3.add("string");
//		p3.add("string");
//		
//		newflex2.invoke("method1", p2, p3 );
		
//		Jbuilder json = new Jbuilder();
//		
//		ArrayList md = new ArrayList();
//		ArrayList md2 = new ArrayList();
//		ArrayList md3 = new ArrayList();
//		ArrayList md4 = new ArrayList();
		
//		md.add("uno");
//		md.add("dos");
//		md.add("tres");
		
//		md2.add("cuatro");
//		md2.add("cinco");
//		md2.add("seis");
//		
//		md2.add("cuatro");
//		md2.add("cinco");
//		md2.add("seis");

//		md4.add("siete");
//		md4.add("ocho");
//		md4.add("nueve");

		
//		md3.add(md);
//		md3.add(md2);
//		md3.add(md4);
		
//		json.add("arrays",md2,true);
//		
//		System.out.println(json.Stringify());
		
		
//		Jbuilder resJson = new Jbuilder();
//		
//		DBCon con = new DBCon();
//		
//		RSTable rtable = new RSTable (con.execQuery("select * from tabla"));
//		
//		resJson.add("response", rtable.tableify());
//		
//		System.out.println(resJson.Stringify());
//
//		conPool cp = new conPool();
//		
//		for(int i = 0; i<80; i++){
//			Thilo h = new Thilo(i,cp);
//			h.start();
//		}
		
//		t = new Timer(3000,new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent evt){
//				System.out.println("me");
//			}
//		});
//		
//		java.util.Timer tt = new java.util.Timer(false);
//		
//		tt.schedule(new TimerTask(){
//			@Override
//			public void run(){
//				t.start();
//			}
//		},0);
		

//	Log ls  =  new Log("/home/juan/Desktop","mfile");
//	ls.log("info", "everything okay");
//	
//	ls.writeLog();
	
		
	}

}