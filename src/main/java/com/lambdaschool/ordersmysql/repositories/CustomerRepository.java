package com.lambdaschool.ordersmysql.repositories;

import com.lambdaschool.ordersmysql.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
