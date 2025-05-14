package tjoeunJSP.listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import tjoeunJSP.util.LoginManager;

@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    	System.out.println("세션 리스너 객체 생성");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	String sessionId = se.getSession().getId();
    	se.getSession().setMaxInactiveInterval(60); // 세션 유효시간 1분
    	System.out.println("세션 생성 - SESSIONID : " + sessionId);
    	System.out.println("----------------------------------------");
    	LoginManager.getInstance().allUsers();
    	
    	
    	// EL - applicationScope
    	// 세션이 생성될 때 -> 방문자 수를 1씩 증가
    	ServletContext application = se.getSession().getServletContext();
    	AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount") ;
    	if (visitorCount == null ) {
    		visitorCount = new AtomicInteger(0);
    	}
    	// 방문자수 1 증가
    	int currentCount = visitorCount.incrementAndGet();
    	application.setAttribute("visitorCount", visitorCount);
    	System.out.println("현재 방문자 수 : " + currentCount);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	String sessionId = se.getSession().getId();
    	System.out.println("세션 종료 - SESSIONID : " + sessionId);
    	
    	// 로그인 사용자 정보 제거
    	LoginManager.getInstance().removeUser(sessionId);
    	System.out.println("----------------------------------------");
    	LoginManager.getInstance().allUsers();

    
    	// EL - applicationScope
    	// 세션이 종료될 때 -> 방문자 수를 1씩 감소
    	ServletContext application = se.getSession().getServletContext();
    	AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount") ;
    	int count = 0;
    	if (visitorCount != null ) {
    		count = visitorCount.decrementAndGet();
    		System.out.println("사용자가 나갔습니다.");
    	}
    	// 방문자수 1 증가
    	application.setAttribute("visitorCount", count);
    	System.out.println("현재 방문자 수 : " + count);

    }
}
