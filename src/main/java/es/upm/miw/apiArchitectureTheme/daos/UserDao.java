package es.upm.miw.apiArchitectureTheme.daos;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

	public abstract void addSport(User user, Sport sport);

	public abstract List<User> usersBySport(String sport);

	public abstract User getByName(String name);

}
