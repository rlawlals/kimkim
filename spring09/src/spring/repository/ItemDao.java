package spring.repository;

import java.util.List;

import spring.entity.ItemDto;

public interface ItemDao {
	void insert(ItemDto dto); //상품등록
	List<ItemDto> list(); // 상품리스트
	List<ItemDto> get(int no); // 상품상세

}
