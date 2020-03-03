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
		float totalItem = 0;
		float itemAmount = getProduct().getUnitPrice() * getQuantity();
		
		if (isAccesory())
			totalItem = getAccesoriesDisccount(itemAmount);
		
		if (isBike())
			totalItem = getBikeDisccount(itemAmount);
		
		if (isCloathing())
			totalItem = getClothingDisccount(itemAmount);
		
		return totalItem;
	}

	private boolean isCloathing() {
		return getProduct().getCategory() == ProductCategory.Cloathing;
	}

	private boolean isBike() {
		return getProduct().getCategory() == ProductCategory.Bikes;
	}

	private boolean isAccesory() {
		return getProduct().getCategory() == ProductCategory.Accessories;
	}
	
	private float getClothingDisccount(float itemAmount) {
		float totalItem;
		float cloathingDiscount = 0;
		if (getQuantity() > 2) {
			cloathingDiscount = getProduct().getUnitPrice();
		}
		totalItem = itemAmount - cloathingDiscount;
		return totalItem;
	}

	private float getBikeDisccount(float itemAmount) {
		float totalItem;
		totalItem = itemAmount - itemAmount * 20 / 100;
		return totalItem;
	}

	private float getAccesoriesDisccount(float itemAmount) {
		float totalItem;
		float booksDiscount = 0;
		if (itemAmount >= 100) {
			booksDiscount = itemAmount * 10 / 100;
		}
		totalItem = itemAmount - booksDiscount;
		return totalItem;
	}
}

