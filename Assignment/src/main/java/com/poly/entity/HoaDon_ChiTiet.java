package com.poly.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoaDon_ChiTiet")
public class HoaDon_ChiTiet {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id")
	private Product productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoaDonId", referencedColumnName = "id")
	private HoaDon hoaDonId;
	
	@Column(name = "soLuong")
	private Integer soLuong;
	
	@Column(name = "donGia")
	private BigDecimal donGia;
	
	@Column(name = "tong")
	private BigDecimal tong;

	public HoaDon_ChiTiet() {
		super();
	}

	public HoaDon_ChiTiet(UUID id, Product productId, HoaDon hoaDonId, Integer soLuong, BigDecimal donGia,
			BigDecimal tong) {
		super();
		this.id = id;
		this.productId = productId;
		this.hoaDonId = hoaDonId;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tong = tong;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public HoaDon getHoaDonId() {
		return hoaDonId;
	}

	public void setHoaDonId(HoaDon hoaDonId) {
		this.hoaDonId = hoaDonId;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public BigDecimal getTong() {
		return tong;
	}

	public void setTong(BigDecimal tong) {
		this.tong = tong;
	}
	
	
}
