package ru.geekbrains;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class MetodsArray {

    private MetodsArray(){
    }
    /* 1) Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
      необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
       Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

       2) Написать метод, который проверяет состав массива из чисел 1 и 4.
     Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     Написать набор тестов для этого метода (по 3-4 варианта входных данных)./
     */
//    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
//        int[] array1And4 = new int[]{6, 3, 2, 1};
//        Main obj = new Main();
//        int arrayNew[] = obj.returnArray(array);
//        System.out.println(Arrays.toString(arrayNew));
//        search1And4(array1And4);
//        boolean trueOrFalseArray = obj.search1And4(array1And4);
////        System.out.println(Arrays.toString(new boolean[]{trueOrFalseArray}));
//     }
    public static String returnArray(int[] array){
        int counter = 0;
        int position = 0;
        if(array.length == 0){
            throw new RuntimeException("Empty Array");
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 4){
                counter++;
                position = i;
            }
        }
        if(counter == 0){
            throw new RuntimeException("There is no digit 4 in the array");
        }
        String arr = Arrays.toString(copyOfRange(array, position + 1, array.length));
        return arr;
    }


    public static boolean search1And4(int[] array1And4){
        for (int i = 0; i < array1And4.length; i++) {
            if(array1And4[i] == 1) {
                for (int j = 0; j < array1And4.length; j++) {
                    if (array1And4[j] == 4) {
                        System.out.println("true");
                        return true;
                    }
                }
            }
        }
        System.out.println("false");
        return false;
    }
}

