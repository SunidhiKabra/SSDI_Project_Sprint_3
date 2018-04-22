package unitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Item;

public class TestItemModel {
	@Test
	public void returnNullValuesForDefaultConstructor() {
		Item item = new Item();
		assertEquals(-1, item.getItemId());
		assertEquals(-1, item.getCustomerId());
		assertEquals(null, item.getName());
		assertEquals(null, item.getDescription());
		assertEquals(0.0f, item.getRent(), 0);
	}
	@Test
	public void returnValuesWithoutId() {
		Item item = new Item(4, "iPhone X", "apple", (float) 96.00, true);
		assertEquals(4, item.getCustomerId());
		assertEquals("iPhone X", item.getName());
		assertEquals("apple", item.getDescription());
		assertEquals(96.00, item.getRent(), 0);
	}
	@Test
	public void returnValuesWithId() {
		Item item = new Item(8, 4, "iPhone X", "apple", (float) 96.00, true);
		assertEquals(8, item.getItemId());
		assertEquals(4, item.getCustomerId());
		assertEquals("iPhone X", item.getName());
		assertEquals("apple", item.getDescription());
		assertEquals(96.00, item.getRent(), 0);
	}
	@Test
	public void testCustomerID() {
		Item item = new Item(8, 4, "iPhone X", "apple", (float) 96.00, true);
		assertEquals(4, item.getCustomerId());
		item.setCustomerId(10);
		assertEquals(10, item.getCustomerId());
	}
	@Test
	public void testName() {
		Item item = new Item(8, 4, "iPhone X", "apple", (float) 96.00, true);
		assertEquals("iPhone X", item.getName());
		item.setName("IPHONE X 2017");
		assertEquals("IPHONE X 2017", item.getName());
	}
	@Test
	public void testDescription() {
		Item item = new Item(8, 4, "iPhone X", "apple", (float) 96.00, true);
		assertEquals("apple", item.getDescription());
		item.setDescription("apple smart phone");
		assertEquals("apple smart phone", item.getDescription());
	}
	@Test
	public void testRent() {
		Item item = new Item(8, 4, "iPhone X", "apple", (float) 96.00,true);
		assertEquals(96.00, item.getRent(), 0);
		item.setRent((float) 84.50);
		assertEquals(84.50, item.getRent(), 0);
	}
}
