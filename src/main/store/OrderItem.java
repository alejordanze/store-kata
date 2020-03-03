package store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public float calculateTotal() {
		float totalItem=0;
		
		if (getProductCategory() == ProductCategory.Accessories)
			totalItem = getTotalAmount() - getDiscountForBook();
		if (getProductCategory() == ProductCategory.Bikes)
			totalItem = getTotalAmount() - getDiscountForBike();
		if (getProductCategory() == ProductCategory.Cloathing)
			totalItem = getTotalAmount() - getCloathingDiscount();
		
		return totalItem;
	}

	private ProductCategory getProductCategory() {
		return getProduct().getCategory();
	}

	private float getCloathingDiscount() {
		float cloathingDiscount = 0;
		if (getQuantity() > 2) {
			cloathingDiscount = getProduct().getUnitPrice();
		}
		return cloathingDiscount;
	}

	private float getDiscountForBike() {
		return getTotalAmount() * 20 / 100;
	}

	private float getDiscountForBook() {
		float bookDiscount = 0;
		if (getProduct().getUnitPrice() * getQuantity() >= 100) {
			bookDiscount = getTotalAmount() * 10 / 100;
		}
		return bookDiscount;
	}
	
	public float getTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
