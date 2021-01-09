package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Comment {

    private Integer id;
    private String content;

    private Integer commenter;   //评论者
    private Integer articleId;  //被评论的文章id
    private Date createTime;  //创建日期

}
