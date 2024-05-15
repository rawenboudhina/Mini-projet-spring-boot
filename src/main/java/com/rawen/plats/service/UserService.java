package com.rawen.plats.service;

import com.rawen.plats.entities.Role;
import com.rawen.plats.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}
