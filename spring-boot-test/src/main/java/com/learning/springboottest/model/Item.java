package com.learning.springboottest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

//without setters and getter and and default constructor wont work in message conversion
@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private int quantity;
	private long price;
	
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", value=" + value
				+ "]";
	}
	@Transient
	private long value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Item(int id, String name, int quantity, long price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public Item() {
	}
}
