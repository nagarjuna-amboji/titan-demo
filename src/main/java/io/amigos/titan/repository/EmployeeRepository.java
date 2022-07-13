package io.amigos.titan.repository;

import io.amigos.titan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.active = ?1")
    List<Employee> findByActiveExists(boolean isActive);
}
