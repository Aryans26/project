package com.niit.frontend.controler;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Users;
import com.niit.frontend.Otp.Otpganarater;


//import com.niit.kingfisherfrontend.sms.Smstoclient;

@Controller
public class SendEmailController {

//	@Autowired
//    private JavaMailSender mailSender;
//	
	@Autowired
	private Users user;
	
	@Autowired
	private UsersDao userDao;
	
//	@Autowired
//	Smstoclient  smstoclient;
	
    
	 @RequestMapping(value="/Email")
	    public String Email()
	    {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) 
			{
				
				String currusername = authentication.getName();
				user = userDao.getUseremail(currusername);
				Otpganarater ot=new Otpganarater();
				String o=ot.Otpga();
				String messages="Your One time Password is "+o;
				Long no=Long.parseLong(user.getU_phoneno());
//				smstoclient.sendsms(messages,no);
			    
	     }
	  return "EmailForm";
	    }
	    
}
