package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.Users;
import services.UserService;
import services.UserServiceImp;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport{

	private String actpassword;
	private String nouvpassword;
	private String confnouvpassword;
	

	public String getActpassword() {
		return actpassword;
	}
	public void setActpassword(String actpassword) {
		this.actpassword = actpassword;
	}
	public String getNouvpassword() {
		return nouvpassword;
	}
	public void setNouvpassword(String nouvpassword) {
		this.nouvpassword = nouvpassword;
	}
	public String getConfnouvpassword() {
		return confnouvpassword;
	}
	public void setConfnouvpassword(String confnouvpassword) {
		this.confnouvpassword = confnouvpassword;
	}
	
	UserService user = new UserServiceImp();
	public String update()
	{
		Users a = new Users();
		Map<String,Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		if(nouvpassword.equals(confnouvpassword))
		{
			int Id = user.getUserId(username, actpassword);
			if(Id!=0)
			{
				a.setCodeUser(Id);
				a.setLogin(username);
				a.setPass(nouvpassword);
				try
				{
					user.edit(a);
				}catch(Exception e)
				{
					System.err.println("une problem dans la modification");
				}
			}else {
				addActionError("le mot que vous avez saisie est incorrect");
				return "input";
			}
		}else {
			addActionError("les mots de passe ne sont pas identique");
			return "input";
		}
		addActionMessage("le mot de passe a ete modifier avec succes");
		return "success";
	}
}
