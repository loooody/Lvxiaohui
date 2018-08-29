package org.lv.domain;

public class Book {
	private String image;
	private String name;
	private String author;
	private int price;
	public Book(String image, String name, String author, int price) {
		super();
		this.image = image;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
