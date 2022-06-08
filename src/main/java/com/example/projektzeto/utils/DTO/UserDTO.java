package com.example.projektzeto.utils.DTO;

import com.example.projektzeto.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private Role role;


}
