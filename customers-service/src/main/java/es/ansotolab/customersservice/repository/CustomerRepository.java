package es.ansotolab.customersservice.repository;

import es.ansotolab.customersservice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Optional<Customer> findById(long id);
    public Optional<Customer> findByCif(String cif);
    public Optional<Customer> findByCifAndIdNot(String cif, long id);
}
