package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.repository.ItemDao;
import spring.repository.ItemDaoImpl;

public class DetailController implements Controller {
	private ItemDao itemDao = new ItemDaoImpl();

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/detail.jsp?no="+no);
		mv.addObject("get", itemDao.get(no));
		
		return mv;
	}

}
