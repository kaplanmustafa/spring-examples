package com.mustafakaplan.springmongorestapi.repository;

import com.mustafakaplan.springmongorestapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
