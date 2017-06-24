package com.niit.frontend.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;

@Controller
public class CategoryControler {
	@Autowired 
	Category category;
	@Autowired 
	CategoryDao categoryDao;
	
	@Autowired 
	Product Product;
	@Autowired 
	ProductDao productDao;
	
	@RequestMapping("/category")
	public ModelAndView category()
	{

	List<Category> categories= categoryDao.list();
	ModelAndView obj=new ModelAndView("category");
	obj.addObject("category", new Category());
	obj.addObject("catogories", categories);
	return obj;
	}
	
	@RequestMapping	(value="/category_Processing", method=RequestMethod.POST)
	public ModelAndView categoryProcessing(@ModelAttribute("category")Category category)
	{
		ModelAndView obj = new ModelAndView("redirect:/category");
		if(categoryDao.saveOrUpdate(category))
		{
			obj.addObject("msg", "Successfully save category");
		}
		else
		{
			obj.addObject("msg", "Could not save category");
		}
		return obj;
	}
	
	@RequestMapping("/edit_Category/{C_id}" )
	public ModelAndView editcategory(@PathVariable("C_id")String C_id)
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("category");
		category=categoryDao.getCategory(C_id);
		obj.addObject("categories",categories);
		obj.addObject("category",category);
		return obj;
	}
	@RequestMapping("/delete_Category/{C_id}")
	public ModelAndView deletecategory(@PathVariable("C_id")String C_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/category");
		category=categoryDao.getCategory(C_id);
		if(categoryDao.delete(category))
		{
			obj.addObject("msg","Category is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Category cannot be deleted");
		}
		return obj;
	}
	@RequestMapping("/dispcategory/{Cat_id}")
	public ModelAndView dispcategory(@PathVariable("Cat_id")String id)
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Catprod");
		List<Product> c= productDao.getproductC(id);
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
	     return obj;
		
	}
	@RequestMapping("/dispproid")
	public String dispprod(@RequestParam("search")String s, Model model )
	{	if(s==null||s.isEmpty())
	{
		System.out.println("No products to display");
		return "redirect:/";
	}
	else
	{
		List<Category> categories=categoryDao.list(); 
		List<Product> products=productDao.getproductPro(s);
		model.addAttribute("cat", new Category());
		model.addAttribute("categories",categories);
		 model.addAttribute("products", products);
	     return "allproducts" ;
	}
	}
	@RequestMapping("/disrate/")
	public ModelAndView disprate()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice();
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
		return obj;
		
	}
	@RequestMapping("/disrate1/")
	public ModelAndView disprate1()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice2();
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
		return obj;
		
	}@RequestMapping("/disrate2/")
	public ModelAndView disprate2()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice3();
		  obj.addObject("cat", new Category());
		     obj.addObject("categories",categories); 
		obj.addObject("pro",c);
		return obj;
		
	}
}
