package mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ArticleDAOImpl implements ArticleDAO {
	
	private DataSource dataSource;
	private static final ArticleDAOImpl memberDAO = new ArticleDAOImpl();
	private ArticleDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArticleDAO getInstance() {
		return memberDAO;
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO t_board(no, title, name, password, content) ");
		sql.append("VALUES(seq_board.nextval, ?, ?, ?, ?) ");
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql.toString())){
			ps.setString(1, articleDTO.getTitle());
			ps.setString(2, articleDTO.getName());
			ps.setString(3, articleDTO.getPassword());
			ps.setString(4, articleDTO.getContent());
			ps.executeUpdate();
		}
	}

	@Override
	public List<ArticleDTO> getArticleList(long startNum, long endNum) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select B.* ");
		sql.append("from (select rownum as rnum, A.* ");
		sql.append("       from (select no, title, name, readcount, regdate ");
		sql.append("               from t_board ");
		sql.append("               order by no desc) A) B ");
		sql.append("where rnum between ? and ? ");
		List<ArticleDTO> list = new ArrayList<>();
		
		try (Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql.toString())){
			ps.setLong(1, startNum);
			ps.setLong(2, endNum);
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					ArticleDTO articleDTO = new ArticleDTO();
					articleDTO.setNo(rs.getLong("no"));
					articleDTO.setTitle(rs.getString("Title"));
					articleDTO.setName(rs.getString("Name"));
					articleDTO.setRegdate(rs.getDate("Regdate"));
					articleDTO.setReadcount(rs.getInt("readcount"));
					
					list.add(articleDTO);
				}
			}
		
		}
		return list;
	}

	@Override
	public void updateReadcount(long no) throws Exception {

	}

	@Override
	public ArticleDTO getDetail(long no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select no, title, name, readcount, regdate, content ");
		sql.append("from t_board ");
		sql.append("where no=? ");
		
		ArticleDTO articleDTO = null;
		
		List<ArticleDTO> list = new ArrayList<>();
		
		try (Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql.toString())){
			ps.setLong(1, no);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					articleDTO = new ArticleDTO();
					articleDTO.setNo(rs.getLong("no"));
					articleDTO.setTitle(rs.getString("Title"));
					articleDTO.setName(rs.getString("Name"));
					articleDTO.setRegdate(rs.getDate("Regdate"));
					articleDTO.setReadcount(rs.getInt("readcount"));
					articleDTO.setContent(rs.getString("content"));
				}
			}
		
		}
		return articleDTO;
	}

	@Override
	public ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select no, title, name, readcount, regdate, content ");
		sql.append("from t_board ");
		sql.append("where no=? ");
		
		ArticleDTO articleDTO = null;
		
		List<ArticleDTO> list = new ArrayList<>();
		
		try (Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql.toString())){
			ps.setLong(1, no);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					articleDTO = new ArticleDTO();
					articleDTO.setNo(rs.getLong("no"));
					articleDTO.setTitle(rs.getString("Title"));
					articleDTO.setName(rs.getString("Name"));
					articleDTO.setRegdate(rs.getDate("Regdate"));
					articleDTO.setReadcount(rs.getInt("readcount"));
					articleDTO.setContent(rs.getString("content"));
				}
			}
		
		}
		return articleDTO;
	}

	@Override
	public void deleteArticle(long no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_board ");
		sql.append("where no = ? ");
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql.toString())){
			ps.setLong(1, no);
			ps.executeUpdate();
		}
	}

	@Override
	public int updateArticle(ArticleDTO articleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE t_board SET ");
		sql.append("title=? ");
		sql.append(",name=? ");
		sql.append(",content=? ");
		sql.append("WHERE no=? AND password=? ");

		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, articleDTO.getTitle());
			pstmt.setString(2, articleDTO.getName());
			pstmt.setString(3, articleDTO.getContent());
			pstmt.setLong(4, articleDTO.getNo());
			pstmt.setString(5, articleDTO.getPassword());
			return pstmt.executeUpdate();
		}		
	}

	@Override
	public long getTotalRecord() throws Exception {
		long recordCount = 0;

		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) ");
		sql.append("as cnt ");
		sql.append("from t_board ");

		try (Connection con = dataSource.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql.toString())) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					recordCount = rs.getLong("cnt");
				}
			}

		}
		return recordCount;
	}
}

