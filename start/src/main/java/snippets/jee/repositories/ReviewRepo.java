package snippets.jee.repositories;

import snippets.jee.entities.Request;
import snippets.jee.entities.Response;
import snippets.jee.entities.Review;
import snippets.jee.entities.User;

import java.util.Set;

public interface ReviewRepo extends AbstractRepo<Review> {
    Set<Review> findAllForUser(User user);

    Set<Review> findAllForRequest(Request request);

    Set<Review> findAllForResponse(Response response);
}
