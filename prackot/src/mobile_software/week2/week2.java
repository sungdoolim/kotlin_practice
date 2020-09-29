package mobile_software.week2;

import java.io.IOException;

public class week2 {

    public static void main(String[] args) {
        double[] myList = {1.8, 2.5, 3.2, 3.9};
        // 모든 배열요소 출력
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }

        // 모든 요소를 더함
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("합계: " + total);

        // 가장 큰 요소 찾기
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("최댓값: " + max);
    }
}