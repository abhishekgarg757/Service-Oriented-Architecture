package componentes.dispatcher;

import java.io.IOException;

import componentes.JSONB.Jbuilder;
import componentes.db.*;
import componentes.log.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Jbuilder res = new Jbuilder();
		
		String n = request.getParameter("name");
		String p = request.getParameter("pass");
		
		DBCon con = new DBCon();
		
		RSTable rst = new RSTable(con.execQuery("select count (name) from users where name = '"+n+"' and pass = '"+p+"'"));
		
		if(rst.rowCount()!=1){
			
			res.add("Error", "Cuenta ingresada no existe");
			Log.log("warn", "usuario intento entrar con credenciales " + n + " : " + p + " de manera no exitosa");
			response.getWriter().println(res);
			
		}else{
			
			RSTable rstx = new RSTable(con.execQuery("select users.name, permits.description from users, permits, usr_prm where users.id=usr_prm.usr_id AND permits.id=usr_prm.prm_id and users.name = '"+n+"';"));
			
			res.add("cred:", rstx.tableify());
			Log.log("succ", "usuario intento entrar con credenciales " + n + " : " + p + " de manera exitosa");
			response.getWriter().println(res);
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
