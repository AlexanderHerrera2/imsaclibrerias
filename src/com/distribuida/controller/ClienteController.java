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

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;



@Controller
@RequestMapping("/clientes") //Path principal
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		/*try {
			List<Cliente> clientes=clienteDAO.findALL();
			model.addAttribute ("clientes", clientes);
			return "listar-clientes";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		List<Cliente> clientes=clienteDAO.findALL();
		model.addAttribute ("clientes", clientes);
		return "listar-clientes";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCliente")@Nullable Integer idCliente
						  ,@RequestParam("opcion") @Nullable Integer opcion
						  ,Model model
			) {
		/*try {
			if(idCliente != null) {
				Cliente cliente = clienteDAO.findOne(idCliente);
				model.addAttribute("cliente", cliente);
			}
			if(opcion == 1) return "add-clientes";
			else return "del-clientes";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCliente != null) {
			Cliente cliente = clienteDAO.findOne(idCliente);
			model.addAttribute("cliente", cliente);
		}
		if(opcion == 1) return "add-clientes";
		else return "del-clientes";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCliente") @Nullable Integer idCliente
					 ,@RequestParam("cedula") @Nullable String cedula
					 ,@RequestParam("nombre") @Nullable String nombre
					 ,@RequestParam("apellido") @Nullable String apellido
					 ,@RequestParam("direccion") @Nullable String direccion
					 ,@RequestParam("telefono") @Nullable String telefono
					 ,@RequestParam("correo") @Nullable String correo
					 ,Model model
			) {
		/*try {
			if(idCliente == null) {
				Cliente cliente = new Cliente(0, cedula, nombre, apellido, telefono, correo);
				clienteDAO.add(cliente);
			}else {
				Cliente cliente2 = new Cliente(idCliente, cedula, nombre, apellido, telefono, correo);
				clienteDAO.up(cliente2);
			}
				
			return "redirect:/clientes/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		if(idCliente == null) {
			Cliente cliente = new Cliente(0, cedula, nombre, apellido, telefono, correo);
			clienteDAO.add(cliente);
		}else {
			Cliente cliente2 = new Cliente(idCliente, cedula, nombre, apellido, telefono, correo);
			clienteDAO.up(cliente2);
		}
			
		return "redirect:/clientes/findAll";
	}
	
	@GetMapping("/dell")
	public String dell(@RequestParam ("idCliente") @Nullable Integer idCliente) {
		/*try {
			clienteDAO.dell(idCliente);
			return "redirect:/clientes/findAll";
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		clienteDAO.dell(idCliente);
		return "redirect:/clientes/findAll";
	}
	
}
