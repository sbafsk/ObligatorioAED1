package obli;

public class Retorno {
	public enum TipoRet {
		OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
	};

	public int valorEntero;
	public String valorString;
	public TipoRet resultado;

	public Retorno(TipoRet resultado) {
		this.resultado = resultado;
	}

	public Retorno(TipoRet resultado, int valorEntero, String valorString) {
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.resultado = resultado;
	}

}
