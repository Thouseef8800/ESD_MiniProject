package com.thouseef.backend.repo;

import com.thouseef.backend.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
    Employees findByEmail(String username);
}
