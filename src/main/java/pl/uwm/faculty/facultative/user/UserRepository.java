package pl.uwm.faculty.facultative.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity, Long> {
}
