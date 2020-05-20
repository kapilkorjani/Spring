package com.kapil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1")int a,@RequestParam("t2") int b ) {
		
//		int a = Integer.parseInt(request.getParameter("t1"));
//		int b  = Integer.parseInt(request.getParameter("t2"));
		int k = a+b;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",k);
		
		return mv;
	}
}
