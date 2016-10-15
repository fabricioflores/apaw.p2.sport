package sport.controllers;

import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.Sport;
import sport.exceptions.NameInUseException;

public class SportController {

	public void createSport(String sport) throws Exception {
		if (!existsSport(sport)) {
			DaoFactory.getFactory().getSportDao().create(new Sport(sport));
		} else {
			throw new NameInUseException(sport);
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
