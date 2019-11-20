package listas;

public class Main {

	public static void main(String[] args) {
//		ILista<Integer> l = new ListaSEOrd<Integer>();
//		l.insertarOrd(3);
//		l.insertarOrd(4);
//		l.insertarOrd(7);
//		l.insertarOrd(1);
//		l.insertarOrd(3);
//		l.insertarOrd(4);
//		l.insertarOrd(6);
//		l.insertarOrd(5);
//		
//
//		for (int elem : l) {
//			System.out.println(elem);
//		}
		
		ILista<Persona> lisP = new ListaSEOrd<Persona>();

		Persona p1 = new Persona("Rigoberta Menchu",321654);
		Persona p2 = new Persona("Apolodoro Rivadavia",515462);
		Persona p3 = new Persona("Esteban Quito",123456);
		Persona p4 = new Persona("Zimba y Timón",8);
		
		lisP.insertarOrd(p1);
		lisP.insertarOrd(p2);
		lisP.insertarOrd(p3);
		lisP.insertarOrd(p4);
		
		for (Persona pe : lisP) {
			System.out.println(pe);
		}
		
		System.out.println("Existe cédula 8?");
		
		Persona pExistente = lisP.recuperar(new Persona(null,9));
		System.out.println(pExistente);
	}
}
