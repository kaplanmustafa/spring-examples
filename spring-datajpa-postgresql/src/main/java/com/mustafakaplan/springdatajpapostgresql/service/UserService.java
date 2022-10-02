package com.mustafakaplan.springdatajpapostgresql.service;

import com.mustafakaplan.springdatajpapostgresql.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    void delete(Long id);

    List<UserDto> getAll();

    Page<List<UserDto>> getAll(Pageable pageable);
}
