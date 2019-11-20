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

		ret = sis.agregarCarpeta(1, "Car1");
		assertEquals(Retorno.TipoRet.ERROR_2, ret.resultado);
		
	}

	@Test
	public void testEliminarCarpeta() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarCarpeta() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarArchivo() {
		fail("Not yet implemented");
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
