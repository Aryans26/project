
package com.niit.frontend.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Users;

@Controller
public class UsersController {
	
@Autowired 
	Users users;
	@Autowired 
	UsersDao userDao;
	
	@RequestMapping("/users")
	public ModelAndView users()
	{
	ModelAndView obj=new ModelAndView("users");
	obj.addObject("users", new Users());
	return obj;
	}
	
	@RequestMapping	(value="/users_Processing", method=RequestMethod.POST)
	public ModelAndView userProcessing(@ModelAttribute("users")Users users)
	{
		ModelAndView obj ;
		if(userDao.saveorupdate(users))
		{
			obj = new ModelAndView("redirect:/");
			obj.addObject("msg", "Successfully save users");
		}
		else
		{
			obj = new ModelAndView("redirect:/users");
			obj.addObject("msg", "Could not save users");
		}
		return obj;
	}
	
}
