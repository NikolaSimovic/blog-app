package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@Size(min=3 , max=20, message = "min=3 max=20 characters")
	private String name;
	@Column
	@Size(min=5 , max=120, message = "min=5 max=120 characters")
	private String lastName;
	@Column
	@Size(min=5 , max=120, message = "min=5 max=120 characters")
	private String image;
	@Column
	@Size(min=9 , max=10, message = "min=9 max=10 characters")
	private String phoneNumber;
	@Column
	private boolean disabled = false;
	@Column
	private String password;
	
	public User() {}
	
	public User(int id, @Size(min = 3, max = 20, message = "min=3 max=20 characters") String name,
			@Size(min = 5, max = 120, message = "min=5 max=120 characters") String lastName,
			@Size(min = 5, max = 120, message = "min=5 max=120 characters") String image,
			@Size(min = 9, max = 10, message = "min=9 max=10 characters") String phoneNumber, boolean disabled,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.image = image;
		this.phoneNumber = phoneNumber;
		this.disabled = disabled;
		this.password = password;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "("+id+") - "+name;

	}
	
}
