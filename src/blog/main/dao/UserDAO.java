package blog.main.dao;

import java.util.List;

import blog.main.entity.User;


public interface UserDAO {
	
	public List<User> getUserList();
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User getUser(int id);
	
	public void deleteUser(int id);
	
	public void disableUser(int id);

}
