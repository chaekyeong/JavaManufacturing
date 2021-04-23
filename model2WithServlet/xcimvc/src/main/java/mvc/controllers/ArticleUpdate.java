package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ArticleDTO;
import mvc.service.ArticleService;
import mvc.service.ArticleServiceImpl;

public class ArticleUpdate extends AbstractController {
	private ArticleService articleService = ArticleServiceImpl.getInstance();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		try {
			ArticleDTO articleDTO = articleService.getDetail(no, false);
			return new ModelAndView("/WEB-INF/views/update.jsp", "articleDTO", articleDTO);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}

}
