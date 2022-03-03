package com.lwx.mapper;

import com.lwx.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(int id);
}
