package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;

public class SportResource {
	public void createSport(String sportName) {
		new SportController().createSport(sportName);
	}
}
