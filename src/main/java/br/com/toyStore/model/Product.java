package br.com.toyStore.model;

public class Product {

	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageName;
	
	private Category category;
	
	public Product() {
	}

	public Product(Long id, String name, Double price, String description, Category category, String imageName) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.imageName = imageName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
