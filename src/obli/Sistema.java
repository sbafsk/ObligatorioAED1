package obli;

import dominio.Carpeta;
import dominio.Fichero;
import listas.ILista;
import obli.Retorno.TipoRet;

public class Sistema implements ISistema {

	private Fichero[] ficheros;
	private int cantFicheros;
	private int maxArchivosPorCarpeta;

	@Override
	public Retorno crearSistemaArchivos(int cantFicheros, int maxArchivosPorCarpeta) {

		if (cantFicheros <= 0) {
			return new Retorno(TipoRet.ERROR_1);
		} else {
			this.ficheros = new Fichero[cantFicheros];
			for (int i = 0; i < ficheros.length; i++) {
				ficheros[i] = new Fichero(maxArchivosPorCarpeta);
			}
			this.cantFicheros = cantFicheros;
			this.maxArchivosPorCarpeta = maxArchivosPorCarpeta;

			return new Retorno(TipoRet.OK);
		}
	}

	@Override
	public Retorno destruirSistemaArchivos() {
		this.ficheros = null;

		return new Retorno(TipoRet.OK);
	}

	@Override
	public Retorno agregarCarpeta(int fichero, String nombreCarpeta) {
		if (fichero < 1 || fichero > cantFicheros) {
			return new Retorno(TipoRet.ERROR_1);
		} else {
			fichero--;
			if (ficheros[fichero].getCarpetas().existe(new Carpeta(-1, nombreCarpeta))) {
				return new Retorno(TipoRet.ERROR_2);
			} else {
				ficheros[fichero].getCarpetas().insertarOrd(new Carpeta(maxArchivosPorCarpeta, nombreCarpeta));
				return new Retorno(TipoRet.OK);
			}
		}
	}

	@Override
	public Retorno eliminarCarpeta(int fichero, String nombreCarpeta) {		
		if (fichero < 1 || fichero > cantFicheros) {
			return new Retorno(TipoRet.ERROR_1);
		} else {
			fichero--;
			if (!ficheros[fichero].getCarpetas().existe(new Carpeta(-1, nombreCarpeta))) {
				return new Retorno(TipoRet.ERROR_2);				
			} else {				
				ficheros[fichero].getCarpetas().borrar(new Carpeta(maxArchivosPorCarpeta, nombreCarpeta));
				return new Retorno(TipoRet.OK);
			}
		}
	}

	@Override
	public Retorno listarCarpeta(int fichero, String nombreCarpeta) {
		if (fichero < 1 || fichero > cantFicheros) {
			return new Retorno(TipoRet.ERROR_1);
		} else {
			fichero--;
			if (!ficheros[fichero].getCarpetas().existe(new Carpeta(-1, nombreCarpeta))) {
				return new Retorno(TipoRet.ERROR_2);
			} else {
				String strRet = "";
				Carpeta car = ficheros[fichero].getCarpetas().recuperar(new Carpeta(-1, nombreCarpeta));
				if (car.getArchivos().esVacia()) {
					strRet = "No existen archivos";
				} else {
					for (String arch : car.getArchivos()) {
						strRet += arch + "|";
					}
					strRet = strRet.substring(0, strRet.length() - 1);
				}
				return new Retorno(TipoRet.OK, 0, strRet);
			}
		}
	}

	@Override
	public Retorno insertarArchivo(int fichero, String nombreCarpeta, int posicionArchivo, String nomArchivo) {
		
		Carpeta carpeta = new Carpeta(-1, nombreCarpeta);
		
		System.out.println(nombreCarpeta + "/" + nomArchivo);
		System.out.println("largo " + carpeta.getArchivos().largo());
		System.out.println("posicion " + posicionArchivo);
		
		if (fichero < 1 || fichero > cantFicheros) {
			return new Retorno(TipoRet.ERROR_1);
		} else {
			fichero--;
			if (!ficheros[fichero].getCarpetas().existe(carpeta)) {
				return new Retorno(TipoRet.ERROR_2);
			} else {				
				if(posicionArchivo < 1 || posicionArchivo > carpeta.getArchivos().largo() + 1){
					return new Retorno(TipoRet.ERROR_3);
				} else {					
					ILista<String> listaArchivos = carpeta.getArchivos(); 					
					listaArchivos.insertarEnPos(nomArchivo, posicionArchivo);
					carpeta.setArchivos(listaArchivos);
					System.out.println("largo new" + carpeta.getArchivos().largo());
					return new Retorno(TipoRet.OK);
					
				}
				
			}
		}			
	}

	@Override
	public Retorno borrarArchivo(int fichero, String nombreCarpeta, int posicionArchivo) {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno borrarTodo(int fichero) {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno borrarCarpetasConNombre(String nombreCarpeta) {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno imprimirFichero() {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno insertarArchivoExpansivo(int fichero, String nombreCarpeta, int posicionArchivo, String nomArchivo) {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno imprimirArchivosOrdenados() {
		return new Retorno(TipoRet.NO_IMPLEMENTADA);
	}

}
