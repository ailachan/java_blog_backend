package xyz.angelbeats.service;

import xyz.angelbeats.dao.TypeDao;
import xyz.angelbeats.dao.UserDao;
import xyz.angelbeats.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TypyServiceImpl
 *
 * @date 2021/3/2 23:52
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<Map<String, String>> getType() {
        return typeDao.getType();
    }

    @Override
    public void postType(Types types) {
        typeDao.postType(types);
    }

    @Override
    public void deleteType(Integer id) {
        typeDao.deleteType(id);

    }

    @Override
    public void putType(Types types) {
        typeDao.putType(types);

    }


    @Override
    public List<Map<String, Object>> getTagByBlogId(Integer id) {
        return typeDao.getTagByBlogId(id);
    }

    /**
     * 根据标签查文章：增加查询文章作者功能
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> getBlogByTag(Integer id) {
        List<Map<String, Object>> list = typeDao.getBlogByTag(id);

        List<Map<String, Object>> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> value = list.get(i);
            value.put("blogAuthor", userDao.selectUserById((Integer) value.get("user_id")));
            newList.add(value);
        }
        return newList;
    }

    @Override
    public List<Map<String, Object>> getAllTypeTagByPage(Integer page, Integer size, Integer pageSize) {
        List<Map<String, Object>> list = typeDao.getAllTypeTagByPage((page-1)*pageSize, pageSize);
        return list;
    }

    @Override
    public Integer getTypeCount() {
        return typeDao.getTypeCount();
    }

    @Override
    public List<Map<String, Object>> getAllTypeTag() {
        return typeDao.getAllTypeTag();
    }


}
