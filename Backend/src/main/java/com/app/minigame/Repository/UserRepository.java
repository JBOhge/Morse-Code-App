package com.app.minigame.Repository;

import com.app.minigame.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, String> {

    public Users findByUsername(String name);

    public Users findById(Integer id);

    boolean existsUsersByUsername(String username);

    boolean existsUsersByUsernameAndPassword(String username, String password);

}
