package com.mustafakaplan.springdatajpapostgresql.service.impl;

import com.mustafakaplan.springdatajpapostgresql.dto.UserDto;
import com.mustafakaplan.springdatajpapostgresql.entity.Address;
import com.mustafakaplan.springdatajpapostgresql.entity.User;
import com.mustafakaplan.springdatajpapostgresql.repository.AddressRepository;
import com.mustafakaplan.springdatajpapostgresql.repository.UserRepository;
import com.mustafakaplan.springdatajpapostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
//        Assert.isNull(userDto.getName(), "Name field is required!");

        List<Address> addressList = new ArrayList<>();
        User user = new User();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userInDb = userRepository.save(user);

        userDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(Boolean.TRUE);
            address.setUser(userInDb);

            addressList.add(address);
        });

        addressRepository.saveAll(addressList);
        userDto.setId(userInDb.getId());

        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoListList = new ArrayList<>();

        userList.forEach(item -> {
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setName(item.getName());
            userDto.setSurname(item.getName());
            userDto.setAddresses(item.getAddresses()
                    .stream()
                    .map(Address::getAddress)
                    .collect(Collectors.toList()));

            userDtoListList.add(userDto);
        });

        return userDtoListList;
    }

    @Override
    public Page<List<UserDto>> getAll(Pageable pageable) {
        return null;
    }
}
