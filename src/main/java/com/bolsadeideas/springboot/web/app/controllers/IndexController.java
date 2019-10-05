package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(ModelMap model) {
	
		model.addAttribute("titulo", "Hola Spring Framework con ModelMap!");
		return "index";
	}

	@GetMapping({"/indexmap"})
	public String index(Map<String, Object> map) {
	
		map.put("titulo", "Hola Spring Framework con Map!");
		return "index";
	}

	@GetMapping({"/home", "/index"})
	public String index(Model model) {
	
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}
	
	@GetMapping({"/indexmv"})
	public ModelAndView index(ModelAndView mv) {
	
		mv.addObject("titulo", "Hola Spring Framework con ModelAndView!");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/perfil") 
	public String perfil(Model model) {
	
		Usuario usuario = new Usuario();
		usuario.setNombre("Javier");
		usuario.setApellido("Lurquí");
		usuario.setEmail("email@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario : ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar") 
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(new Usuario("Javi", "Lurquí", "javi@correo.com")); 
		usuarios.add(new Usuario("John", "Doe", "john@correo.com"));
		usuarios.add(new Usuario("Jane", "Doe", "jane@correo.com"));		
		usuarios.add(new Usuario("Tornado", "Roe", "tornado@correo.com"));		
		
		return usuarios;
	}
	
}
