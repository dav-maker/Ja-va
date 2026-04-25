package buoi4.com;

import java.util.Scanner;

public class baitap4 {
	public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        // Khai báo biến đếm
        int countOdd = 0, countEven = 0;

        System.out.print("\nDòng 1 (Số lẻ): ");
        for (int x : arr) {
            if (x % 2 != 0) {
                System.out.print(x + " ");
                countOdd++;
            }
        }
        System.out.println("=> " + countOdd + " số lẻ");

        System.out.print("\nDòng 2 (Số chẵn): ");
        for (int x : arr) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
                countEven++;
            }
        }
        System.out.println("=> " + countEven + " số chẵn");

        System.out.print("\nDòng 3 (Số nguyên tố): ");
        for (int x : arr) {
            if (isPrime(x)) {
                System.out.print(x + " ");
            }
        }

        System.out.print("\n\nDòng 4 (Không phải số nguyên tố): ");
        for (int x : arr) {
            if (!isPrime(x)) {
                System.out.print(x + " ");
            }
        }
	}

}
