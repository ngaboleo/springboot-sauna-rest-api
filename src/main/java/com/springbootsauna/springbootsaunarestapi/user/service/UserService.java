package com.springbootsauna.springbootsaunarestapi.user.service;

import com.springbootsauna.springbootsaunarestapi.user.dto.UserDto;
import com.springbootsauna.springbootsaunarestapi.user.entity.IUserRepository;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EGender;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import com.springbootsauna.springbootsaunarestapi.util.PageUtil;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public ResponseObject createUser(UserDto userDto) {
        try {
            User user = new User();
            System.out.println(userDto.getGender());
            System.out.println(userDto.getRole());
//            System.out.println(userDto.getFirstName());
//            System.out.println(userDto.getPhoneNumber());
//            System.out.println(userDto.getNationalId());
            BeanUtils.copyProperties(userDto, user);
            user.setEGender(EGender.valueOf(userDto.getGender()));
            user.setERole(ERole.valueOf(userDto.getRole()));
//            System.out.println(user.getEGender());
//            System.out.println(user.getERole());
//            System.out.println(user.getFirstName());
            User user1 = iUserRepository.save(user);
            UserDto userDto1 = new UserDto();
            BeanUtils.copyProperties(user1, userDto1);
            userDto1.setGender(user1.getEGender().name());
            userDto1.setRole(user1.getERole().name());
            return new ResponseObject(userDto1);
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

    @Override
    public ResponseObject findAll(Integer pageNumber, Integer pageSize) {
        try {
            return new ResponseObject(iUserRepository.findAll(PageUtil.getPageable(pageNumber, pageSize)));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

    @Override
    public ResponseObject updateUser(User user) {
        try {
            return new ResponseObject(iUserRepository.save(user));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }
}
