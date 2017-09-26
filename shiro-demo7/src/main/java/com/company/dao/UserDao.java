package com.company.dao;

import com.company.entity.User;

import java.util.Set;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface UserDao {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrectionRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPerissions(String username);

}
