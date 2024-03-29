package xyz.angelbeats.service;

import xyz.angelbeats.dao.UserDao;
import xyz.angelbeats.entity.User;
import xyz.angelbeats.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserServiceImpl
 *
 * @date 2021/2/26 13:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Map<String, Object> login(Map<String, String> name_password) {
        User userDB = userDao.login(name_password);
        Map<String, Object> map = new HashMap<>();

        if (userDB != null) {
//            登陆成功返回token
            Map<String, String> payload = new HashMap<>();
            payload.put("name", userDB.getUser_name());
            payload.put("email", userDB.getUser_email());
            //生成token
            String token = JWTUtils.getToken(payload);
            //返回用户名和头像
            map.put("user_name", userDB.getUser_name());
            map.put("avatar",userDB.getUser_avatar());
            map.put("token", token);
            map.put("github_link",userDB.getUser_github_link());
        }
        return map;

    }

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }
}
