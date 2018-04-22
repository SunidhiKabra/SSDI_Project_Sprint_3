package dao;

import java.util.List;

import model.IItem;
import model.Item;

public interface IItemDao {
	void addItem(Item item);
	List<IItem> getItems(int custId);
}
