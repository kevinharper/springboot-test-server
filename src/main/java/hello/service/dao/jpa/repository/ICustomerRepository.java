package hello.service.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import hello.service.dao.jpa.entity.CustomerJPA;

public interface ICustomerRepository extends CrudRepository<CustomerJPA, Long> {

    CustomerJPA findByEmail(String email);

    CustomerJPA findByLastName(String lastName);
}
