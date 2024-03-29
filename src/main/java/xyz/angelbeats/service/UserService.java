package xyz.angelbeats.service;


import xyz.angelbeats.entity.User;

import java.util.Map;

/**
 * UserService
 *
 * @date 2021/2/26 13:50
 */
public interface UserService {

    Map<String, Object> login(Map<String, String> name_password);

    User selectUserById(Integer id);
}
