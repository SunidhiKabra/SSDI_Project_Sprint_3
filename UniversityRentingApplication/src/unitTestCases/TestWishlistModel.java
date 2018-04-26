package unitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Wishlist;

public class TestWishlistModel {
	@Test
	public void testId() {
		Wishlist w = new Wishlist();
		int expected = 2;
		w.setId(expected);
		assertEquals(w.getId(),expected);
	}
	@Test
	public void testCustomerId() {
		Wishlist w = new Wishlist();
		int expected = 4;
		w.setCustomerId(expected);
		assertEquals(w.getCustomerId(),expected);
	}
	@Test
	public void testItemId() {
		Wishlist w = new Wishlist();
		int expected = 6;
		w.setItemId(expected);
		assertEquals(w.getItemId(),expected);
	}
}
