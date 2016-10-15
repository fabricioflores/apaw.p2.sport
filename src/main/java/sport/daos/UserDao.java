package sport.daos;

import java.util.List;

import sport.entities.Sport;
import sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

	public abstract void addSport(User user, Sport sport);

	public abstract List<User> usersBySport(String sport);

	public abstract User getByName(String name);

}
