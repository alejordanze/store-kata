package store;

public class BikeDiscount implements Discount {

	
	public float getDiscount(OrderItem item) {
		
		return item.calculateTotal() * 20 / 100;
	}
	
}
