package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Article {
private Integer id;
private String title;
private String content;

private Integer userId;  //外键关联到User表
private Date createTime;  //创建日期
}
