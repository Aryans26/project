package com.niit.frontend.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Supplier;

import com.niit.frontend.fileinput.*;



@Controller
public class AddProductContoller  {
	@Autowired 
	Product product;
	@Autowired 
	ProductDao productDao;
	
	@Autowired 
	Category category;
	
	@Autowired 
	CategoryDao categoryDao; 
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	String path="E:\\project\\frontend\\src\\main\\webapp\\resource\\images\\";
	
	@RequestMapping("/addproduct")
	public ModelAndView addproduct()
	{
		List<Product> products= productDao.list();
		
	List<Category> categorylist = categoryDao.list();
	List<Supplier> supplierlist = supplierDao.list();
 	ModelAndView obj=new ModelAndView("addproduct");
	obj.addObject("addproduct", new Product());
	obj.addObject("products", products);
	obj.addObject("categorylist", categorylist);
	obj.addObject("supplierlist", supplierlist);
	return obj;
	}
	
	@RequestMapping	(value="/addproduct_Processing", method=RequestMethod.POST)
	public ModelAndView productProcessing(@ModelAttribute("addproduct")Product product)
	{
		ModelAndView obj = new ModelAndView("redirect:/addproduct");
		if(productDao.saveorupdate(product))
		{
//			System.out.println("Entering ");
			try{
			FileInput.upload(path, product.getPimg(), product.getP_id()+".jpg");
			}
			catch (Exception e){
				System.out.println("File Upload Error"+e);
			}
			obj.addObject("msg", "Successfully save Product");
		}
		else
		{
			obj.addObject("msg", "Could not save Product");
		}
		return obj;
	}
	
	@RequestMapping("/edit_Product/{P_id}")
	public ModelAndView editproduct(@PathVariable("P_id")String p_id)
	{
		List<Category> categorylist = categoryDao.list();
		List<Supplier> supplierlist = supplierDao.list();
		List<Product> products=productDao.list();
		ModelAndView obj=new ModelAndView("addproduct");
		product=productDao.get(p_id);
		obj.addObject("products",products);
		obj.addObject("addproduct",product);
		obj.addObject("categorylist", categorylist);
		obj.addObject("supplierlist", supplierlist);
		return obj;
	}
	@RequestMapping("/delete_Product/{P_id}")
	public ModelAndView deleteproduct(@PathVariable("P_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/addproduct");
		product=productDao.get(p_id);
		if(productDao.delete(product))
		{
			obj.addObject("msg","Product is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Product cannot be deleted");
		}
		return obj;
	}
	
}
