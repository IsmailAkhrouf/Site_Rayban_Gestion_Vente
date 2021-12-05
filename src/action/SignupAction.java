package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import models.Users;
import services.UserService;
import services.UserServiceImp;

@SuppressWarnings("serial")
public class SignupAction extends ActionSupport {
	private String username;
	private String password;
	private String confirmPassword;
	
	
		
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


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	UserService a = new UserServiceImp();
	public String signup()
	{
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(username.length()<=20 && password.length()<=20) 
		{		
			Users user = new Users();
			if(a.checkUser(username))
			{
				addActionError("ce nom d'utilisateur est deja existe choisi un autre");
				return "input";
			}else {
				try {
					user.setLogin(username);
					user.setPass(password);
					a.add(user);
					session.put("username",username);
				}catch(Exception e) {
					System.out.println("problem dans l'ajout de l'objet");
				}
			}
		}else {
			addActionError("le mot de passe et le nom d'utilisateur ne doit passe depasser 20 chararcters ou chiffre");
			return "input";
		}
		return "success";
	}
	
	public void validate()
	{
		if(password.equals(confirmPassword)==false)
		{
			addActionError("les mots de pass ne sont pas identique");
		}
	}
}
