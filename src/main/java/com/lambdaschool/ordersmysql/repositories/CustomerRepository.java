package com.lambdaschool.ordersmysql.repositories;

import com.lambdaschool.ordersmysql.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value ="SELECT * FROM customers c WHERE c.customercode = :customercode", nativeQuery = true)
    Customer findCustomerByCode(@Param("customercode") long customercode);

    @Query(value="SELECT c.name, o.ordernum FROM customers AS c INNER JOIN orders AS o ON c.customercode = o.customercode ORDER BY c.customercode ASC", nativeQuery = true)
    List<Object[]> findAllCustomersWithOrders();

    @Query(value = "SELECT c.name, o.ordernum FROM customers AS c INNER JOIN orders AS o WHERE c.name Like :name", nativeQuery = true)
    List<Object[]> findCustomerByNameWithOrders(@Param("name") String name);

    List<Customer> findCustomerByName(String name);
}
