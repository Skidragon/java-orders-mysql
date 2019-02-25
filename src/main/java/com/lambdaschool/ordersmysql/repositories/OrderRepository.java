package com.lambdaschool.ordersmysql.repositories;

import com.lambdaschool.ordersmysql.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value="SELECT * FROM orders o WHERE o.ordernum = :ordernum", nativeQuery = true)
    Order findOrderByOrderNumber(@Param("ordernum") long ordernum);
}
