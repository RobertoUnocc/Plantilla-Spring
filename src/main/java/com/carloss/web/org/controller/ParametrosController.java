package com.carloss.web.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParametrosController {

	
	@GetMapping("/parametros")
	public String param( 
			@RequestParam(name = "texto", required = false, defaultValue = "dato...") String texto,
			Model model) {
		
		model.addAttribute("resultado", "El texto enviado es "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		
		model.addAttribute("resultado", "El texto enviado es "+saludo+" y el numero es '"+numero+"'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-servlet")
	public String param(HttpServletRequest request, Model model) {
		
		String saludo= request.getParameter("saludo");
		Integer numero=null;
		try {
			 numero= Integer.parseInt(request.getParameter("numero"));			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			numero=0;
		}
		
		
		model.addAttribute("resultado", "El texto enviado es "+saludo+" y el numero es '"+numero+"'");
		return "params/ver";
	}
	
}
