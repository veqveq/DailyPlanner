package ru.veqveq.server.dto;

import lombok.Data;
import ru.veqveq.server.models.User;

@Data
public class UserDto {
    private Long id;
    private String username;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
