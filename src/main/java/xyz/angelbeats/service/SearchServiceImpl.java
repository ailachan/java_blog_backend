package xyz.angelbeats.service;

import xyz.angelbeats.dao.SearchDao;
import xyz.angelbeats.dao.TypeDao;
import xyz.angelbeats.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SearchServiceImpl
 *
 * @date 2021/3/19 15:13
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchDao searchDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TypeDao typeDao;

    @Override
    public List<Map<String, Object>> getSearch(String kw, Integer page, Integer size, Integer pageSize) {
        List<Map<String, Object>> list = searchDao.getSearch(kw, (page-1)*pageSize, pageSize);
        List<Map<String, Object>> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> value = list.get(i);
            value.put("tags", typeDao.getTagByBlogId((Integer) value.get("blog_id")));
            //为每篇文章追加作者信息
            value.put("blogAuthor", userDao.selectUserById((Integer) value.get("user_id")));
            newList.add(value);
        }

        return newList;
    }

    @Override
    public Integer getSearchCount(String kw) {
        return searchDao.getSearchCount(kw);
    }
}
