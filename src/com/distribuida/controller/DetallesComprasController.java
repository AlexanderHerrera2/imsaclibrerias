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

import com.distribuida.dao.DetallesComprasDAO;
import com.distribuida.entities.DetallesCompras;



@Controller
@RequestMapping("/DetallesComprass") //Path principal
public class DetallesComprasController {

	@Autowired
	private DetallesComprasDAO DetallesComprasDAO;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<DetallesCompras> DetallesComprass=DetallesComprasDAO.findALL();
			model.addAttribute ("DetallesComprass", DetallesComprass);
			return "listar-DetallesComprass";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<DetallesCompras> DetallesComprass=DetallesComprasDAO.findALL();
		model.addAttribute ("DetallesComprass", DetallesComprass);
		return "listar-DetallesComprass";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idDetalleCompra")@Nullable Integer idDetalleCompra
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idDetallesCompras != null) {
				DetallesCompras DetallesCompras = DetallesComprasDAO.findOne(idDetallesCompras);
				model.addAttribute("DetallesCompras", DetallesCompras);
			}
			if(opcion == 1) return "add-DetallesComprass";
			else return "del-DetallesComprass";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idDetalleCompra != null) {
			DetallesCompras DetallesCompras = DetallesComprasDAO.findOne(idDetalleCompra);
			model.addAttribute("DetallesCompras", DetallesCompras);
		}
		if(opcion == 1) return "add-DetallesComprass";
		else return "del-DetallesComprass";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam ("idDetalleCompra") @Nullable Integer idDetalleCompra
					 ,@RequestParam ("idCompra") @Nullable Integer idCompra
					 ,@RequestParam ("idProducto") @Nullable Integer idProducto
					 ,@RequestParam ("cantidad") @Nullable Integer cantidad
					 ,@RequestParam ("precioUnitario") @Nullable double precioUnitario
					 ,Model model
			) {/**
		
		/*try {
			if(idDetallesCompras == null) {
				DetallesCompras DetallesCompras = new DetallesCompras(0, cedula, nombre, apellido, telefono, correo);
				DetallesComprasDAO.add(DetallesCompras);
			}else {
				DetallesCompras DetallesCompras2 = new DetallesCompras(idDetallesCompras, cedula, nombre, apellido, telefono, correo);
				DetallesComprasDAO.up(DetallesCompras2);
			}
				
			return "redirect:/DetallesComprass/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idDetalleCompra == null) {
			DetallesCompras DetallesCompras = new DetallesCompras(1, idCompra, idProducto, cantidad, precioUnitario);
			DetallesComprasDAO.add(DetallesCompras);
		}else {
			DetallesCompras DetallesCompras2 = new DetallesCompras(idDetalleCompra, idCompra, idProducto, cantidad, precioUnitario);
			DetallesComprasDAO.up(DetallesCompras2);
		}
			
		return "redirect:/DetallesComprass/findAll";
	}
	
	@GetMapping("/dell")
	public String dell(@RequestParam  ("idDetalleCompra") @Nullable Integer idDetalleCompra) {
		/*try {
			DetallesComprasDAO.dell(idDetallesCompras);
			return "redirect:/DetallesComprass/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		DetallesComprasDAO.dell(idDetalleCompra);
		return "redirect:/DetallesComprass/findAll";
	}
	
}
