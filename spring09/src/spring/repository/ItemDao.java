package spring.repository;

import java.util.List;

import spring.entity.ItemDto;

public interface ItemDao {
	void insert(ItemDto dto); //��ǰ���
	List<ItemDto> list(); // ��ǰ����Ʈ
	List<ItemDto> get(int no); // ��ǰ��

}
