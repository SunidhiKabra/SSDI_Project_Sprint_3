package unitTestCases;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import dao.ItemDao;
import model.Item;
import service.ItemService;

public class TestItemService {
	
	@Mock
	ItemDao id;
	
	@Test
	public void testItemService() {
		Item item = new Item();
		ItemService is = Mockito.spy(new ItemService(id));
		is.addItem(item);
		Mockito.verify(is).addItem(item);
	}
}
