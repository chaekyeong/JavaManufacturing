package mvc.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ArticleDTO implements Serializable {
	private long no;
	private String title;
	private String name;
	private String password;
	private String content;
	private Date regdate;
	private int readcount;
	
	public void setPassword(String password) {
		// 비밀번호 암호화
		this.password = DigestUtils.sha3_512Hex(password);
	}
}
