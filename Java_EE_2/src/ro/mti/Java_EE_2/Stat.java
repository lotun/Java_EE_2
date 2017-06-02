package ro.mti.Java_EE_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        if (getServletContext().getAttribute("active")==null){
        	response.getWriter().append("Error users");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //файл
		Map<String,String> logpas = new HashMap<String,String>();
	    try{
	        FileInputStream fstream = new FileInputStream("C:/Users/1/git/Java_EE_2/Java_EE_2/src/ro/mti/Java_EE_2/logpas.cvs");
	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	        String strLine;
	        while ((strLine = br.readLine()) != null){
	        	String [] lp = strLine.split(";");
	        	try {
					logpas.put(lp[0], MD5Hash.getHash(lp[1]));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	     }catch (IOException e){
	        System.out.println("Ошибка");
	     }
		//файл--------------
        
		
		String login = request.getParameter("login");
		String password = null;
		try {
			password = MD5Hash.getHash(request.getParameter("password"));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter pw = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		//проходим по парам логин пароль
		boolean flag = false;
		   for (Map.Entry<String, String> pair: logpas.entrySet())
		    {
					if (login.equals(pair.getKey()) && password.equals(pair.getValue())){
						//обнуляем ошибки ввода
						getServletContext().setAttribute("active",login);//ставим метку, что пользователь залогинен
						request.getRequestDispatcher("/welcome.jsp").include(request, response);
						
						getServletContext().setAttribute("trying", 0);
						trying=0;
						
						flag=true;

					}
		    }
		
		if (!flag){
			getServletContext().setAttribute("trying", String.valueOf(++trying));

			if(trying<5){
				request.getRequestDispatcher("/Error.jsp").include(request, response);

			}else{
				request.getRequestDispatcher("/block.jsp").include(request, response);
			}
		}
		
	}
	public void destroy(){
		getServletContext().removeAttribute("trying");
		trying=0;
		getServletContext().removeAttribute("active");
	}
}
