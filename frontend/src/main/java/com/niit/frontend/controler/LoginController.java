package com.niit.frontend.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Users;

@Controller
public class LoginController {
	@Autowired
	Users users;
	@Autowired
	UsersDao usersDao;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model){
	if(error!=null)
		model.addAttribute("error","invalid User name or password");
	if(logout!=null)
		model.addAttribute("logout", "login seccessfull");
	return "redirect:/";
	}
	
	@RequestMapping(value="/j_spring_security_check")
    public String processRegistration(@RequestParam("j_username")String email,@RequestParam("j_password")String pwd,
   		 Model model,HttpSession session )
    {
		System.out.println("sdfads");
		
		Users u=usersDao.isvalid(email, pwd);
		if(u==null)
		{
			System.out.println("kjhdfskj");
			 model.addAttribute("msg","Invalid user name and password");
	    		return "redirect:/"; 
	    }
		else 
		{
			 session.setAttribute("users", u);
    		 session.setAttribute("name",u.getU_name());
    		 session.setAttribute("items",u.getCart().getGrand_total());
    		 return "redirect:/"; 
		}
		
		
	}
	
	@RequestMapping(value= "/j_spring_security_logout")
	public String logout(HttpServletRequest request, HttpSession Session, Model model){
		Session.invalidate();
		Session =request.getSession(true);
		model.addAttribute("logout", "logout successful");
		return "redirect:/";
	}

}
