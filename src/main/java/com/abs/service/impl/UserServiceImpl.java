package com.abs.service.impl;

import org.springframework.stereotype.Service;

import com.abs.entity.User;
import com.abs.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
}
