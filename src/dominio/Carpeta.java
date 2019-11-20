package dominio;

import listas.ILista;
import listas.ListaSE;

public class Carpeta implements Comparable<Carpeta>{
	
	private int maxArchivosPorCarpeta;
	private ILista<String> archivos;
	private String nombreCarpeta;
	
	public Carpeta(int maxArchivosPorCarpeta, String nombreCarpeta){
		this.maxArchivosPorCarpeta = maxArchivosPorCarpeta;
		this.setArchivos(new ListaSE<String>(maxArchivosPorCarpeta));
		this.nombreCarpeta = nombreCarpeta;
	}

	@Override
	public int compareTo(Carpeta arg0) {
		return this.nombreCarpeta.compareTo(arg0.nombreCarpeta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Carpeta))
		{
			return false;
		} else {
			Carpeta car = (Carpeta)obj;
			return this.nombreCarpeta.equals(car.nombreCarpeta);
		}
	}

	public ILista<String> getArchivos() {
		return archivos;
	}

	public void setArchivos(ILista<String> archivos) {
		this.archivos = archivos;
	}
	
	
}
