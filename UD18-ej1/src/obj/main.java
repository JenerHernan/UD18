package obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC","root","Haloreach3");
			System.out.print("Server Connected");
			Statement st = conexion.createStatement();
			st.executeUpdate("CREATE DATABASE UD18");
			st.executeUpdate("USE UD18");
			st.executeUpdate("CREATE TABLE fabricantes("
					+ " Codigo int auto_increment primary key, "
					+ " Nombre varchar(100)"
					+ ")");
			st.executeUpdate("CREATE TABLE articulos("
					+ "Codigo int auto_increment primary key, "
					+ "Nombre varchar(100) not null, "
					+ "Precio int not null, "
					+ "Fabricante int not null, "
					+ "key Fabricante(Fabricante), "
					+ "constraint `articulos_ibfk_1` foreign key (Fabricante) references fabricantes(Codigo)"
					+ ")");
			st.executeUpdate("INSERT INTO fabricantes VALUES "
					+ "(1,'Fabricante1'),"
					+ "(2,'Fabricante2'),"
					+ "(3,'Fabricante3'),"
					+ "(4,'Fabricante4'),"
					+ "(5,'Fabricante5')");
			st.executeUpdate("INSERT INTO articulos VALUES "
					+ "(1,'Articulo1',10,1),"
					+ "(2,'Articulo2',5,2),"
					+ "(3,'Articulo3',6,3),"
					+ "(4,'Articulo4',20,4),"
					+ "(5,'Articulo5',1,5)");
			
			conexion.close();
			
		}
		catch(SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con la base de datos");
			System.out.print(ex);
		}

	}
}
