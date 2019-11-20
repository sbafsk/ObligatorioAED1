package dominio;

import listas.ILista;
import listas.ListaSEOrd;

public class Fichero {
	
	private int maxArchivosPorCarpeta;
	private ILista<Carpeta> carpetas;
	
	public Fichero(int maxArchivosPorCarpeta)
	{
		this.maxArchivosPorCarpeta = maxArchivosPorCarpeta;
		this.setCarpetas(new ListaSEOrd<Carpeta>());
	}

	public ILista<Carpeta> getCarpetas() {
		return carpetas;
	}

	public void setCarpetas(ILista<Carpeta> carpetas) {
		this.carpetas = carpetas;
	}
}
