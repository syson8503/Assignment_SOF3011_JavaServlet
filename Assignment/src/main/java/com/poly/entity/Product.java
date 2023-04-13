package com.poly.entity;

import java.math.BigDecimal;
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

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private UUID id;
	
	@Column(name = "tenSP")
	private String tenSP;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "gioiThieu")
	private String gioiThieu;
	
	@Column(name = "hinhAnh")
	private String hinhAnh;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "id")
	private Category category;
	
	@OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<HoaDon_ChiTiet> hoaDonChiTietList;
    
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<GioHang> gioHangList;

	public Product() {
	}

	public Product(UUID id, String tenSP, BigDecimal price, Integer quantity, String gioiThieu, String hinhAnh,
			Category category) {
		this.id = id;
		this.tenSP = tenSP;
		this.price = price;
		this.quantity = quantity;
		this.gioiThieu = gioiThieu;
		this.hinhAnh = hinhAnh;
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<HoaDon_ChiTiet> getHoaDonChiTietList() {
		return hoaDonChiTietList;
	}

	public void setHoaDonChiTietList(List<HoaDon_ChiTiet> hoaDonChiTietList) {
		this.hoaDonChiTietList = hoaDonChiTietList;
	}

	public List<GioHang> getGioHangList() {
		return gioHangList;
	}

	public void setGioHangList(List<GioHang> gioHangList) {
		this.gioHangList = gioHangList;
	}
    
    
	
}
