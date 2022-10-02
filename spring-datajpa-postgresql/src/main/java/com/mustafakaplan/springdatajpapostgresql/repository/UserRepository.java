package com.mustafakaplan.springdatajpapostgresql.repository;

import com.mustafakaplan.springdatajpapostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
