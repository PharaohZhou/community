package top.zhoulis.community.mapper;

import top.zhoulis.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}