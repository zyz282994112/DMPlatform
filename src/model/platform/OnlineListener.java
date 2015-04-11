package model.platform;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnlineListener implements HttpSessionAttributeListener {

	 public final static String LISTENER_NAME = "userid";  
     
	    /** 
	     * 定义存储客户登录session的集合. 
	     */  
//	 private static List<Object> sessions = new ArrayList<Object>();  
	 private static Map<Object,HttpSession> sessions = new HashMap<Object,HttpSession>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		if (LISTENER_NAME.equals(arg0.getName())) { 
			if(sessions.get(arg0.getValue()) != null)
				sessions.get(arg0.getValue()).invalidate();
			
            sessions.put(arg0.getValue(),arg0.getSession());
            Integer userid = (Integer)arg0.getValue();
         	User user = UserBean.select(userid);
         	user.setLogintag(1);
         	Timestamp now = new Timestamp(System.currentTimeMillis()); 
         	user.setLastLoginTime(now);
         	user = UserBean.update(user);
        } 
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		if (LISTENER_NAME.equals(arg0.getName())) { 
            sessions.remove(arg0.getValue()); 
            Integer userid = (Integer)arg0.getValue();
            User user = UserBean.select(userid);
         	user.setLogintag(0);
         	Timestamp now = new Timestamp(System.currentTimeMillis()); 
         	user.setLastLoginTime(now);
         	user = UserBean.update(user);
        } 
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}
