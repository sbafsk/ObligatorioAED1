package listas;

public class ListaSEOrd<T extends Comparable<T>> extends ListaSE<T> {
	@Override
	public void insertarPpio(T dato) {
		throw new UnsupportedOperationException("No se puede insertar al principio en una lista ordenada (ListaSEOrd). Cree a la lista como una ListaSE.");
	}
	
	@Override
	public void insertarFin(T dato) {
		throw new UnsupportedOperationException("No se puede insertar al final en una lista ordenada (ListaSEOrd). Cree a la lista como una ListaSE.");
	}
	
	@Override
	public void insertarEnPos(T dato, int k) {
		throw new UnsupportedOperationException("No se puede insertar en una posición k en una lista ordenada (ListaSEOrd). Cree a la lista como una ListaSE.");
	}
	
	@Override
	public void insertarOrd(T dato) {
		if(inicio == null || dato.compareTo(inicio.getDato()) <= 0){
			inicio = new NodoLista<T>(dato, inicio);
		} else {
			NodoLista<T> aux = inicio;
			while(aux.getSig() != null && dato.compareTo(aux.getSig().getDato()) > 0)
			{
				aux = aux.getSig();
			}
			NodoLista<T> nuevo = new NodoLista<T>(dato, aux.getSig());
			aux.setSig(nuevo);
		}
		cont++;
	}
}
