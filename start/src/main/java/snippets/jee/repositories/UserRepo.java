package snippets.jee.repositories;

import snippets.jee.entities.User;

import java.util.Set;

public interface UserRepo extends AbstractRepo<User> {
    Set<User> findAllByUserName(String username, boolean exactMatch);

    Set<User> findByRating(double startRating, double endRating);
}
