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
@Table(name = "GioHang")
public class GioHang {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id")
	private Product productId;
	
	@Column(name = "soLuong")
	private Integer soLuong;
	
	@Column(name = "donGia")
	private BigDecimal donGia;
	
	@Column(name = "tong")
	private BigDecimal tong;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId", referencedColumnName = "username")
	private Account account;

	public GioHang(UUID id, Product productId, Integer soLuong, BigDecimal donGia, BigDecimal tong, Account account) {
		super();
		this.id = id;
		this.productId = productId;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tong = tong;
		this.account = account;
	}

	public GioHang() {
		super();
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
