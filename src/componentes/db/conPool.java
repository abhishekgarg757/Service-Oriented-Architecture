package componentes.db;

import java.util.ArrayList;

public class conPool {
	
	private int min = 5;
	private int max = 40;
	private int rate = 5;
	
	private Boolean isFull = false;
	
	public ArrayList<DBCon> ready = new ArrayList<DBCon>();
	public ArrayList<DBCon> busy  = new ArrayList<DBCon>();
	
	private int currentSize = 0;
	private int index = 0;
	
	public conPool(){
		index = 0;
		while(index<this.min){
			ready.add(instantiate());
			currentSize++;
			index++;
		}
	}
	
	private DBCon instantiate (){
		return new DBCon();
	}
	
	private void increment(){
		if(currentSize==max){
			System.out.println("can't increment");
		}else{
		index = 0;
		while(index<this.rate){
			ready.add(instantiate());
			currentSize++;
			index++;
			}
		}
	}
	
	public Object getCon(){
		if (ready.size() != 0){
			try {
				busy.add(ready.remove(ready.size()-1));
				System.out.println(" r:" + ready.size()+ " b:" + busy.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.print("getcon: ");
				System.out.println(e.getMessage() + " r:" + ready.size()+ " b:" + busy.size());
			}
			return busy.get(busy.size()-1);
		}else {
			isFull = true;
			increment();
			return "Wait";
		}
	}
	
	public void retCon(DBCon con){
		try {
			ready.add(busy.remove(busy.size()-1));
			System.out.println(" r:" + ready.size()+ " b:" + busy.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("retcon: ");
			System.out.println(e.getMessage() + " r:" + ready.size()+ " b:" + busy.size());
		}
	}

}
