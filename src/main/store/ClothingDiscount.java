package store;

public class ClothingDiscount implements Discount {
	
	public float getDiscount(OrderItem item) {
		float cloathingDiscount = 0;
		if (item.getQuantity() > 2) {
			cloathingDiscount = item.getProduct().getUnitPrice();
		}
		return cloathingDiscount;
	}

}
