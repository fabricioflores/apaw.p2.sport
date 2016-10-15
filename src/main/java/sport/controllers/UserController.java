package sport.controllers;

import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.Sport;
import sport.entities.User;
import sport.exceptions.EmptyFieldException;
import sport.exceptions.EntityNotFoundException;
import sport.exceptions.NameInUseException;
import sport.wrappers.UserListWrapper;
import sport.wrappers.UserWrapper;

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
			throw new NameInUseException(name);
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

	public UserListWrapper usersBySport(String sport) throws EmptyFieldException {
		if (sport != null && !sport.isEmpty()) {
			List<User> users = DaoFactory.getFactory().getUserDao().usersBySport(sport);
			UserListWrapper userListWrapper = new UserListWrapper();
			for (User user : users) {
				userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
			}
			return userListWrapper;
		} else {
			throw new EmptyFieldException();
		}
	}

	public void addSport(String user, String sport) throws Exception {
		User userObject = DaoFactory.getFactory().getUserDao().getByName(user);
		Sport sportObject = DaoFactory.getFactory().getSportDao().getByName(sport);
		if (userObject != null) {
			if (sportObject != null) {
				DaoFactory.getFactory().getUserDao().addSport(userObject, sportObject);
			} else {
				throw new EntityNotFoundException(sport);
			}
		} else {
			throw new EntityNotFoundException(user);
		}
	}

}
