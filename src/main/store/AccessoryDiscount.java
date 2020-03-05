package store;

public class AccessoryDiscount implements Discount {

	public float getDiscount(OrderItem item) {
		float booksDiscount = 0;
		
		if (item.calculateTotal()  >= 100)
			booksDiscount = item.calculateTotal() * 10 / 100;
			
		return booksDiscount;
	}
}
