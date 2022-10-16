
package com.pm.course.repositories;

import com.pm.course.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT DISTINCT b.name FROM User as b")
    List<String> getDistinctName();
    @Query("SELECT DISTINCT b.surname FROM User as b")
    List<Integer> getDistinctCost();

}