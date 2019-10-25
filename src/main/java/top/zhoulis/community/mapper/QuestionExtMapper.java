package top.zhoulis.community.mapper;

import top.zhoulis.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question question);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);
}