package com.lambdaschool.ordersmysql.repositories;

import com.lambdaschool.ordersmysql.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
