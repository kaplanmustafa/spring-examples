package com.mustafakaplan.springelasticsearch.repository;

import com.mustafakaplan.springelasticsearch.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    List<User> findByNameLikeOrSurnameLike(String name, String surname);
}
