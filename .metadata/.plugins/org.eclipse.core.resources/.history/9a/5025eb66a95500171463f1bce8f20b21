package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.kingfisherbackend.Dao.BillingDao;
import com.niit.kingfisherbackend.Dao.CardDao;
import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.Dao.OrderDao;
import com.niit.kingfisherbackend.Dao.OrderItemsDao;
import com.niit.kingfisherbackend.Dao.PayDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.ShippingAddressDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Billing;
import com.niit.kingfisherbackend.model.Card;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.CartItem;
import com.niit.kingfisherbackend.model.Order;
import com.niit.kingfisherbackend.model.OrderItems;
import com.niit.kingfisherbackend.model.Pay;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.ShippingAddress;
import com.niit.kingfisherbackend.model.User;
import com.niit.kingfisherfrontend.Otp.Otpganarater;

@Controller
public class OrderController {


	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	ShippingAddress shippingAddress;
	@Autowired
	ShippingAddressDao shippingAddressDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItem> cartItems;
	
	@Autowired
    private JavaMailSender mailSender;
	
	String o;
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			product=null;
			cartItems = cartItemDao.getlist(cart.getCart_id());
			if(cartItems==null || cartItems.isEmpty())
			{
				return "redirect:/viewcart";
			}
			else
			{
				billing = billingDao.get(user.getU_Id());
				List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getU_Id());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new ShippingAddress());
				session.setAttribute("p", product);
			}
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			cartItems=null;
			product = productDao.getproduct(id);
			billing = billingDao.get(user.getU_Id());
			List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getU_Id());
			
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("shippingAddress", new ShippingAddress());
			session.setAttribute("p", product);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") ShippingAddress sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shippingAddress = sh;
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getU_Id());
		model.addAttribute("shippingAddresies", shippingAddresies);
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("product", product);
		
		return "addressorder";
	}

	@RequestMapping("/pay")
	public String pay(Model model) {
		List<Card> cards = cardDao.getcardbyuser(user.getU_Id());
		model.addAttribute("cards", cards);
		model.addAttribute("card", new Card());
		return "Payment";
	}

	@RequestMapping("/payment")
	public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
				
 		System.out.println(1324);
		int a;
		System.out.println(str);
				
		if (str.equalsIgnoreCase("Start Subscription")) {
			a = 2;
		} else {
			a = Integer.parseInt(str);
		}
		System.out.println(a);
		
		switch (a) {
		case 1:
				if(otp.equals(o))
				{
					pay.setPay_may("COD");
					pay.setStatus("no");
				}
				else
				{
					return "redirect:/pay";
				}
			 
			break;
		case 2:
			pay.setPay_may("card");
			pay.setStatus("yes");
			payDao.Saveorupdate(pay);
			cardDao.Saveorupdate(c);

			break;
		case 3:
			pay.setPay_may("Internet Banking");
			pay.setStatus("yes");

		}

		return "redirect:/orderconfirmation";
	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billing);
		order.setShippingAddress(shippingAddress);
		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			order.setGrand_total(product.getPrice());
			orderDao.Saveorupdate(order);
			orderItems.setOrder(order);
			orderItems.setP_id(product.getP_id());
			orderItemsDao.Saveorupdate(orderItems);
			cart.setGroand_total(cart.getGroand_total() - cartItem.getPrice());
			cart.setTotal_item(cart.getTotal_item() - 1);
			session.setAttribute("items", cart.getTotal_item());
			cartDao.saveCart(cart);
			cartItemDao.delete(cartItemDao.getlistall(cart.getCart_id(),product.getP_id()).getCi_id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrand_total(cart.getGroand_total());
			orderDao.Saveorupdate(order);
			for(CartItem c:cartItems)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setP_id(c.getProduct().getP_id());
				System.out.println(3443);
				orderItemsDao.Saveorupdate(orderItems);
				cartItemDao.delete(c.getCi_id());
			}
			cart.setGroand_total(0.0);
			cart.setTotal_item(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotal_item());
			cartDao.saveCart(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}


@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getUseremail(currusername);      
	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
	o=ot.Otpga();
	String recipientAddress = user.getU_email();
	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

// prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
// sends the e-mail
mailSender.send(email);

 
// forwards to the view named "Result"
//return "Result";
}
}
}