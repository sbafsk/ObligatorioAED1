package listas;

public class NodoLista<T> {

	private T dato;
	private NodoLista<T> sig;

	// Alt + shift + s + o 
	
	public NodoLista(T dato, NodoLista<T> sig) {
		this.dato = dato;
		this.sig = sig;
	}

	public NodoLista(T dato) {
		this.dato = dato;
		// this.sig = null;
	}

	// Alt + shift + s + r -> selecciono todos -> ok
	
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoLista<T> getSig() {
		return sig;
	}

	public void setSig(NodoLista<T> sig) {
		this.sig = sig;
	}

	
	// Alt + shift + s -> s
	@Override
	public String toString() {
		return dato + "";
	}

}
