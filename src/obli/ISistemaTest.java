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
		
		ret = sis.crearSistemaArchivos(5, 10);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.crearSistemaArchivos(1, 10);
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.crearSistemaArchivos(-1, 10);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.crearSistemaArchivos(0, 10);
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		
		
	}

	@Test
	public void testDestruirSistemaArchivos() {
		sis.crearSistemaArchivos(10, 10);
		
		Retorno ret = sis.destruirSistemaArchivos();
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
	}

	@Test
	public void testAgregarCarpeta() {
		sis.crearSistemaArchivos(10, 10);
		
		Retorno ret;
		ret = sis.agregarCarpeta(0, "Invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.agregarCarpeta(-1, "Invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.agregarCarpeta(11, "Invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.agregarCarpeta(20, "Invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);

		ret = sis.agregarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.agregarCarpeta(2, "Car2");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);


		ret = sis.agregarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
	}

	@Test
	public void testEliminarCarpeta() {
		
		sis.crearSistemaArchivos(10, 10);		
		
		sis.agregarCarpeta(1, "Car1");
		
		sis.agregarCarpeta(2, "Car2");		
			
		Retorno ret;
		
		ret = sis.eliminarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.eliminarCarpeta(2, "Car2");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.eliminarCarpeta(3, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.eliminarCarpeta(20, "invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.eliminarCarpeta(0, "invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);		
	}

	@Test
	public void testListarCarpeta() {
		
		sis.crearSistemaArchivos(10, 10);		
		
		sis.agregarCarpeta(1, "Car1");
		
		sis.agregarCarpeta(2, "Car2");		
			
		Retorno ret;
		
		ret = sis.listarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.listarCarpeta(2, "Car2");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.listarCarpeta(3, "Car3");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.listarCarpeta(20, "invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.listarCarpeta(0, "invalida");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);	
	}

	@Test
	public void testInsertarArchivo() {
		sis.crearSistemaArchivos(10, 10);		
		
		sis.agregarCarpeta(1, "Car1");
		
		sis.agregarCarpeta(2, "Car2");		
			
		Retorno ret;
		// falta implementar el insert
		ret = sis.insertarArchivo(1, "Car1", 1, "Arch1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);		
		
		ret = sis.insertarArchivo(2, "Car2", 1, "Arch1");
		assertEquals(Retorno.TipoRet.OK, ret.resultado);
		
		ret = sis.insertarArchivo(1, "Car1", 45, "Arch1");
		assertEquals(Retorno.TipoRet.ERROR_3, ret.resultado);
		
		ret = sis.insertarArchivo(3, "Car3", 1, "Arch1");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
		ret = sis.insertarArchivo(20, "invalida", 1, "fail");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);
		
		ret = sis.insertarArchivo(0, "invalida", 1, "fail");
		assertEquals(Retorno.TipoRet.ERROR_1, ret.resultado);	
	}

	@Test
	public void testBorrarArchivo() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarTodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarCarpetasConNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirFichero() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarArchivoExpansivo() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirArchivosOrdenados() {
		fail("Not yet implemented");
	}

}
