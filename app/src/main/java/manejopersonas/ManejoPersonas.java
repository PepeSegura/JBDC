package manejopersonas;

import introduccionjdbc.*;
import introduccionjdbc.datos.*;
import java.util.*;

public class ManejoPersonas {

	public static void main(String[] args) {
		PersonaJDBC personaJDBC = new PersonaJDBC();
		// personaJDBC.insert("Alberto","Juarez");
		//personaJDBC.update(2, "ana", "garcia");
		//personaJDBC.delete(4);
		List<Persona> personas=personaJDBC.select();
		
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}

}
