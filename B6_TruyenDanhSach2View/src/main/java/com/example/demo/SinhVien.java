package com.example.demo;

public class SinhVien {
    private String ten;
    private int namSinh;
    private double diem;

    public SinhVien(String ten, int namSinh, double diem) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}