package top.zhoulis.community.dto;

import lombok.Data;
import top.zhoulis.community.model.User;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModify;
    private Long likeCount;
    private String content;
    private User user;
    private Integer commentCount;
}
