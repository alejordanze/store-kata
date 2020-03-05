package store;

public class BikeDiscount implements Discount {

	
	public float getDiscount(OrderItem item) {
		
		return item.getAmount() * 20 / 100;
	}
	
}
