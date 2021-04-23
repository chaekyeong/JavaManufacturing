package mvc.service;

import java.util.List;

import mvc.models.ArticleDTO;

public interface ArticleService {

	void insertArticle(ArticleDTO articleDTO) throws Exception;

	List<ArticleDTO> getArticleList(long pg) throws Exception;

	ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception;

	ArticleDTO getDetail(long no) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;
	
	void deleteArticle(long no) throws Exception;
	
	long getTotalRecord() throws Exception;
}
