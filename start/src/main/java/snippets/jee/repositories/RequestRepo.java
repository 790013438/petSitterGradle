package snippets.jee.repositories;

import snippets.jee.base.RequestStatus;
import snippets.jee.entities.Request;
import snippets.jee.entities.User;

import java.util.Set;

public interface RequestRepo extends AbstractRepo<Request> {
    Set<Request> findAllForUser(User user);

    Set<Request> findByStatus(RequestStatus requestStatus);
}
