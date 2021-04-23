package mvc.service;

import java.util.List;

import mvc.models.ArticleDAO;
import mvc.models.ArticleDAOImpl;
import mvc.models.ArticleDTO;

public class ArticleServiceImpl implements ArticleService {
	private static final ArticleService articleService = new ArticleServiceImpl();
	private ArticleDAO articleDAO = ArticleDAOImpl.getInstance();
	
	private ArticleServiceImpl() {
	}
	
	public static ArticleService getInstance() {
		return articleService;
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws Exception {
		articleDAO.insertArticle(articleDTO);
	}

	@Override
	public List<ArticleDTO> getArticleList(long pg) throws Exception {
		int pageSize = 10;
		
		long startNum = (pg - 1) * pageSize + 1;
		long endNum = pageSize * pg;
		
		return articleDAO.getArticleList(startNum, endNum);
	}
	
	@Override
	public ArticleDTO getDetail(long no) throws Exception {
		return getDetail(no, true);
	}
	
	@Override
	public ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception {
		try {
			if (updateReadcount) articleDAO.updateReadcount(no);
			
			ArticleDTO articleDTO = articleDAO.getDetail(no);
			
			if (articleDTO == null) {
				throw new RuntimeException("글 수정을 위한 원글 읽어오기 실패");
			}
			return articleDTO;
		} finally {
			
		}
	}

	@Override
	public void updateArticle(ArticleDTO articleDTO) throws Exception {
		if (articleDAO.updateArticle(articleDTO) == 0) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
		
	}

	@Override
	public void deleteArticle(long no) throws Exception {
		articleDAO.deleteArticle(no);
		
	}

	@Override
	public long getTotalRecord() throws Exception {
		return articleDAO.getTotalRecord();
	}
	
}
