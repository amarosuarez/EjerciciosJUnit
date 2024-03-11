package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Tablas;

class TablasTest {

    @ParameterizedTest
    @MethodSource("esMagica")
    void testEsMagica(int[][] matriz, boolean expected) {
    	boolean result = Tablas.esMagica(matriz);
        assertEquals(expected, result);
    }
	
    private static Stream<Arguments> esMagica() {
        return Stream.of(
            Arguments.of(new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}, true), // Matriz mágica
            Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, false), // Matriz no mágica
            Arguments.of(new int[][]{{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}}, true), // Matriz mágica
            Arguments.of(new int[][]{{1, 1}, {1, 2}}, false) // Matriz no mágica
        );
    }
	

    @ParameterizedTest
    @MethodSource("gira90")
	void testGira90(int[][] matriz, int[][] expected) {
    	int[][] result = Tablas.gira90(matriz);
		assertArrayEquals(expected, result);
	}
	

    private static Stream<Arguments> gira90() {
    	return Stream.of(
    			Arguments.of(null, null),
    			Arguments.of(new int[][] {{1,2,3},{4,5}}, null),
    			// No se puede out of bounds Arguments.of(new int[][]{}, new int[][]{}),
    			Arguments.of(new int[][]{{1}, {2}}, null),
    			Arguments.of(
    				new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
    				new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}
    			)
    		);
    }
    
}