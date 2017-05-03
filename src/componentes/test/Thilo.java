package componentes.test;

import componentes.db.conPool;
import componentes.db.DBCon;
import componentes.db.RSTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Timer;

public class Thilo extends Thread{
	
	conPool con = null;
	int id;
	
	public Thilo(int id, conPool con){
		this.con = con;
		this.id=id;
	}
	
	Timer t = null;
	DBCon dbcon = null;
	Object x = null;
	public void run(){
		
		t = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				x = con.getCon();
				if(x=="Wait"){
					System.out.println("wait");
				}else{
					dbcon =  (DBCon) x;
					RSTable rs = new RSTable(dbcon.execQuery("select * from tabla where name='JUAN'"));
					System.out.println(id + "- "+rs.tableify().Stringify());
					t.stop();
					con.retCon(dbcon);
				}
			}
		});
		
		java.util.Timer tt = new java.util.Timer(false);
		
		tt.schedule(new TimerTask(){
			@Override
			public void run(){
				t.start();
			}
		},0);
	}
	
}
