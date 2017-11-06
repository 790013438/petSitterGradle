package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

public class Request extends AbstractEntity {
    private User user;
    private java.util.Date startAt;
    private java.util.Date endAt;
    private snippets.jee.base.RequestStatus requestStatus;
    private java.util.Set<Pet> pets;
    private String details;
    private java.util.Set<Response> responses;
}
