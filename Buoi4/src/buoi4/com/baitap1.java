package buoi4.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baitap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        ArrayList<String> ds = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Sửa sinh viên");
            System.out.println("4. Xóa sinh viên theo tên");
            System.out.println("5. Tìm sinh viên chứa 'An'");
            System.out.println("6. Sắp xếp danh sách");
            System.out.println("7. Số lượng sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine(); // bỏ enter

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = sc.nextLine();
                    ds.add(name);
                    break;

                case 2:
                    System.out.println("Danh sách sinh viên:");
                    for (int i = 0; i < ds.size(); i++) {
                        System.out.println((i + 1) + ". " + ds.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Nhập vị trí cần sửa: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 1 && index <= ds.size()) {
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        ds.set(index - 1, newName);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập tên cần xóa: ");
                    String delName = sc.nextLine();
                    ds.removeIf(sv -> sv.contains(delName));
                    break;

                case 5:
                    System.out.println("Sinh viên chứa 'An':");
                    for (String sv : ds) {
                        if (sv.contains("An")) {
                            System.out.println(sv);
                        }
                    }
                    break;

                case 6:
                    Collections.sort(ds);
                    System.out.println("Đã sắp xếp!");
                    break;

                case 7:
                    System.out.println("Số lượng sinh viên: " + ds.size());
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Chọn sai!");
            }

        } while (choice != 0);
	}

}
