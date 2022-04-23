package auction.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import auction.logic.LogoutLogic;

@WebListener
public class HttpSessionChecker implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
    	HttpSession session = event.getSession();
        System.out.printf("Session ID %s created at %s%n", session.getId(), new Date());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
    	HttpSession session = event.getSession();
        System.out.printf("Session ID %s destroyed at %s%n", session.getId(), new Date());
        LogoutLogic.deactivateUser((int) session.getAttribute("userId"));
    }

}
