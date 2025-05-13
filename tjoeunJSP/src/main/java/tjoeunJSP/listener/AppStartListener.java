package tjoeunJSP.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppStartListener implements ServletContextListener {

    public AppStartListener() {
        System.out.println("ServletContextListener 객체 생성");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("TestListener - 🌐 웹 애플리케이션 시작됨");
    	// TODO : DB 연결 설정...
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("TestListener - 🛑 웹 애플리케이션 종료됨");
    	// TODO : DB 자원 해제...
    }
	
}
