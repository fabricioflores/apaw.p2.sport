package es.upm.miw.apiArchitectureTheme.controllers;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;

public class SportController {
	public void createSport(String sport) {
		DaoFactory.getFactory().getSportDao().create(new Sport(sport));
	}
}
