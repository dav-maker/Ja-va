package buoi8.com;

import java.util.ArrayList;
import java.util.Scanner;

// Lớp Invoice theo yêu cầu của đề bài
class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    // Getters và Setters
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public String getPartDescription() { return partDescription; }
    public void setPartDescription(String partDescription) { this.partDescription = partDescription; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        // Nếu số lượng không dương, đặt thành 0
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(double pricePerItem) {
        // Nếu giá không dương, đặt thành 0.0
        this.pricePerItem = (pricePerItem > 0) ? pricePerItem : 0.0;
    }

    // Phương thức tính số tiền trên hóa đơn
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Mã: %-10s | Mô tả: %-20s | SL: %-5d | Đơn giá: %,.2f | Tổng: %,.2f", 
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}
public class bt {
	private static ArrayList<Invoice> danhSach = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		duLieuGia();

        int luaChon;
        do {
            System.out.println("\n---------- QUẢN LÝ CỬA HÀNG MÁY TÍNH ----------");
            System.out.println("1. Nhập danh sách Invoice (ít nhất 10 cái)");
            System.out.println("2. Xuất danh sách Invoice");
            System.out.println("3. Sắp xếp theo Mã mặt hàng (Bubble Sort)");
            System.out.println("4. Tìm kiếm Invoice theo Mã mặt hàng");
            System.out.println("5. Xóa Invoice theo Mã mặt hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Clear bộ nhớ đệm

            switch (luaChon) {
                case 1: nhapDanhSach(); break;
                case 2: xuatDanhSach(); break;
                case 3: sapXepNoiBot(); break;
                case 4: timKiemInvoice(); break;
                case 5: xoaInvoice(); break;
                case 0: System.out.println("Cảm ơn bạn đã sử dụng chương trình!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);
    }

    // Hàm nhập danh sách
    private static void nhapDanhSach() {
        System.out.print("Bạn muốn nhập thêm bao nhiêu hóa đơn? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin hóa đơn thứ " + (danhSach.size() + 1) + ":");
            String ma;
            while (true) {
                System.out.print(" - Mã mặt hàng: ");
                ma = scanner.nextLine();
                if (timInvoiceTheoMa(ma) == null) break;
                System.out.println("Lỗi: Mã đã tồn tại! Vui lòng nhập mã khác.");
            }
            System.out.print(" - Mô tả: ");
            String moTa = scanner.nextLine();
            System.out.print(" - Số lượng: ");
            int sl = scanner.nextInt();
            System.out.print(" - Đơn giá: ");
            double gia = scanner.nextDouble();
            scanner.nextLine();

            danhSach.add(new Invoice(ma, moTa, sl, gia));
        }
    }

    // Hàm xuất danh sách
    private static void xuatDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách đang trống!");
            return;
        }
        System.out.println("\nDANH SÁCH HÓA ĐƠN HIỆN TẠI:");
        for (Invoice inv : danhSach) {
            System.out.println(inv);
        }
    }

    // Hàm sắp xếp nổi bọt (Bubble Sort)
    private static void sapXepNoiBot() {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSach.get(j).getPartNumber().compareToIgnoreCase(danhSach.get(j + 1).getPartNumber()) > 0) {
                    // Hoán đổi
                    Invoice temp = danhSach.get(j);
                    danhSach.set(j, danhSach.get(j + 1));
                    danhSach.set(j + 1, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp xong danh sách theo Mã mặt hàng.");
    }

    // Hàm tìm kiếm
    private static void timKiemInvoice() {
        System.out.print("Nhập mã mặt hàng cần tìm: ");
        String ma = scanner.nextLine();
        Invoice found = timInvoiceTheoMa(ma);
        if (found != null) {
            System.out.println("Đã tìm thấy: " + found);
        } else {
            System.out.println("Không tìm thấy hóa đơn có mã: " + ma);
        }
    }

    // Hàm xóa
    private static void xoaInvoice() {
        System.out.print("Nhập mã mặt hàng cần xóa: ");
        String ma = scanner.nextLine();
Invoice found = timInvoiceTheoMa(ma);
        if (found != null) {
            danhSach.remove(found);
            System.out.println("Đã xóa hóa đơn mã " + ma + " thành công.");
        } else {
            System.out.println("Không tìm thấy mã cần xóa.");
        }
    }

    // Hàm phụ tìm kiếm theo mã
    private static Invoice timInvoiceTheoMa(String ma) {
        for (Invoice inv : danhSach) {
            if (inv.getPartNumber().equalsIgnoreCase(ma)) return inv;
        }
        return null;
    }

    // Tạo sẵn 10 dữ liệu giả để kiểm tra nhanh (theo yêu cầu đề bài là ít nhất 10)
    private static void duLieuGia() {
        danhSach.add(new Invoice("H01", "Ram 8GB", 10, 800000));
        danhSach.add(new Invoice("H05", "SSD 256GB", 5, 1200000));
        danhSach.add(new Invoice("H02", "CPU i5", 2, 4500000));
        danhSach.add(new Invoice("H09", "Mainboard B450", 3, 2100000));
        danhSach.add(new Invoice("H03", "VGA RTX 3060", 1, 9500000));
        danhSach.add(new Invoice("H07", "Nguồn 650W", 7, 1500000));
        danhSach.add(new Invoice("H10", "Vỏ Case RGB", 4, 900000));
        danhSach.add(new Invoice("H04", "Tản nhiệt khí", 12, 450000));
        danhSach.add(new Invoice("H06", "Chuột Gaming", 15, 350000));
        danhSach.add(new Invoice("H08", "Bàn phím cơ", 8, 1100000));
        System.out.println("(Hệ thống đã tự động thêm 10 hóa đơn mẫu để bạn kiểm tra)");

	}

}
