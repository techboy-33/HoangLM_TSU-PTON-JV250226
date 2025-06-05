package Lession_04;

import java.util.Arrays;
import java.util.Scanner;

public class Bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng : ");
        int arrayItem = scanner.nextInt();
        int[] arr = new int[arrayItem];
        if (arrayItem == 0) {
            System.out.print("Kích thước rỗng");
        } else {
            for (int i = 0; i < arrayItem; i++) {
                System.out.printf("Nhập phần tử thứ %d : ", i + 1);
                arr[i] = scanner.nextInt();
            }
            int [] newArray = myMethor(arr);
            System.out.println(Arrays.toString(newArray));
        }
    }

    public static int [] myMethor(int [] array){
        int arrLength = array.length;
        if (arrLength % 2 == 0){
            for (int i = 0; i < arrLength / 2; i++) {
                int temp = array[i];
                array[i] = array[arrLength - i - 1];
                array[arrLength - i - 1] = temp;
            }
        } else {
            for (int i = 0; i < (arrLength - 1 )/ 2; i++) {
                int temp = array[i];
                array[i] = array[arrLength - i - 1];
                array[arrLength - i - 1] = temp;
            }
        }
        return array;
    }
}
