package sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import sport.daos.SportDao;
import sport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer, Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public Sport getByName(String name) {
		List<Sport> sports = this.findAll();
		Sport result = null;
		for (Sport sport : sports) {
			if (sport.getName().equals(name)) {
				result = sport;
			}
		}
		return result;
	}

}