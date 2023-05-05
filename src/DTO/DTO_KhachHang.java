/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hieu
 */
public class DTO_KhachHang {
    private String maKH;
    private String tenKH;
    private String SDT;
    private String Diachi;
    private String Email;
    private int Trangthai;
    public String getMaKhachHang() {
        return maKH;
    }

    public void setMaKhachHang(String maNCC) {
        this.maKH = maNCC;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenNCC) {
        this.tenKH = tenNCC;
    }
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }
     public String getEmail() {
        return Email;
    }

    public void setEmail(String Diachi) {
        this.Email = Diachi;
    }
    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangThai(int TrangThai) {
        this.Trangthai = TrangThai;
    }
}
