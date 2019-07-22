package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.ItemDto;
import spring.repository.ItemDao;
import spring.repository.ItemDaoImpl;

public class RegistController implements Controller {
	private ItemDao itemDao = new ItemDaoImpl();
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		if(arg0.getMethod().equals("GET")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/view/regist.jsp");
			return mv;
		}
		else if(arg0.getMethod().equals("POST")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/");
			ItemDto itemDto = ItemDto.builder()
									.name(arg0.getParameter("name"))
									.type(arg0.getParameter("type"))
									.price(Integer.parseInt(arg0.getParameter("price")))
									.build();
			itemDao.insert(itemDto);
			return mv;

		}
		return null;
	}

}
