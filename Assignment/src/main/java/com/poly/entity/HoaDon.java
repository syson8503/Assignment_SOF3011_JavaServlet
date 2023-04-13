package com.poly.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "HoaDon")
public class HoaDon {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private UUID id;
	
	@Column(name = "tongTien")
	private BigDecimal tongTien;
	
	@Column(name = "ngayTao")
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	
	@Column(name = "ngayThanhToan")
	@Temporal(TemporalType.DATE)
	private Date ngayThanhToan;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khachHang", referencedColumnName = "username")
	private Account khachHang;
	
	@Column(name = "trangThai")
	private Boolean trangThai;
	
	@OneToMany(mappedBy = "hoaDonId", fetch = FetchType.LAZY)
    private List<HoaDon_ChiTiet> hoaDonChiTietList;

	public HoaDon() {
		super();
	}

public HoaDon(UUID id, BigDecimal tongTien, Date ngayTao, Date ngayThanhToan, Account khachHang, Boolean trangThai,
			List<HoaDon_ChiTiet> hoaDonChiTietList) {
		super();
		this.id = id;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.ngayThanhToan = ngayThanhToan;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
		this.hoaDonChiTietList = hoaDonChiTietList;
	}

//	public HoaDon(UUID id, BigDecimal tongTien, Date ngayTao, Date ngayThanhToan, Account khachHang,
//			Boolean trangThai) {
//		super();
//		this.id = id;
//		this.tongTien = tongTien;
//		this.ngayTao = ngayTao;
//		this.ngayThanhToan = ngayThanhToan;
//		this.khachHang = khachHang;
//		this.trangThai = trangThai;
//	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getTongTien() {
		return tongTien;
	}

	public void setTongTien(BigDecimal tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public Account getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(Account khachHang) {
		this.khachHang = khachHang;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public List<HoaDon_ChiTiet> getHoaDonChiTietList() {
		return hoaDonChiTietList;
	}

	public void setHoaDonChiTietList(List<HoaDon_ChiTiet> hoaDonChiTietList) {
		this.hoaDonChiTietList = hoaDonChiTietList;
	}
    
    
}
