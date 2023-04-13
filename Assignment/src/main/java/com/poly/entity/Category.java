package com.poly.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private UUID id;
	
	@Column(name = "tenLoai")
	private String tenLoai;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> categoryList;

	public Category(UUID id, String tenLoai) {
		super();
		this.id = id;
		this.tenLoai = tenLoai;
	}

	public Category() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<Product> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Product> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
