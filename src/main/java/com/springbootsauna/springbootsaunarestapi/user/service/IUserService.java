package com.springbootsauna.springbootsaunarestapi.user.service;

import com.springbootsauna.springbootsaunarestapi.user.dto.UserDto;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;

import java.util.List;

public interface IUserService {
    ResponseObject createUser(UserDto userDto);
    ResponseObject findAll(Integer pageNumber, Integer pageSize);
    ResponseObject updateUser(User user);


}
