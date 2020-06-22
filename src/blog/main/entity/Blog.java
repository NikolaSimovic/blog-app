package blog.main.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	@Size(min=3 , max=20, message = "min=3 max=20 characters")
	private String title;
	@Column
	@Size(min=5 , max=500, message = "min=5 max=120 characters")
	private String description;
	@Column
	@Size(min=5 , max=1000, message = "min=5 max=120 characters")
	private String body;
	@Column
	@Size( max=250, message = " max=120 characters")
	private String image;
	@Column
	private boolean important;
	@Column
	private boolean disabled;
	@Column
	private int views;
	@Column
	private int numOfComments;
	@Column
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private User user;
	@JoinColumn(name = "idCategory")
	@ManyToOne(cascade = {CascadeType.DETACH ,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	private Category category;
	@ManyToMany(cascade = {CascadeType.DETACH ,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "tag_blog",joinColumns =  @JoinColumn(name="idBlog"),inverseJoinColumns = @JoinColumn(name="idTag"))
	private List<Tag> tags;
	@JoinColumn(name = "idBlog")
	@OneToMany(cascade = {CascadeType.DETACH ,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Comment> comments;
	
	public Blog() {};
	
	public Blog(int id, @Size(min = 3, max = 20, message = "min=3 max=20 characters") String title,
			@Size(min = 5, max = 500, message = "min=5 max=120 characters") String description,
			@Size(min = 5, max = 1000, message = "min=5 max=120 characters") String body,
			@Size(max = 120, message = " max=120 characters") String image, boolean important, boolean disabled,
			int views, int numOfComments, Date date, @Valid User user, Category category, List<Tag> tags) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.body = body;
		this.image = image;
		this.important = important;
		this.disabled = disabled;
		this.views = views;
		this.numOfComments = numOfComments;
		this.date = date;
		this.user = user;
		this.category = category;
		this.tags = tags;
	}
	
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getNumOfComments() {
		return numOfComments;
	}
	public void setNumOfComments(int numOfComments) {
		this.numOfComments = numOfComments;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", description=" + description + ", important=" + important
				+ ", disabled=" + disabled + ", views=" + views + ", numOfComments=" + numOfComments + ", user=" + user
				+ "]";
	}
	
}
