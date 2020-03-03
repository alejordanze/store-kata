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
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			float booksDiscount = 0;
			if (getProduct().getUnitPrice() * getQuantity() >= 100) {
				booksDiscount = getAmountOf() * 10 / 100;
			}
			totalItem = getAmountOf() - booksDiscount;
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			// 20% discount for Bikes
			totalItem = getAmountOf() - getAmountOf() * 20 / 100;
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			float cloathingDiscount = 0;
			if (getQuantity() > 2) {
				cloathingDiscount = getProduct().getUnitPrice();
			}
			totalItem = getAmountOf() - cloathingDiscount;
		}
		return totalItem;
	}
	
	public float getAmountOf() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
