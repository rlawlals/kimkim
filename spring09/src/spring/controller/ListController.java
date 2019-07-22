package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.ItemDto;
import spring.repository.ItemDao;
import spring.repository.ItemDaoImpl;

public class ListController implements Controller{
	private ItemDao itemDao = new ItemDaoImpl();
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/list.jsp");
		
		List<ItemDto> list = itemDao.list();
		
		mv.addObject("list",list);
		return mv;
	}

}
