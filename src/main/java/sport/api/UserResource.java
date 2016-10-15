package sport.api;

import sport.controllers.UserController;
import sport.exceptions.EmptyFieldException;
import sport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper usersList() {
		return new UserController().userList();
	}

	// GET **/users/search
	public UserListWrapper searchBySport(String sportName) throws EmptyFieldException {
		return new UserController().usersBySport(sportName);
	}

	// POST **/users
	public void createUser(String request) throws Exception {
		String nick = request.split(":")[0];
		String email = request.split(":")[1];
		new UserController().createUser(nick, email);
	}

	public void addSport(String user, String sport) throws Exception {
		new UserController().addSport(user, sport);
	}

}
