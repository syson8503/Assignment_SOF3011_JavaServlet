package com.poly.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "matKhau")
	private String matKhau;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;
	
	@Column(name = "gioiTinh")
	private Boolean gioiTinh;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "diaChi")
	private String diaChi;
	
	@Column(name = "trangThai")
	private Boolean trangThai;
	
	@Column(name = "chucVu")
	private Boolean chucVu;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> hoaDonList;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang;

	public Account() {
		super();
	}

	public Account(String username, String matKhau, String ten, Date ngaySinh, Boolean gioiTinh, String sdt,
			String email, String diaChi, Boolean trangThai, Boolean chucVu) {
		super();
		this.username = username;
		this.matKhau = matKhau;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.chucVu = chucVu;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Boolean getChucVu() {
		return chucVu;
	}

	public void setChucVu(Boolean chucVu) {
		this.chucVu = chucVu;
	}

	public List<HoaDon> getHoaDonList() {
		return hoaDonList;
	}

	public void setHoaDonList(List<HoaDon> hoaDonList) {
		this.hoaDonList = hoaDonList;
	}

	public List<GioHang> getListGioHang() {
		return listGioHang;
	}

	public void setListGioHang(List<GioHang> listGioHang) {
		this.listGioHang = listGioHang;
	}
	
}
