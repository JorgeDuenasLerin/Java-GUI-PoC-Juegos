package otros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjemploDB {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			/*
			 * Requisitos previos:
			 * 
			 * 		Instalar Mysql
			 * 			Ubuntu:
			 * 				apt install mysql-common mysql-workbench
			 *  
			 * 				https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04
			 * 				https://www.conchaalviz.com/blog/como-habilitar-contrasena-para-el-root-de-mysql-en-linux/
			 * 
			 * 		Instalar el driver para hablar con MySQL (Puede ser Oracle u otra base de datos pero en este ejemplo usamos MySQL)
			 * 			https://dev.mysql.com/downloads/connector/j/
			 * 
			 * 		Añadir a la configuración del proyecto en eclipse la librería jar de MySQL
			 * 			Proyecto -> Propiedades -> JavaBuildPath -> Add External Jar
			 * 			Seleccionar dónde se haya instalado 
			 * 			Ubuntu:
			 * 				/usr/share/java/mysql-connector.XXXXX.jar
			 * 
			 * 		Restaurar una base de datos o crearla
			 * 		Hacer una consulta y mostrar los resultados
			 * 		Tomar un pantallazo
			 * */
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/hashtag?serverTimezone=UTC","root","1234");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from USUARIO");  
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			
			con.close();  
		} catch(Exception e){
			System.out.println(e);
		}  
	}

}
