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

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;



@Controller
@RequestMapping("/Categorias") //Path principal
public class CategoriaController {

	@Autowired
	private CategoriaDAO CategoriaDAO;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<Categoria> Categorias=CategoriaDAO.findALL();
			model.addAttribute ("Categorias", Categorias);
			return "listar-Categorias";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<Categoria> Categorias=CategoriaDAO.findALL();
		model.addAttribute ("Categorias", Categorias);
		return "listar-Categorias";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCategoria")@Nullable Integer idCategoria
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idCategoria != null) {
				Categoria Categoria = CategoriaDAO.findOne(idCategoria);
				model.addAttribute("Categoria", Categoria);
			}
			if(opcion == 1) return "add-Categorias";
			else return "del-Categorias";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCategoria != null) {
			Categoria Categoria = CategoriaDAO.findOne(idCategoria);
			model.addAttribute("Categoria", Categoria);
		}
		if(opcion == 1) return "add-Categorias";
		else return "del-Categorias";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCategoria") @Nullable Integer idCategoria
					 ,@RequestParam("categoria") @Nullable String categoria
					 ,@RequestParam("descripcion") @Nullable String descripcion
					 ,Model model
			) {
		/*try {
			if(idCategoria == null) {
				Categoria Categoria = new Categoria(0, cedula, nombre, apellido, telefono, correo);
				CategoriaDAO.add(Categoria);
			}else {
				Categoria Categoria2 = new Categoria(idCategoria, cedula, nombre, apellido, telefono, correo);
				CategoriaDAO.up(Categoria2);
			}
				
			return "redirect:/Categorias/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCategoria == null) {
			Categoria Categoria = new Categoria(0, categoria, descripcion);
			CategoriaDAO.add(Categoria);
		}else {
			Categoria Categoria2 = new Categoria(idCategoria, categoria, descripcion);
			CategoriaDAO.up(Categoria2);
		}
			
		return "redirect:/Categorias/findAll";
	}
	
	@GetMapping("/dell")
	public String dell(@RequestParam ("idCategoria") @Nullable Integer idCategoria) {
		/*try {
			CategoriaDAO.dell(idCategoria);
			return "redirect:/Categorias/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		CategoriaDAO.dell(idCategoria);
		return "redirect:/Categorias/findAll";
	}
	
}
