package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.CompraDAO;
import com.distribuida.entities.Compra;



@Controller
@RequestMapping("/Compras") //Path principal
public class CompraController {

	@Autowired
	private CompraDAO CompraDAO;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<Compra> Compras=CompraDAO.findALL();
			model.addAttribute ("Compras", Compras);
			return "listar-Compras";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<Compra> Compras=CompraDAO.findALL();
		model.addAttribute ("Compras", Compras);
		return "listar-Compras";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCompra")@Nullable Integer idCompra
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idCompra != null) {
				Compra Compra = CompraDAO.findOne(idCompra);
				model.addAttribute("Compra", Compra);
			}
			if(opcion == 1) return "add-Compras";
			else return "del-Compras";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCompra != null) {
			Compra Compra = CompraDAO.findOne(idCompra);
			model.addAttribute("Compra", Compra);
		}
		if(opcion == 1) return "add-Compras";
		else return "del-Compras";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam ("idCompra") @Nullable Integer idCompra
					 ,@RequestParam ("fechaCompra") @Nullable Date fechaCompra
					 ,@RequestParam ("idProveedor") @Nullable Integer idProveedor
					 ,@RequestParam ("idSucursal") @Nullable Integer idSucursal
					 ,@RequestParam ("idVendedor") @Nullable Integer idVendedor
					 ,@RequestParam ("total") @Nullable Double total 
					 ,Model model
			) {
		/*try {
			if(idCompra == null) {
				Compra Compra = new Compra(0, cedula, nombre, apellido, telefono, correo);
				CompraDAO.add(Compra);
			}else {
				Compra Compra2 = new Compra(idCompra, cedula, nombre, apellido, telefono, correo);
				CompraDAO.up(Compra2);
			}
				
			return "redirect:/Compras/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCompra == null) {
			Compra Compra = new Compra(0,fechaCompra, idProveedor, idSucursal, idVendedor, total);
			CompraDAO.add(Compra);
		}else {
			Compra Compra2 = new Compra(idCompra,fechaCompra, idProveedor, idSucursal, idVendedor, total);
			CompraDAO.up(Compra2);
		}
			
		return "redirect:/Compras/findAll";
	}
	
	@GetMapping("/dell")
	public String dell(@RequestParam  ("idCompra") @Nullable Integer idCompra) {
		/*try {
			CompraDAO.dell(idCompra);
			return "redirect:/Compras/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		CompraDAO.dell(idCompra);
		return "redirect:/Compras/findAll";
	}
	
}
