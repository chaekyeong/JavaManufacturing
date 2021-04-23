package mvc.models;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDAO {

	void insertArticle(ArticleDTO articleDTO) throws SQLException;

	List<ArticleDTO> getArticleList(long startNum, long endNum) throws Exception;

	void updateReadcount(long no) throws Exception;

	ArticleDTO getDetail(long no) throws Exception;
	
	ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception;

	int updateArticle(ArticleDTO articleDTO) throws SQLException;
	
	void deleteArticle(long no) throws Exception;
	
	long getTotalRecord() throws Exception;
}
