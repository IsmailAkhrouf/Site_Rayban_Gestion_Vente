package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {
	 private static final long serialVersionUID = 1L;

	 @Override
	 public String intercept(ActionInvocation invocation)throws Exception{
	       HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
	       HttpSession session = request.getSession();
	       if(session.getAttribute("username") == null) {
	    	   return "failure";
	       }
	       else 
	    	   return invocation.invoke();
	    }
}
