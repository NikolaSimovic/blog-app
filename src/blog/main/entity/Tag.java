package blog.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tag")
public class Tag {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min=3 , max=20, message = "min=3 max=20 characters")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "tag_blog",joinColumns = @JoinColumn(name="idTag"),inverseJoinColumns = @JoinColumn(name="idBlog"))
	private List<Blog> blogs;
	
	
	public Tag() {
	
	}


	public Tag(int id, @Size(min = 3, max = 20, message = "min=3 max=20 characters") String name, List<Blog> blogs) {
		super();
		this.id = id;
		this.name = name;
		this.blogs = blogs;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}



	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
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
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+id+")  "+name;
	}
	
	

}
