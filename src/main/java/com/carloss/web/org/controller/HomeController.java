package com.carloss.web.org.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.carloss.web.org.models.Usuarios;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		
		Usuarios usuario=new Usuarios();
		usuario.setApellido("Unocc");
		usuario.setNombre("Carlos");
		
		/* se puede comsumir la info de usuarios con el metodo List */
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("Titulo","Listado de Usuarios");
		
		return "Listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuarios> poblacionUsuarios(){
		List<Usuarios> usuarios= Arrays.asList(
				new Usuarios("CArlos","uncc","carlitos 2017uno@gmail.com"),
				new Usuarios("Roger","Sihuinta","roger0506_ @gmail.com")
				);
		
		return usuarios;
	}
}
