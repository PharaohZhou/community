package top.zhoulis.community.dto;

import lombok.Data;
import top.zhoulis.community.model.User;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private String tag;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
