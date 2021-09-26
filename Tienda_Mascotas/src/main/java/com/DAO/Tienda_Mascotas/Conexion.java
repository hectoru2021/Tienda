package com.DAO.Tienda_Mascotas;

import java.sql.*;

public class Conexion {
	
	//Parámetros de Conexión
	String bd = "tienda_mascotas27";
	String Login = "root";
	String password = "$Mechuda1966";
	String url = "jdbc:mysql://localhost/"+bd;
			
	Connection con = null;
	
	//Constructor de Conexión
	public Conexion()
	{
		try
		{
			//Obtener el driver para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión
			con=DriverManager.getConnection(url,Login,password);
			if(con != null)
				System.out.println("Conexión a la Base de datos: " +bd + "Exitosa");
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexión: "+ e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de Conexión: "+ e);
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexión: "+ e);
		}
	}	
			
	//Metodo para retornar la conexión
	public Connection getCon()
	{
		return con;
	}	
	
	//Metodo para desconectar
	public void desconectar()
	{
		con = null;
	}	
	
}
