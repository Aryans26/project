package com.niit.frontend.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.model.Supplier;
@Controller
public class SupplierController {
	@Autowired 
	Supplier supplier;
	@Autowired 
	SupplierDao supplierDao;
	
	@RequestMapping("/supplier")
	public ModelAndView category()
	{
	List<Supplier> suppliers = supplierDao.list();
	ModelAndView obj=new ModelAndView("supplier");
	obj.addObject("supplier", new Supplier());
	obj.addObject("suppliers", suppliers);
	return obj;
	}
	
	@RequestMapping	(value="/supplier_Processing", method=RequestMethod.POST)
	public ModelAndView supplierProcessing(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView obj = new ModelAndView("redirect:/supplier");
		if(supplierDao.saveorupdate(supplier))
		{
			obj.addObject("msg", "Successfully save supplier");
		}
		else
		{
			obj.addObject("msg", "Could not save supplier");
		}
		return obj;
	}
	

	@RequestMapping("/edit_Supplier/{S_id}")
	public ModelAndView editsupplier(@PathVariable("S_id")String S_id)
	{
		List<Supplier> suppliers=supplierDao.list();
		ModelAndView obj=new ModelAndView("supplier");
		supplier=supplierDao.get(S_id);
		obj.addObject("suppliers",suppliers);
		obj.addObject("supplier",supplier);
		return obj;
	}
	@RequestMapping("/delete_Supplier/{S_id}")
	public ModelAndView deletesupplier(@PathVariable("S_id")String S_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		supplier=supplierDao.get(S_id);
		if(supplierDao.delete(supplier))
		{
			obj.addObject("msg","Supplier is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Supplier cannot be deleted");
		}
		return obj;
	}
	
}
