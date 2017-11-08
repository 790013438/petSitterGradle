package snippets.jee.repositories;

import snippets.jee.base.PetType;
import snippets.jee.entities.Pet;
import snippets.jee.entities.User;

import java.util.Set;

public interface PetRepo extends AbstractRepo<Pet> {
    Pet findByOwner(User user);

    Set<Pet> findAllByOwner(User user);

    Set<Pet> findAllByType(PetType petType);

}
