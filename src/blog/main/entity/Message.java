package blog.main.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min=3 , max=20, message = "min=3 max=20 characters")
	private String name;
	
	@Column
	@Size(min=10 , max=50, message = "min=10 max=50 characters")
	private String email;
	
	@Column
	@Size(min=10 , max=500, message = "min=10 max=500 characters")
	private String content;

	
	public Message() {}

	

	public Message(int id, @Size(min = 3, max = 20, message = "min=3 max=20 characters") String name,
			@Size(min = 10, max = 50, message = "min=10 max=50 characters") String email,
			@Size(min = 10, max = 500, message = "min=10 max=500 characters") String content, boolean read) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + "]";
	};
	

}
