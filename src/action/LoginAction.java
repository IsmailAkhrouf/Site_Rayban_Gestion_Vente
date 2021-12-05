package action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



import services.UserService;
import services.UserServiceImp;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	UserService a = new UserServiceImp();
	public String login()
	{
		Map<String,Object> session = ActionContext.getContext().getSession();
		boolean userFound = false;
		try {
			userFound= a.check_login(username, password);
		}catch(Exception e)
			{
				System.err.println("une problem dans la recheche");
			}
		if(userFound)
		{
			session.put("username", username);
			return "success";
		}else {
			addActionError("le nom d'utilisateur ou le mot de est incorrect");
			return "input";
		}
	}
	public String logout()
	{
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.clear();
		return "failure";
	}

}
