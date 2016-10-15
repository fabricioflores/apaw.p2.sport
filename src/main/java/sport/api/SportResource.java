package sport.api;

import sport.controllers.SportController;

public class SportResource {

	public void createSport(String sportName) throws Exception {
		new SportController().createSport(sportName);
	}
}
