package Buoi3.com;

public class palindrome {

	public static boolean palindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Nhập một từ: ");
        String word = sc.nextLine();

        if (palindrome(word)) {
            System.out.println("Đây là chuỗi palindrome");
        } else {
            System.out.println("Đây không phải chuỗi palindrome");
        }

        sc.close();
    
	}

}
