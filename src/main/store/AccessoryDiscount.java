package store;

public class AccessoryDiscount implements Discount {

	public float getDiscount(OrderItem item) {
		float booksDiscount = 0;
		
		if (item.getAmount() >= 100)
			booksDiscount = item.getAmount() * 10 / 100;
			
		return booksDiscount;
	}
}
