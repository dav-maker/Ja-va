package Buoi5.com;
import java.util.Scanner;
	
class NhanVien {
    private String ho;
    private String ten;
    private int soSP;

    // Hàm khởi tạo (Constructor)
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        // Kiểm tra: nếu số sản phẩm âm thì gán bằng 0
        this.soSP = (soSP >= 0) ? soSP : 0;
    }

    // Các hàm lấy giá trị (getters)
    public String getHo() { return ho; }
    public String getTen() { return ten; }
    public int getSoSP() { return soSP; }

    // Các hàm gán giá trị (setters)
    public void setHo(String ho) { this.ho = ho; }
    public void setTen(String ten) { this.ten = ten; }
    public void setSoSP(int soSP) {
        this.soSP = (soSP >= 0) ? soSP : 0;
    }

    // Hàm tính lương dựa trên đơn giá bậc thang (hình ảnh image_a1a0cf.jpg)
    public double getLuong() {
        double donGia;
        if (soSP >= 1 && soSP <= 199) {
            donGia = 0.5;
        } else if (soSP >= 200 && soSP <= 399) {
            donGia = 0.55;
        } else if (soSP >= 400 && soSP <= 599) {
            donGia = 0.6;
        } else if (soSP >= 600) {
            donGia = 0.65;
        } else {
            donGia = 0; // Trường hợp 0 sản phẩm
        }
        return soSP * donGia;
    }

    // Hàm so sánh LonHon: trả về true nếu số sản phẩm lớp này lớn hơn nv2
    public boolean LonHon(NhanVien nv2) {
        return this.soSP > nv2.soSP;
    }
}
public class oop {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Nhập thông tin nhân viên 1
        System.out.println("Nhập thông tin nhân viên 1:");
        System.out.print("Họ: "); String ho1 = sc.nextLine();
        System.out.print("Tên: "); String ten1 = sc.nextLine();
        System.out.print("Số SP: "); int sp1 = sc.nextInt();
        NhanVien nv1 = new NhanVien(ho1, ten1, sp1);

        sc.nextLine(); // Xóa bộ nhớ đệm

        // Nhập thông tin nhân viên 2
        System.out.println("\nNhập thông tin nhân viên 2:");
        System.out.print("Họ: "); String ho2 = sc.nextLine();
        System.out.print("Tên: "); String ten2 = sc.nextLine();
        System.out.print("Số SP: "); int sp2 = sc.nextInt();
        NhanVien nv2 = new NhanVien(ho2, ten2, sp2);

        // Xuất lương
        System.out.println("\n--- Kết quả ---");
        System.out.println("Lương NV1 (" + nv1.getTen() + "): " + nv1.getLuong());
        System.out.println("Lương NV2 (" + nv2.getTen() + "): " + nv2.getLuong());

        // So sánh cách 1: Dùng hàm LonHon
        System.out.println("\n[Cách 1: Dùng hàm LonHon]");
        if (nv1.LonHon(nv2)) {
            System.out.println(nv1.getTen() + " làm nhiều hơn " + nv2.getTen() + " " + (nv1.getSoSP() - nv2.getSoSP()) + " sản phẩm.");
        } else if (nv2.LonHon(nv1)) {
            System.out.println(nv2.getTen() + " làm nhiều hơn " + nv1.getTen() + " " + (nv2.getSoSP() - nv1.getSoSP()) + " sản phẩm.");
        } else {
            System.out.println("Hai nhân viên có số sản phẩm bằng nhau.");
        }

        // So sánh cách 2: Không dùng hàm LonHon (so sánh trực tiếp qua getter)
        System.out.println("\n[Cách 2: Không dùng hàm LonHon]");
        int hieuSo = nv1.getSoSP() - nv2.getSoSP();
        if (hieuSo > 0) {
            System.out.println(nv1.getTen() + " nhiều hơn " + hieuSo + " sản phẩm.");
        } else if (hieuSo < 0) {
            System.out.println(nv2.getTen() + " nhiều hơn " + Math.abs(hieuSo) + " sản phẩm.");
        } else {
            System.out.println("Số sản phẩm bằng nhau.");
        }
	}

}
