package xyz.angelbeats.dao;

import xyz.angelbeats.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * CommentDao
 *
 * @date 2021/3/17 21:57
 */
@Mapper
public interface CommentDao {

    List<Map<String, Object>> getCommentByBlogId(Integer id);

    void postComment(BlogComment blogComment);

    void putComment(BlogComment blogComment);

    void deleteComment(Integer id);
}
