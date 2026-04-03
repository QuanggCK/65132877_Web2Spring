package clc65.quanggck;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clc65.quanggck.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}