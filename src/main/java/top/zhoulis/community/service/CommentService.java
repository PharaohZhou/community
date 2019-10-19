package top.zhoulis.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhoulis.community.enums.CommentTypeEnum;
import top.zhoulis.community.exception.CustomizeErrorCode;
import top.zhoulis.community.exception.CustomizeException;
import top.zhoulis.community.mapper.CommentMapper;
import top.zhoulis.community.mapper.QuestionExtMapper;
import top.zhoulis.community.mapper.QuestionMapper;
import top.zhoulis.community.model.Comment;
import top.zhoulis.community.model.Question;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
