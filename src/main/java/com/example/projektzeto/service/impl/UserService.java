package com.example.projektzeto.service.impl;

import com.example.projektzeto.entity.User;
import com.example.projektzeto.repository.UserRepository;
import com.example.projektzeto.service.IService;
import com.example.projektzeto.utils.DTO.UserDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDTO> convertToDto() {
        List<User> userList = findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(UserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .mobile(user.getMobile())
                    .name(user.getName())
                    .role(user.getRole())
                    .build());

        }
        return userDTOList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepository.deleteById(id);
            jsonObject.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
