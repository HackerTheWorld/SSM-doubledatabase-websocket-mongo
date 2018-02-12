package common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitServlet implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getServletContext().getRealPath("");
		System.out.println(str);
//		"http://" + request.getServerName() //服务器地址  
//        + ":"   
//        + request.getServerPort()           //端口号  
//        + httpRequest.getContextPath()      //项目名称  
	}
    
   
}
