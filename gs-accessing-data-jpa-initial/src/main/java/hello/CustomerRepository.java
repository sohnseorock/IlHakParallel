package hello;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    
    @Modifying
    @Query("UPDATE Customer c SET c.lastName = :lastName WHERE c.firstName = :firstName")
    @Transactional
    int updateLastName(@Param("lastName") String lastName, @Param("firstName") String firstName);
}
