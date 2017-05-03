package componentes.db;

import java.sql.Connection;

import componentes.xmlParser.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import componentes.JSONB.Jbuilder;

public class DBCon {
	
	Statement stmt;
	Connection c;
	
	xmlParse parse = new xmlParse("/home/juan/Desktop/dbconfig.xml","postgres");
	
	public DBCon(){
		
		try{
		Class.forName(parse.$("dbdriver"));
	    c = DriverManager.getConnection(parse.$("dbserver") + "://" + parse.$("dbhost") + ":" + parse.$("dbport") + "/" + parse.$("dbname"),
	       parse.$("dbusername"), parse.$("dbpass"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//insert etc
	public Jbuilder execUpdate(String Query){
		
		Jbuilder res = new Jbuilder();
		
		try {
			stmt = c.createStatement();
			
			stmt.executeUpdate(Query);
			stmt.close();
			
			res.add("status", "done");
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.add("exception",e.getMessage());
		}
		
		
		return res;
	}
	//select etc
	public ResultSet execQuery(String Query){
		
		Jbuilder res = new Jbuilder();
		
		ResultSetMetaData md;
		ResultSet rs = null;
		
		try {
			
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(Query);
			
			md = rs.getMetaData();
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.add("exception",e.getMessage());
		}finally{
			
		}
		
		
		return rs;
	}

}
