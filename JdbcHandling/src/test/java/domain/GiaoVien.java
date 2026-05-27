package domain;

public class GiaoVien {
    private String maGV;
    private String hoTen;
    private String hocVi;
    private String hocHam;
    private String gioiTinh;
    private double heSo;
    private double mucLuong;
    private String maKhoa;

    // Constructors, Getters và Setters
    public GiaoVien() {}

    public String getMaGV() { return maGV; }
    public void setMaGV(String maGV) { this.maGV = maGV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    // ... Tương tự cho các trường còn lại ...
    
    @Override
    public String toString() {
        return "GiaoVien{" + "maGV=" + maGV + ", hoTen=" + hoTen + ", khoa=" + maKhoa + '}';
    }
}