package listas;

import java.util.Iterator;

public class ListaSE<T> implements ILista<T>{

	protected NodoLista<T> inicio;
	protected int cont;
	protected int tope;

	public ListaSE() {
		// Innecesarios, ya que por defecto están en esos valores
//		this.inicio = null;
//		this.cont = 0;
		this.tope = -1;
	}
	
	public ListaSE(int tope){
		// Innecesarios, ya que por defecto están en esos valores
//		this.inicio = null;
//		this.cont = 0;
		this.tope = tope;
	}

	// Pre: !esLlena()	
	@Override
	public void insertarPpio(T dato) {
		NodoLista<T> nuevo = new NodoLista<T>(dato, inicio);
		inicio = nuevo;
		cont++;

		// inicio = new NodoLista<T>(dato,inicio);
	}

	// Pre: !esVacia()
	@Override
	public void borrarPpio() {
		inicio = inicio.getSig();
		cont--;
	}

	@Override
	public int largo() {
		return cont;
	}

	public int largoRecorriendo() {
		int cont = 0;
		NodoLista<T> aux = inicio;
		while (aux != null) {
			cont++;
			aux = aux.getSig();
		}
		return cont;
	}

	// Pre: !esLlena()
	@Override
	public void insertarFin(T dato) {
		if (inicio == null)
			insertarPpio(dato);
		else {
			NodoLista<T> aux = inicio;
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			NodoLista<T> nuevo = new NodoLista<T>(dato);
			aux.setSig(nuevo);
			cont++;
		}
	}

	
//	Mostrar no lo usamos, ya que usaremos el Iterable
	public void mostrar() {
		NodoLista<T> aux = inicio;
		while (aux != null) {
			System.out.println(aux);
			aux = aux.getSig();
		}
	}
	
	// Pre: !esVacia()
	@Override
	public T borrarFin() {
		T ret;
		if(inicio.getSig() == null){
			ret = inicio.getDato();
			borrarPpio();
		}else{
			NodoLista<T> aux = inicio;
			while(aux.getSig().getSig() != null){
				aux = aux.getSig();
			}
			ret = aux.getSig().getDato();
			aux.setSig(null);
			cont--;
		}
		return ret;
	}
	
	// Pre: 1<=k<=largo+1 && !esLlena()
	@Override
	public void insertarEnPos(T dato, int k){
		if(k==1)
			insertarPpio(dato);
		// Innecesario, ya que queda contemplado en el else
//		else if(k==cont+1)
//			insertarFin(dato);
		else{
			NodoLista<T> aux = inicio;
			while(k>2)
			{
				aux = aux.getSig();
				k--;
			}
			NodoLista<T> nuevo = new NodoLista<T>(dato, aux.getSig());
			aux.setSig(nuevo);
			cont++;
		}
	}

	@Override
	public boolean esVacia(){
		return inicio == null;
		// Otra opción: return cont == 0;
	}

	@Override
	public boolean esLlena(){
		return cont == tope;
	}

	@Override
	public void insertarOrd(T dato) {
		throw new UnsupportedOperationException("No se puede insertar de forma ordenada en una lista no ordenada (ListaSE). Cree a la lista como una ListaSEOrd.");
	}

	@Override
	public void borrarEnPos(int k) {
		// Hacer :-)
		throw new UnsupportedOperationException();
	}

	// Pre: existe(dato)
	@Override
	public void borrar(T dato) {
		if(this.inicio.getDato().equals(dato))
			borrarPpio();
		else{
			NodoLista<T> aux = inicio;
			while(!aux.getSig().getDato().equals(dato))
				aux = aux.getSig();
			aux.setSig(aux.getSig().getSig());
			cont--;
		}
	}

	@Override
	public boolean existe(T dato) {
		return recuperar(dato) != null;
	}

	@Override
	public T recuperar(T dato) {
		NodoLista<T> aux = inicio;
		while(aux!=null){
			if(aux.getDato().equals(dato))
				return aux.getDato();
			else
				aux = aux.getSig();
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private NodoLista<T> aux = inicio;
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public T next() {
				T ret = aux.getDato();
				aux = aux.getSig();
				return ret;
			}
		};
	}

}
