package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper usersList() {
		return new UserController().userList();
	}

	// GET **users/search
	public UserListWrapper searchBySport(String sportName) throws NotFoundThemeIdException {
		return new UserController().usersBySport(sportName);
	}

}
