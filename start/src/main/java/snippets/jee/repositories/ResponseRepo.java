package snippets.jee.repositories;

import snippets.jee.base.ResponseStatus;
import snippets.jee.entities.Response;
import snippets.jee.entities.User;

import java.util.Set;

public interface ResponseRepo extends AbstractRepo<Response> {
    Set<Response> findAllForUser(User user);

    Set<Response> findAllByStatus(ResponseStatus responseStatus);
}
