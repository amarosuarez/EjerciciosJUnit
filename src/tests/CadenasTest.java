package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Cadenas;

class CadenasTest {

	@ParameterizedTest
	@MethodSource("cuentaEspacios")
	void testCuentaEspacios(String cadena, int num) {
		Cadenas frase = new Cadenas(cadena);
		
		int espacios = frase.cuentaEspacios();
		
		assertEquals(num, espacios);
	}

	private static Stream<Arguments> cuentaEspacios() {
		return Stream.of(
				Arguments.of("", 0), 
				Arguments.of("Hola juan magan es calvo", 4)
			);
	}

	@ParameterizedTest
	@MethodSource("delReves")
	void testDelReves(String cadena, String reves) {
		Cadenas frase = new Cadenas(cadena);
		
		String result = frase.delReves();
		
		assertEquals(reves, result);
	}
	
	private static Stream<Arguments> delReves() {
		return Stream.of(
				Arguments.of("Hola", "aloH"),
				Arguments.of("", ""),
				Arguments.of(" Me llamo amaro", "orama omall eM ")
			);
	}
	
	@ParameterizedTest
	@MethodSource("contarPalabra")
	void testContarPalabra(String cadena, String busqueda, int num) {
		Cadenas frase = new Cadenas(cadena);
		
		assertEquals(num, frase.contarPalabra(busqueda));
	}
	
	private static Stream<Arguments> contarPalabra() {
		return Stream.of(
				Arguments.of("holaestoesunafrase", "esto", 0),
				Arguments.of("Me llamo juan", "juan", 1),
				Arguments.of("", "pepe", 0),
				Arguments.of(" ", " ", 0),
				Arguments.of("Me gusta gusta gusta Jenri ", "gusta", 3)
			);
	}

}
