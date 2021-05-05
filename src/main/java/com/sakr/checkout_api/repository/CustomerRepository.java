package com.sakr.checkout_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sakr.checkout_api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = " select c from Customer c where id=:customerId ")
	Customer getCustomersById(@Param("customerId") Integer customerId);

}
