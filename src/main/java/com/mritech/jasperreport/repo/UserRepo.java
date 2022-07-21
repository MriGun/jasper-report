package com.mritech.jasperreport.repo;

import com.mritech.jasperreport.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findFirstByEmail(String email);
    Users findFirstById(Long id);
    Optional<Users> findByEmail(String email);
}
