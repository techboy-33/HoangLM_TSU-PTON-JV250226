package Lession_04;

import java.util.Arrays;
import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng : ");
        int arrayItem = scanner.nextInt();
        System.out.println("Nhập các phần tử cho mảng : ");
        int[] array = new int[arrayItem];
        for (int i = 0; i < arrayItem; i++) {
            System.out.printf("Hãy nhập phần tử thứ %d : ", i + 1);
            array[i] = scanner.nextInt();
        }
        selectionSort(array);
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần : " + Arrays.toString(array));
        System.out.println("Phần tử lớn nhất trong mảng là : " + array[0]);
    }

    public static String selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return Arrays.toString(arr);
    }
}
