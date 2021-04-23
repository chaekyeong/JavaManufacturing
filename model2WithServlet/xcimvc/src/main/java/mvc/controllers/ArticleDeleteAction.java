package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ArticleDTO;
import mvc.service.ArticleService;
import mvc.service.ArticleServiceImpl;

public class ArticleDeleteAction extends AbstractController {
	ArticleService articleService = ArticleServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		
		ModelAndView mav = new ModelAndView();
		try {
			articleService.deleteArticle(no);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "게시물이 삭제되었습니다.");
			mav.addObject("url", "list");
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
}
