package org.westos.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.westos.service.UserServise;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	   private String username ;  
       private String password ;  
       private String cpasswd ;
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
	public String getCpasswd() {
		return cpasswd;
	}
	public void setCpasswd(String cpasswd) {
		this.cpasswd = cpasswd;
	}  
       public String execute() throws SQLException{
    	   UserServise userServise = new UserServise() ;
    	    if(password !=null && cpasswd !=null && username !=null && password.equals(cpasswd)){
    	    boolean b1 = userServise.loginUser(this.username,this.password);
				if(b1){
		    	   return SUCCESS ;
		    	   }				   
               }
	           return ERROR ;
    	   }
         public void findUserName() throws SQLException{
        	 UserServise userServise = new UserServise() ;
      	   //ajax查找用户名是否存在
      	   boolean b = userServise.findUserName(this.username) ;
      	   System.out.println(b);
      	   //如果b=true,说明用户名已存在，则用户名不可用。
      	   if(b){
     			HttpServletResponse response = ServletActionContext.getResponse();
     			//响应false给前台
  			try {
  				response.getWriter().print(!b);
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
      }
    }
          public String login(){
				boolean b = false;
				try {
					b = UserServise.loginUserName(this.username,this.password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if(b){
		        	return SUCCESS ;
		        }
			        return ERROR;
          }
}

