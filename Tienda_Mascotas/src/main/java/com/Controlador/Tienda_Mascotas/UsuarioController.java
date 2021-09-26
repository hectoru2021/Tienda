package com.Controlador.Tienda_Mascotas;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Mascotas.UsuarioDAO;
import com.DTO.Tienda_Mascotas.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	
	public ArrayList<UsuarioVO> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
		
		return Dao.listaUsuarios();
	}
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.consultarUsuario(documento);
		
	}
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}	
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento);
	}	
	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(int documento, String nombre, String correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.actualizarUsuario(documento,nombre,correo);	
	}	
}

