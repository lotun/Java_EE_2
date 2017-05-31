package ro.mti.Java_EE_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;



/**
 * Servlet implementation class Stat
 */
@WebServlet("/Stat")
public class Stat extends HttpServlet {
	int trying = 0;//попытки вводка 
    boolean flag = false;
    //эмулятор нужного логина и пароля
    static String log = "alex";
    static String pass = "a123";
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stat() {
        super();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cook = request.getCookies();
        if (cook==null || trying>0){
        	Cookie cookis = new Cookie("trying",String.valueOf(++trying));
        	cookis.setMaxAge(3600);
        }else{
        	for (Cookie coo : cook){
        		if(coo.getName().equalsIgnoreCase("trying")){
        			trying = Integer.parseInt(coo.getValue());
        		}
        	}
        }
        
        
        
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		//request.getContentType("text/html;charset=windows-1251" );
		
		if (log.equals(login)&& pass.equals(password)){
			pw.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=windows-1251' /></head><body>Users " + login + "</body></html>");
			trying++;
		}
		else{
			if(trying<5){
				pw.print("<html><head><META HTTP-EQUIV='REFRESH' CONTENT='5; URL=http://localhost:8080/Java_EE_2/index.html'><meta http-equiv='Content-Type' content='text/html; charset=windows-1251' /></head><body>login or password is incorrect, you will have" + (5-trying) + " attempts</body></html>");
			}else{
				pw.print("<html><head><META HTTP-EQUIV='REFRESH' CONTENT='5; URL=http://localhost:8080/Java_EE_2/index.html'><meta http-equiv='Content-Type' content='text/html; charset=windows-1251' /></head><body>attempts ended, access is restricted</body></html>");
			}
		}
		
		
		//doGet(request, response);
	}

}
