package listas;

public interface ILista<T> extends Iterable<T>{
	
	/**
	 * Inserta al principio de una lista no ordenada <br>
	 * Pre: !esLlena()
	 * @param dato
	 */
	public void insertarPpio(T dato);

	/**
	 * Inserta al final de una lista no ordenada <br>
	 * Pre: !esLlena()
	 * @param dato
	 */
	public void insertarFin(T dato);

	/**
	 * Inserta en una posición específica de una lista no ordenada <br>
	 * Pre: !esLlena()
	 * @param dato
	 * @param k int
	 */
	public void insertarEnPos(T dato, int k);

	/**
	 * Inserta ordenadamente en una lista previamente ordenada <br>
	 * Pre: !esLlena()
	 * @param dato
	 */
	public void insertarOrd(T dato);

	/**
	 * Borra un elemento al principio de una lista no vacía <br>
	 * Pre: !esVacia()
	 */
	public void borrarPpio();

	/**
	 * Borra un elemento al final de una lista no vacía <br>
	 * Pre: !esVacia()
	 */
	public T borrarFin();

	/**
	 * Borra un elemento de una lista no vacía de una posición dada<br>
	 * Pre: !esVacia()
	 * @param k int
	 */
	public void borrarEnPos(int k);

	/**
	 * Borra un elemento específico de una lista no vacía <br>
	 * Pre: !esVacia()
	 * @param dato
	 */
	public void borrar(T dato);

	/**
	 * Retorna el largo de la lista <br>
	 * Pre: ninguna
	 */
	public int largo();

	/**
	 * Retorna true si la lista es vacía; false en caso contrario <br>
	 * Pre: ninguna
	 */
	public boolean esVacia();

	/**
	 * Retorna true si la lista está llena; false en caso contrario <br>
	 * Pre: ninguna
	 */
	public boolean esLlena();

	/**
	 * Retorna true si el elemento existe en la lista; false en caso contrario <br>
	 * Pre: ninguna
	 * @param dato
	 */
	public boolean existe(T dato);

	/**
	 * Retorna el primer elemento igual al parámetro; null en caso contrario <br>
	 * Pre: ninguna
	 * @param dato
	 */
	public T recuperar(T dato);
}
