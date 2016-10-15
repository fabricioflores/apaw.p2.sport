package sport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sport.daos.UserDao;
import sport.entities.Sport;
import sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public void addSport(User entity, Sport sport) {
		this.read(entity.getId()).getSports().add(sport);
	}

	@Override
	public List<User> usersBySport(String sport) {
		List<User> users = this.findAll();
		List<User> usersWithSport = new ArrayList<>();
		for (User user : users) {
			for (Sport sportUser : user.getSports()) {
				if (sportUser.getName().equals(sport)) {
					usersWithSport.add(user);
				}
			}
		}
		return usersWithSport;
	}

	@Override
	public User getByName(String name) {
		List<User> users = this.findAll();
		User result = null;
		for (User user : users) {
			if (user.getNick().equals(name)) {
				result = user;
			}
		}
		return result;
	}

}