package clc65.quanggck;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clc65.quanggck.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
}