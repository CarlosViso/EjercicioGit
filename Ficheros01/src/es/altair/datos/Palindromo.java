package es.altair.datos;

public class Palindromo {

	public static void main(String[] args) {
		int numero = 66666;
		String numeroString = String.valueOf(numero);
		StringBuffer sb = new StringBuffer(numeroString);
		if (numeroString.length()==5) {
			if(String.valueOf(sb.reverse()).equals(numeroString)) {
				System.out.println("Es Capicuo");
			}else {
				System.out.println("No es capicuo");
			}
		} else {
		 try {
			throw new NumberLengthException("Longitud no correcta", numero);
		} catch (NumberLengthException e) {
			System.out.println(e.mensajeExcepcion());
		}

		}
	}
}
	
