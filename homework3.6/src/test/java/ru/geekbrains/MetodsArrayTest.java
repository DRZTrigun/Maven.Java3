package ru.geekbrains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MetodsArrayTest {
    @Test
    public void shouldReturnArrayValuesAfterLast4 (){
        int[] array = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertEquals(Arrays.toString(new int[]{1,7}), MetodsArray.returnArray(array));
    }

    @Test
    public void shouldEmptyArray() {
        Exception ex = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                MetodsArray.returnArray(new int[]{});
            }
        });
        Assertions.assertEquals("Empty Array", ex.getMessage());
    }

    @Test
    public void shouldReturnTrueOrFalseSearch1And4(){
        int[] array = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertEquals(true, MetodsArray.search1And4(array));
    }

    @ParameterizedTest
    @MethodSource("parametrsReturnArray")
    public void shouldReturnArrayValuesAfterLast4Parametrs(int [] expected, int[] array){
        Assertions.assertEquals(Arrays.toString(expected), MetodsArray.returnArray(array));
    }
    private static Stream<Arguments> parametrsReturnArray() {
        return Stream.of(
                Arguments.arguments((new int[]{1, 8}), new int[]{1, 4, 6, 7, 8, 4, 1, 8} ),
                Arguments.arguments(new int[]{ 6, 7, 8, 5, 1, 8}, new int[]{1, 4, 6, 7, 8, 5, 1, 8}),
                Arguments.arguments(new int[]{}, new int[]{1, 4, 6, 7, 8, 4, 1, 4})
        );
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArrayZero() {
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                MetodsArray.returnArray(new int[]{1, 2, 0, 3, 2, 3, 8, 1, 7});
            }
        });
        Assertions.assertEquals("There is no digit 4 in the array", ex.getMessage());
    }

    @ParameterizedTest
    @MethodSource("parametrsReturnTrueOrFalseSearch1And4")
    public void shouldReturnTrueOrFalseSearch1And4(boolean t, int[] array){
        Assertions.assertEquals(t, MetodsArray.search1And4(array));
    }
    private static Stream<Arguments> parametrsReturnTrueOrFalseSearch1And4() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 4, 6, 7, 8, 4, 1, 8} ),
                Arguments.arguments(true, new int[]{1, 4, 6, 7, 8, 3, 0, 7}),
                Arguments.arguments(false, new int[]{1, 1, 6, 7, 8, 3, 1, 9})
        );
    }

}
