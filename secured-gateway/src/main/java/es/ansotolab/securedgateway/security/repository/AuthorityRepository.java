package es.ansotolab.securedgateway.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ansotolab.securedgateway.security.model.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
