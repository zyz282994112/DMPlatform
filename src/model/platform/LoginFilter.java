package model.platform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter  implements Filter{
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;  
        HttpServletResponse response = (HttpServletResponse)arg1;  
          
        HttpSession session = request.getSession();  
        if(session.getAttribute("userid") == null) {  
            response.setCharacterEncoding("utf-8");  
            PrintWriter out = response.getWriter();  
            String path = request.getContextPath();  
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
            out.print("<script>alert('you are not login...'); window.location='"+basePath+"index.jsp' </script>");  
            out.flush();  
            out.close();  
        } else {  
            arg2.doFilter(request, response);  
        }  
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
