package mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ArticleDTO;
import mvc.service.ArticleService;
import mvc.service.ArticleServiceImpl;

public class ArticleList extends AbstractController {
	private ArticleService articleService = ArticleServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long pg = 1;
		
		try {
			pg = Long.parseLong(request.getParameter("pg"));
		} catch(Exception e){}
		
		// 아래 페이징
		int pageBlock = 10;
		//pg -1을 한 이유는 일의 자리가 0일 떄 넘어가는것을 대비해서 이다.
		long startPage = (pg - 1)/pageBlock*pageBlock + 1;
		long endPage = (pg - 1)/pageBlock*pageBlock + pageBlock;		
		
		int pageSize = 10;
		long recordCount = 0;
		
		try {
			recordCount = articleService.getTotalRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long totalPage = recordCount / pageSize;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
		if (recordCount % pageSize > 0){
			totalPage++;
		}
		
		ModelAndView mav = new ModelAndView();
		try {
			List<ArticleDTO> list = articleService.getArticleList(pg);
			for(ArticleDTO dto : list) {
				System.out.println(dto);
				break;
			}
			mav.setViewName("/WEB-INF/views/list.jsp");
			mav.addObject("list", list);
			mav.addObject("pg", pg);
			mav.addObject("startPage", startPage);
			mav.addObject("endPage", endPage);
			mav.addObject("totalPage", totalPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}
}
