package obli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ISistemaTest {

	private ISistema sis;
	
	@Before
	public void setUp() throws Exception {
		sis = new Sistema();
	}

	@Test
	public void testCrearSistemaArchivos() {
		Retorno ret;
		
		ret = sis.crearSistemaArchivos(10, 10);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);	
		
		ret = sis.crearSistemaArchivos(1, 10);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);	
		
		ret = sis.crearSistemaArchivos(-1, 10);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
	
		ret = sis.crearSistemaArchivos(-1891, 10);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
	}

	@Test
	public void testDestruirSistemaArchivos() {
		
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		ret = sis.destruirSistemaArchivos();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);	
		
	}

	@Test
	public void testAgregarCarpeta() {
		
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		ret = sis.agregarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);	
		
		ret = sis.agregarCarpeta(1, "Car2");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.agregarCarpeta(0, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);		
		
		ret = sis.agregarCarpeta(-1, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);		
		
		ret = sis.agregarCarpeta(11, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);		
		
		ret = sis.agregarCarpeta(20, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);	
		
		ret = sis.agregarCarpeta(1891, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);	
		
		ret = sis.agregarCarpeta(1, "Car3");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);	
		
		ret = sis.agregarCarpeta(1, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);	
		
		ret = sis.agregarCarpeta(1, "Car2");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);		
		
	}

	@Test
	public void testEliminarCarpeta() {
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");

		ret = sis.eliminarCarpeta(0, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.eliminarCarpeta(-1, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.eliminarCarpeta(11, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.eliminarCarpeta(20, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.eliminarCarpeta(1, "Car4");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.eliminarCarpeta(1, "Car3");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.eliminarCarpeta(1, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		
		
	}

	@Test
	public void testListarCarpeta() {

		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");

		ret = sis.listarCarpeta(0, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.listarCarpeta(-1, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.listarCarpeta(11, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.listarCarpeta(20, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.listarCarpeta(1, "Car4");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.listarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.toUpperCase().contains("No existen archivos".toUpperCase()));

		sis.insertarArchivo(1, "Car1", 1, "Arch1");
		sis.insertarArchivo(1, "Car1", 1, "Arch2");
		sis.insertarArchivo(1, "Car1", 3, "Arch3");

		ret = sis.listarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("Arch2|Arch1|Arch3"));
		
	}

	@Test
	public void testInsertarArchivo() {
		
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Carpeta1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");
		
		
		ret = sis.insertarArchivo(0, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivo(-1, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivo(11, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivo(20, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Car4",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",2,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",5,"Arch4");
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",1,"Arch1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",2,"Arch2");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",1,"Arch3");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Carpeta1",4,"Arch4");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		
	
	}

	@Test
	public void testBorrarArchivo() {

		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");
		
		sis.insertarArchivo(1, "Car1",1,"Arch3");
		sis.insertarArchivo(1, "Car1",1,"Arch2");
		sis.insertarArchivo(1, "Car1",1,"Arch1");

		ret = sis.borrarArchivo(0, "Car3", 1);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarArchivo(-1, "Car3", 1);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarArchivo(11, "Car3", 1);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarArchivo(20, "Car3", 1);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarArchivo(1, "Car4", 1);
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);

		ret = sis.borrarArchivo(1, "Car1", 4);
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);

		ret = sis.borrarArchivo(1, "Car1", 1);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);

		ret = sis.borrarArchivo(1, "Car1", 2);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);

		ret = sis.borrarArchivo(1, "Car1", 2);
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);

		ret = sis.borrarArchivo(1, "Car1", 1);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.borrarArchivo(1, "Car1", 1);
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);
		
	}

	@Test
	public void testBorrarTodo() {

		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");
		
		sis.insertarArchivo(1, "Car1",1,"Arch3");
		sis.insertarArchivo(1, "Car1",1,"Arch2");
		sis.insertarArchivo(1, "Car1",1,"Arch1");
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1(Arch1, Arch2, Arch3) Car2() Car3()"));
		
		ret = sis.borrarTodo(0);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarTodo(-1);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarTodo(11);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.borrarTodo(20);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.borrarTodo(1);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1() Car2() Car3()"));
		
	}

	@Test
	public void testBorrarCarpetasConNombre() {
		
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1,"Car1");
		sis.agregarCarpeta(1,"Car2");
		sis.agregarCarpeta(1,"Car3");
		sis.agregarCarpeta(2,"Car2");
		sis.agregarCarpeta(2,"Car3");
		sis.agregarCarpeta(2,"Car4");
		sis.agregarCarpeta(3,"Car3");
		sis.agregarCarpeta(3,"Car4");
		sis.agregarCarpeta(3,"Car5");
		
		ret = sis.borrarCarpetasConNombre("Car3");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1() Car2()"));
		assertTrue(ret.valorString.contains("2: Car2() Car4()"));
		assertTrue(ret.valorString.contains("3: Car4() Car5()"));
	}

	@Test
	public void testImprimirFichero() {
		
		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1,"Car1");
		sis.agregarCarpeta(1,"Car2");
		sis.agregarCarpeta(1,"Car3");
		sis.agregarCarpeta(2,"Car2");
		sis.agregarCarpeta(2,"Car3");
		sis.agregarCarpeta(2,"Car4");
		sis.agregarCarpeta(3,"Car3");
		sis.agregarCarpeta(3,"Car4");
		sis.agregarCarpeta(3,"Car5");
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1() Car2() Car3()"));
		assertTrue(ret.valorString.contains("2: Car2() Car3() Car4()"));
		assertTrue(ret.valorString.contains("3: Car3() Car4() Car5()"));
		
	}

	@Test
	public void testInsertarArchivoExpansivo() {
		Retorno ret;		
		sis.crearSistemaArchivos(3, 3);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		
		sis.insertarArchivoExpansivo(1, "Car1",1,"Arch1");
		sis.insertarArchivoExpansivo(1, "Car1",1,"Arch2");
		sis.insertarArchivoExpansivo(1, "Car1",1,"Arch3");
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1(Arch3, Arch2, Arch1) Car2()"));

		ret = sis.insertarArchivoExpansivo(0, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivoExpansivo(-1, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivoExpansivo(11, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivoExpansivo(20, "Car3",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivoExpansivo(1, "Car4",1,"Arch1");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.insertarArchivoExpansivo(1, "Car1",1,"Arch4");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1(Arch4, Arch3, Arch2) Car1+(Arch1) Car2()"));
		
		ret = sis.insertarArchivoExpansivo(1, "Car1",1,"Arch5");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1(Arch5, Arch4, Arch3) Car1+(Arch2, Arch1) Car2()"));
		
		ret = sis.insertarArchivoExpansivo(1, "Car1",4,"Arch6");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.imprimirFichero();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("1: Car1(Arch5, Arch4, Arch3) Car1+(Arch6, Arch2, Arch1) Car2()"));
	}

	@Test
	public void testImprimirArchivosOrdenados() {

		Retorno ret;		
		sis.crearSistemaArchivos(10, 10);
		
		sis.agregarCarpeta(1, "Car1");
		sis.agregarCarpeta(1, "Car2");
		sis.agregarCarpeta(1, "Car3");
		
		sis.insertarArchivo(1, "Car1",1,"Arch5");
		sis.insertarArchivo(1, "Car2",1,"Arch3");
		sis.insertarArchivo(1, "Car3",1,"Arch1");
		sis.insertarArchivo(1, "Car2",1,"Arch2");
		sis.insertarArchivo(1, "Car3",1,"Arch4");
		sis.insertarArchivo(1, "Car1",1,"Arch1");
		sis.insertarArchivo(1, "Car1",1,"Arch3");
		
		ret = sis.imprimirArchivosOrdenados();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		assertTrue(ret.valorString.contains("Arch5|Arch4|Arch3|Arch3|Arch2|Arch1|Arch1"));
		
	}

}