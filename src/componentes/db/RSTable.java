package componentes.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import componentes.JSONB.Jbuilder;

public class RSTable {
	
	private ResultSetMetaData rsmd;
	private ResultSet rs;
	
	public RSTable(ResultSet rs){
		
		try {
			
			this.rs   = rs;
			this.rsmd = rs.getMetaData();
			
		} catch (SQLException e) {
			
			System.out.println("RSTable");
			e.printStackTrace();
			
		}

	}
	
	public int rowCount(){
		 
		int i = 0;
		
		try {
			while(this.rs.next()){
				
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Jbuilder tableify() {

		Jbuilder res = new Jbuilder();
		int index = 1;
		int colCount;
		ArrayList colnames = new ArrayList();
		ArrayList<String> coltypes = new ArrayList<String>();
		
		try {
			
			colCount = rsmd.getColumnCount();
			
			while(index<=colCount){
				
				colnames.add(rsmd.getColumnName(index));
				coltypes.add(rsmd.getColumnTypeName(index));
				
				index++;
				
			}

			ArrayList fil = new ArrayList();
			while(this.rs.next()){
				
				ArrayList temp = new ArrayList();
				
				int counter = 1;
				while(counter<=colCount){
					
					switch(coltypes.get(counter-1)){
						
					case"varchar":
						
						temp.add((String) rs.getString(counter));
						break;
						
					case"serial":
						
						temp.add(rs.getInt(counter));
						break;
						
					case"int4":
						
						temp.add(rs.getInt(counter));
						break;
						
					default:
						
						System.out.println("unknown type");
						
					}
					
					counter++;
					
				}
				fil.add(temp);
				
			}
			
			res.add("columns", colnames, true);
			
			if(fil.size()==1){
				
				res.add("data", fil, false);
				
			}else{
				
				res.add("data",fil,true);
				
			}
			
			
		} catch (SQLException e) {
			
			System.out.println("tableify");
			e.printStackTrace();
			
		}finally{
			
			index = 0;
			
		}
		
		return res;
		
	}
}