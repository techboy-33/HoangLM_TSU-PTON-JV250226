package Lession_04;

import java.util.Arrays;
import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng : ");
        int arrayItem = scanner.nextInt();
        int [] arr = new int [arrayItem];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập phần tử thứ %d : ", i + 1);
            arr[i] = scanner.nextInt();
        }
        int [] newArr = bubbleSort(arr);
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần : " + Arrays.toString(newArr));
    }

    public static int [] bubbleSort (int [] array) {
        int n = array.length;
        boolean swapper;
        for (int i = 0; i < n - 1; i++) {
            swapper = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapper = true;
                }
            }
            if (!swapper) break;
        }
        return array;
    }
}
