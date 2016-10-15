package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	public void createUser(String nick, String name) throws Exception {
		if (!existsUser(nick)) {
			DaoFactory.getFactory().getUserDao().create(new User(nick, name));
		} else {
			throw new Exception();
		}
	}

	public boolean existsUser(String nick) {
		boolean itExists = false;
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		for (User user : userList) {
			if (user.getNick().equals(nick)) {
				itExists = true;
			}
		}
		return itExists;
	}

	public UserListWrapper usersBySport(String sport) {
		List<User> users = DaoFactory.getFactory().getUserDao().usersBySport(sport);
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : users) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		System.out.println(users.size());
		return userListWrapper;
	}

	public void addSport(String user, String sport) throws Exception {
		User userObject = DaoFactory.getFactory().getUserDao().getByName(user);
		Sport sportObject = DaoFactory.getFactory().getSportDao().getByName(sport);
		if (userObject != null && sportObject != null) {
			DaoFactory.getFactory().getUserDao().addSport(userObject, sportObject);
		} else {
			throw new Exception();
		}
	}

}
