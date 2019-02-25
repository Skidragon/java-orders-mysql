package com.lambdaschool.ordersmysql.repositories;

import com.lambdaschool.ordersmysql.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
