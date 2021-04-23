package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ArticleDTO;
import mvc.service.ArticleService;
import mvc.service.ArticleServiceImpl;

public class ArticleDetail extends AbstractController {
	ArticleService articleService = ArticleServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		
		try {
			ArticleDTO articleDTO = articleService.getDetail(no, true);
			return new ModelAndView("/WEB-INF/views/detail.jsp", "articleDTO", articleDTO);
		} catch(Exception e) {
			e.printStackTrace();
			// 에러났을 때 항상 사용할 경로
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
		}
		return null;
 	}

}
