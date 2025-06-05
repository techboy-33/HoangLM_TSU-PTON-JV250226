package Session_11.bai_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda_expressions {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Các số chẵn trong danh sách: ");
//        cú pháp thông thường
//        for (Integer number : numbers) {
//            if (number % 2 == 0) {
//                System.out.println(number);
//            }
//        }

//        cú pháp lambda
        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });

//      Sử dụng Stream (dòng chảy) và phương thức tham chiếu
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
