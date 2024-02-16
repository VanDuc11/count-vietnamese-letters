/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package count.vietnamese.letters;

import java.util.Scanner;

/**
 *
 * @author duong
 */
public class CountVietnameseLetters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái Latin: ");
        String input = scanner.nextLine();

        int vietnamesePairCount = countVietnamesePairs(input);
        System.out.println("Số lượng cặp ký tự Tiếng Việt trong chuỗi là: " + vietnamesePairCount);
    }

    public static boolean isValidVietnamesePair(char ch1, char ch2) {
        // Kiểm tra xem một cặp ký tự liên tiếp có thể tạo thành một ký tự Tiếng Việt không
        // Sử dụng các quy tắc kiểm tra dựa trên kiểu gõ Telex
        // ă=aw, â=aa, đ=dd, ê=ee, ô=oo, ơ=ow, ư=w
        return (ch1 == 'a' || ch1 == 'w' || ch1 == 'd' || ch1 == 'e' || ch1 == 'o')
                && (ch2 == 'a' || ch2 == 'w' || ch2 == 'd' || ch2 == 'e' || ch2 == 'o');
    }

    public static int countVietnamesePairs(String input) {
        int count = 0;
        // Lặp qua từng cặp ký tự liên tiếp trong chuỗi có thuộc ký tự tiếng việt kh
        for (int i = 0; i < input.length() - 1; i++) {
            char ch1 = input.charAt(i);
            char ch2 = input.charAt(i + 1);
            if (isValidVietnamesePair(ch1, ch2)) {
                count++;
            }
        }
        return count;
    }

}
