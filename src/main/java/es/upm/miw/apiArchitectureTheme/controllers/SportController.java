package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;

public class SportController {

	public void createSport(String sport) throws Exception {
		if (!existsSport(sport)) {
			DaoFactory.getFactory().getSportDao().create(new Sport(sport));
		} else {
			throw new Exception();
		}
	}

	public boolean existsSport(String name) {
		boolean itExists = false;
		List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
		for (Sport sport : sportList) {
			if (sport.getName().equals(name)) {
				itExists = true;
			}
		}
		return itExists;
	}
}
