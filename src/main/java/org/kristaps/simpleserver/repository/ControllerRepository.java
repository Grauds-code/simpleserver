package org.kristaps.simpleserver.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.kristaps.simpleserver.models.UserModel;

@Repository

public interface ControllerRepository extends JpaRepository<UserModel, Long> {

    boolean existsByEmail(String email);

}
