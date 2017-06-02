package ro.mti.Java_EE_2;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JFilter implements Filter  {
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		PrintWriter pw = response.getWriter();
		// TODO Auto-generated method stub
		String log = request.getParameter("login");
		String pas = request.getParameter("password");
		
		if (log.equals("") || pas.equals("")){
			pw.print("Логин не меньше 3х символов");
		}else{
			pw.print("Логин ,больше 3х символов");
			((FilterChain) arg1).doFilter(request,response);
		}
	}

}
