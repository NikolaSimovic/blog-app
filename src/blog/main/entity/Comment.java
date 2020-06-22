package blog.main.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min=10 , max=500, message = "min=10 max=500 characters")
	private String body;
	
	@Column
	private boolean disabled;
	
	@Column
	private Date date;
	
	@Column
	private String user;
	
	@Column
	private String email;
	
	@Column
	private int idBlog;
	
	public Comment() {}

	

	public Comment(int id, @Size(min = 10, max = 500, message = "min=10 max=500 characters") String body,
			boolean disabled, Date date, String user, int idBlog, String email) {
		super();
		this.id = id;
		this.body = body;
		this.disabled = disabled;
		this.date = date;
		this.user = user;
		this.idBlog = idBlog;
		this.email = email;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	public boolean isDisabled() {
		return disabled;
	}



	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public int getIdBlog() {
		return idBlog;
	}



	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}



	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + "]";
	};
	

}
