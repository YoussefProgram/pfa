package com.example.pfa.mapper;

import com.example.pfa.dto.UserDTO;
import com.example.pfa.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO fromUser(User user) {
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public User fromUserDTO(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
