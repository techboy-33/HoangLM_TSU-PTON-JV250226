package Lession_04;

import java.util.Arrays;
import java.util.Scanner;

public class Bai_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng : ");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.printf("Nhập phần tử thứ %d : ", i + 1);
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < arrayLength - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
        System.out.print("Nhập số cần tìm : ");
        int searchItem = scanner.nextInt();
        int linearIndex = 0;
        boolean linearFlat = true;
        for (int i = 0; (i < arrayLength); i++) {
            if (searchItem == array[i]) {
                linearIndex = i;
                linearFlat = false;
                break;
            }
        }
        int binaryIndex = 0;
        boolean binaryFlat = true;
        int left = 0, right = (array.length - 1);
        while (left <= right) {
            System.out.println("lặp");
            int mid = left + (right - left)/2;
            if (array[mid] == searchItem){
                binaryIndex = mid;
            }

            if (array[mid] > searchItem) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            binaryFlat = false;
        }

        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(array));
        System.out.println(linearIndex);
        System.out.println(binaryIndex);
        if (!linearFlat && !binaryFlat) {
            System.out.printf("Tìm kiếm tuyến tính: Phần tử %d tìm thấy tại chỉ số : %d \n", searchItem, linearIndex);
            System.out.printf("Tìm kiếm nhị phân: Phần tử %d tìm thấy tại chỉ số : %d \n", searchItem, binaryIndex);
        } else {
            System.out.printf("Không có phần tử %d trong mảng", searchItem);
        }
    }
}
