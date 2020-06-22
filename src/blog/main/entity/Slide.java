package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "slide")
public class Slide {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@Size(min=3 , max=20, message = "min=3 max=20 characters")
	private String title;
	@Column
	@Size(min=5 , max=20, message = "min=5 max=20 characters")
	private String buttonName;
	@Column
	@Size(min=5 , max=120, message = "min=5 max=120 characters")
	private String buttonUrl;
	@Column
	@Size(min=5 , max=120, message = "min=5 max=120 characters")
	private String image;
	@Column
	private boolean disabled = false;
	@Column
	private int order;
	
	public Slide() {}

	public Slide(int id, @Size(min = 3, max = 20, message = "min=3 max=20 characters") String title,
			@Size(min = 5, max = 20, message = "min=5 max=20 characters") String buttonName,
			@Size(min = 5, max = 120, message = "min=5 max=120 characters") String buttonUrl,
			@Size(min = 5, max = 120, message = "min=5 max=120 characters") String image, boolean disabled, int order) {
		super();
		this.id = id;
		this.title = title;
		this.buttonName = buttonName;
		this.buttonUrl = buttonUrl;
		this.image = image;
		this.disabled = disabled;
		this.order = order;
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

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonUrl() {
		return buttonUrl;
	}

	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "("+id+") - "+title;

	}
	
}
