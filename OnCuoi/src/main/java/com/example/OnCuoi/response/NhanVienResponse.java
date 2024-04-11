package com.example.OnCuoi.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Builder
@ToString

public class NhanVienResponse {
    private int id;
    private String ma;
    private String ten;
    private String ngaySinh;
    private String diaChi;
    private String matKhau;
    private int trangThai;
    private int idCV;
    private String maCV;
    private String tenCV;

    public NhanVienResponse(int id, String ma, String ten, String ngaySinh, String diaChi, String matKhau, int trangThai, int idCV, String maCV, String tenCV) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCV = tenCV;
    }
}
