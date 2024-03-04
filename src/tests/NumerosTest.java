package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Numeros;


class NumerosTest {

	@ParameterizedTest
	@MethodSource("esCapicua")
	void testEsCapicua(int numero, boolean expected) {
		Numeros num = new Numeros(numero);
		
		boolean resultado = num.esCapicua();
		
		assertEquals(expected, resultado);
	}
	
	private static Stream<Arguments> esCapicua() {
		return Stream.of(
					Arguments.of(22, true),
					Arguments.of(10, false),
					Arguments.of(-22, false),
					Arguments.of(333, true)
				);
	}

}
