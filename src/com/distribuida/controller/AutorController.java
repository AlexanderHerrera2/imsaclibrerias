package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;



@Controller
@RequestMapping("/Autors") //Path principal
public class AutorController {

	@Autowired
	private AutorDAO AutorDAO;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<Autor> Autors=AutorDAO.findALL();
			model.addAttribute ("Autors", Autors);
			return "listar-Autors";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<Autor> Autors=AutorDAO.findALL();
		model.addAttribute ("Autors", Autors);
		return "listar-Autors";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idAutor")@Nullable Integer idAutor
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idAutor != null) {
				Autor Autor = AutorDAO.findOne(idAutor);
				model.addAttribute("Autor", Autor);
			}
			if(opcion == 1) return "add-Autors";
			else return "del-Autors";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idAutor != null) {
			Autor Autor = AutorDAO.findOne(idAutor);
			model.addAttribute("Autor", Autor);
		}
		if(opcion == 1) return "add-Autors";
		else return "del-Autors";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idAutor") @Nullable Integer idAutor
					 ,@RequestParam("nombre") @Nullable String nombre
					 ,@RequestParam("apellido") @Nullable String apellido
					 ,@RequestParam("pais") @Nullable String pais
					 ,@RequestParam("direccion") @Nullable String direccion
					 ,@RequestParam("telefono") @Nullable String telefono
					 ,@RequestParam("correo") @Nullable String correo
					 ,Model model
			) {
		/*try {
			if(idAutor == null) {
				Autor Autor = new Autor(0, cedula, nombre, apellido, telefono, correo);
				AutorDAO.add(Autor);
			}else {
				Autor Autor2 = new Autor(idAutor, cedula, nombre, apellido, telefono, correo);
				AutorDAO.up(Autor2);
			}
				
			return "redirect:/Autors/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idAutor == null) {
			Autor Autor = new Autor(0, nombre, apellido, pais, direccion, telefono, correo);
			AutorDAO.add(Autor);
		}else {
			Autor Autor2 = new Autor(idAutor, nombre, apellido, pais, direccion, telefono, correo);
			AutorDAO.up(Autor2);
		}
			
		return "redirect:/Autors/findAll";
	}
	
	@GetMapping("/dell")
	public String dell(@RequestParam ("idAutor") @Nullable Integer idAutor) {
		/*try {
			AutorDAO.dell(idAutor);
			return "redirect:/Autors/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		AutorDAO.dell(idAutor);
		return "redirect:/Autors/findAll";
	}
	
}
