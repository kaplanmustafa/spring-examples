package com.mustafakaplan.springdatajpapostgresql.repository;

import com.mustafakaplan.springdatajpapostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
