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
		float itemAmount = getAmount();
		
		Discount discount = null;
		if (isAccesory())
			discount = new AccessoryDiscount();
		
		if (isBike())
			discount = new BikeDiscount();
		
		if (isCloathing())
			discount = new ClothingDiscount();
		
		totalItem = itemAmount - discount.getDiscount(this);
		
		return totalItem;
	}

	public float getAmount() {
		return getProduct().getUnitPrice() * getQuantity();
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
	
}

