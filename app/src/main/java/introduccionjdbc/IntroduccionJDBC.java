package introduccionjdbc;
import java.sql.*;
public class IntroduccionJDBC {
	
	public static void main(String[] args) {
		
		String  url="jdbc:mysql://localhost:3306/sga?useSSL=false";
		String sql="select id_persona,nombre,apellido from persona";
		try (Connection conexion=DriverManager.getConnection(url,"root","#ff0016#");Statement stmt=conexion.createStatement();	ResultSet result=stmt.executeQuery(sql);){
			
		//	Connection conexion=DriverManager.getConnection(url,"root","#ff0016#");
		//	Statement stmt=conexion.createStatement();
		
		//	ResultSet result=stmt.executeQuery(sql);
			
			while(result.next()) {
				System.out.print("Id:"+result.getInt(1));
				System.out.print(" nombre:"+result.getString(2));
				System.out.println(" apellido:"+result.getString(3));
				
			}
			//result.close(); etc..
			
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("no es posible connectar");
		}
		
	}

}
