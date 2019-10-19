package top.zhoulis.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import top.zhoulis.community.model.Question;
import top.zhoulis.community.model.QuestionExample;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question question);

    int incCommentCount(Question record);
}