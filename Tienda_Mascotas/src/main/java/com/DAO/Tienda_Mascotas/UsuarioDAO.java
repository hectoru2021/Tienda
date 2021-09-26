package com.DAO.Tienda_Mascotas;

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_Mascotas.UsuarioVO;

//Esta clase permite el acceso a la Base de datos

public class UsuarioDAO {
	
	//Metodo para consultar los usuarios
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM t_usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("email_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("clave"));
				
				milista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
			
			
		}
		catch(Exception e) {

			System.out.println("Error No se pudo Conectar" + e);
		}
		
		return milista;
	}
	
	//Consultar un usuario por número de documento
	
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS WHERE cedula_usuario = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("email_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("clave"));
				
				milista.add(persona);
				
			}
			rs.close();
			consulta.close();
			con.desconectar();
			
				
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No encontrado); " + e);
		}
		return milista;
	}
	
	public void registrarUsuario(UsuarioVO persona)
	{
		Conexion con = new Conexion();
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values('"+persona.getCedula()+"','"+
					persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+
					persona.getClave()+"')");
			System.out.println("El usuario ha sido adicionado");
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexión: Usuario no adicionado" + e);
		}
		
	}
	//Eliminar un usuario por número de documento
	
		public void eliminarUsuario(int documento)
		{
			Conexion con = new Conexion();
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_USUARIOS WHERE cedula_usuario = ?");
				consulta.setInt(1, documento);
				consulta.executeUpdate();
				System.out.println("El usuario ha sido eliminado");
								
				consulta.close();
				con.desconectar();
				
					
			}
			catch(Exception e)
			{
				System.out.println("Error Usuario No encontrado); " + e);
			}
		}	
	//Actualizar un usuario por número de documento
			
			public void actualizarUsuario(int documento, String nombre, String correo)
			{
				Conexion con = new Conexion();
				try
				{
					PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_USUARIOS SET Nombre_usuario = ?,email_usuario = ? WHERE cedula_usuario = ? ");
					consulta.setString(1, nombre);
					consulta.setString(2, correo);
					consulta.setInt(3, documento);
					consulta.executeUpdate();
					System.out.println("El usuario ha sido Actualizado");
									
					consulta.close();
					con.desconectar();
					
						
				}
				catch(Exception e)
				{
					System.out.println("Error Usuario No encontrado: " + e);
				}	
			
			
		}
}
