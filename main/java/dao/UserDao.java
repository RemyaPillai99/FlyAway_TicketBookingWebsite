package dao;

import java.util.List;

import model.User;

public interface UserDao {
    public void saveUser (User user);
    public List<User> showAllUsers();
    public User getUser(String emailId);
	public void updateUser(String emailID, String password);
}
