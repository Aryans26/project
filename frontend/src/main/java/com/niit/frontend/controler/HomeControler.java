package com.niit.frontend.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.CartItemsDao;
import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Cart;
import com.niit.backend.model.CartItem;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Users;


@Controller
public class HomeControler {
	@Autowired
	Users users;
	
	@Autowired
	UsersDao usersDao;
@Autowired
Category  category;

@Autowired
CategoryDao categoryDao;

@Autowired
Product product;

@Autowired
ProductDao productDao;
@Autowired
CartItem cartItem;
@Autowired
CartItemsDao cartItemDao;

//@RequestMapping("/")
//public String home()
//{
//return "index";	
//}

//public ModelAndView viewcart()
//{
//ModelAndView obj=new ModelAndView("viewcart");
////obj.addObject("viewcart", viewcart);
//return obj;
//}
@RequestMapping(value= "/")
public String viewproducts(Model model)
{
	List<Category> categories=categoryDao.list(); 
	List<Product> products=productDao.list();
	model.addAttribute("cat", new Category());
	model.addAttribute("categories",categories);
	 model.addAttribute("products", products);
	 return "index";
}

@RequestMapping(value= "/viewpro/{id}")
public String viewapro(@PathVariable("id")String id, Model model)
{
	System.out.println(123);
	 Product p=productDao.get(id);
	model.addAttribute("product",p);
	 return "singlepage";
}
@RequestMapping(value= "/view")
public String view(Model model)
{
	 return "singlepage";
}

}
