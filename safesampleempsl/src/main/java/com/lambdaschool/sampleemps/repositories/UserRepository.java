package com.lambdaschool.sampleemps.repositories;

import com.lambdaschool.sampleemps.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD repository connecting User to the rest of the application
 */
public interface UserRepository
    extends CrudRepository<User, Long>
{
    /**
     * Find a user based off over username
     *
     * @param username the name (String) of user you seek
     * @return the first user object with the name you seek
     */
    User findByUsername(String username);

}
