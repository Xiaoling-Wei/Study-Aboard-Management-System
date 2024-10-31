package com.manage.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manage.springboot.controller.dto.UserDTO;
import com.manage.springboot.controller.dto.UserPasswordDTO;
import com.manage.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsc
 * @since 2022-01-26
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);

    Page<User> findPage(Page<User> objectPage, String username, String email, String address);
}
