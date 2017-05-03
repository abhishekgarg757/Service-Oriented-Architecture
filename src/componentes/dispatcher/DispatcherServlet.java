package componentes.dispatcher;

import componentes.JFLEX.JFlex;
import componentes.JSONB.Jbuilder;
import componentes.dispatcher.DataParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String w = request.getParameter("cName");
		String x = request.getParameter("mName");
		String y = request.getParameter("params");
		String z = request.getParameter("ptypes");
		
		System.out.println(w +" "+ x +" "+ y +" "+ z);
		
		Jbuilder res = new Jbuilder();
		
		try {
			
			JFlex newflex = new JFlex(w);
			
			Object m = newflex.invoke(x, DataParser.getArrs(y),DataParser.getArrs(z));
			
			System.out.println(m);
			
			res.add("status", "success");
			res.add("return", m.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Class not found");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Instantion exception");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Illegal access");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "No such Method");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Security exeption");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Illegal argument exception");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			res.add("exception", "Invocation target exception");
		}finally{
			
		}
		
		
		
		
		response.getWriter().println(res.Stringify());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}