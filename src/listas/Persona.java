package listas;

public class Persona implements Comparable<Persona>{

	private String nombre;
	private int cedula;
	
	public Persona(String nombre, int cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}
		
	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre); // -> Por String ascendente
		// return o.nombre.compareTo(this.nombre) // -> Por String descendente
		// return this.cedula - o.cedula; -> Por int ascendente
		// return o.cedula - this.cedula; -> Por int descendente
	}	
	
	@Override
	public String toString() {
		return String.format("Persona: %s (CI: %s)", nombre,cedula);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Persona))
		{
			return false;
		} else {
			Persona p = (Persona)obj;
			return p.cedula == this.cedula;
		}
	}
	

}
