package com.example.scheduling.user.service.impl;

import com.example.scheduling.user.entity.User;
import com.example.scheduling.user.mapper.UserMapper;
import com.example.scheduling.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author demo
 * @since 2018-10-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
