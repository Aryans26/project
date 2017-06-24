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

import com.niit.backend.Dao.CartDao;
import com.niit.backend.Dao.CartItemsDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Cart;
import com.niit.backend.model.CartItem;
import com.niit.backend.model.Product;
import com.niit.backend.model.Users;

import javafx.scene.control.Alert;


@Controller
public class CartController {
	@Autowired 
	Users user;
	@Autowired 
	UsersDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemsDao cartItemDao;
	
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/addtocart/{id}")
	public ModelAndView cart(@PathVariable("id") String id) {
		System.out.println("getting inside");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			Users u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.get(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setCartItem_Price(product.getP_c());
				cartItemDao.saveorupdate(cartItem);
				cart.setGrand_total(cart.getGrand_total() + product.getP_c());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGrand_total());
				return new ModelAndView("redirect:/");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/viewcart")
	public String viewcart(Model model, HttpSession session) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			Users u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
				List<CartItem> cartItem = cartItemDao.getlist(u.getCart().getCart_Id());
				if(cartItem==null ||cartItem.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				model.addAttribute("cartItem", cartItem);
				session.setAttribute("gtotal",c.getGrand_total());
				session.setAttribute("items",c.getTotal_item());
			    session.setAttribute("cartId", c.getCart_Id());
					
				System.out.println(1223);
				return "viewcart";	
		}
		else
		{
			return "redirect:/";
		}
		
	}
	@RequestMapping("/addtocartR/{id}")
	public ModelAndView cartr(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			Users u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.get(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setCartItem_Price(product.getP_c());
				cartItemDao.saveorupdate(cartItem);
				cart.setGrand_total(cart.getGrand_total() + product.getP_c());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGrand_total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/addtocartC/{id}")
	public ModelAndView cartc(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			Users u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.get(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setCartItem_Price(product.getP_c());
				cartItemDao.saveorupdate(cartItem);
				cart.setGrand_total(cart.getGrand_total() + product.getP_c());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGrand_total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}


	@RequestMapping(value="/Remove/{id}")
	public String RemoveFromCart(@PathVariable("id") String id)
	{
		cartItem=cartItemDao.get(id);
		Cart c=cartItem.getCart();
		c.setGrand_total(c.getGrand_total()-cartItem.getCartItem_Price());
		c.setTotal_item(c.getTotal_item()-1);
		cartDao.saveorupdate(c);
		String cid=(cartItem.getCartItem_Id());
		cartItemDao.delete(cartItemDao.get(cid));
//		(cartItemDao.get(cartItem.getCartItem_Id()));
		return "redirect:/viewcart";
	}
	
@RequestMapping (value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Cart c=cartDao.get((String)session.getAttribute("cartId"));
		String ss= ((String)session.getAttribute("cartId"));
		 try{
		List<CartItem> cartItems=cartItemDao.getlist(ss);
		for(CartItem g:cartItems)
		{
		
		 
		
			
			 CartItem cait =cartItemDao.get(g.getCartItem_Id());
		 cartItemDao.delete(cait);
		
			
		}
		 }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			} 
		
		c.setGrand_total(0.0);
		c.setTotal_item(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items",c.getTotal_item());
		return "redirect:/viewcart";
	}
}
