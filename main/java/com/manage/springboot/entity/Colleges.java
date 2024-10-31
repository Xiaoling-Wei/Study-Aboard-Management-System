package com.manage.springboot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
  @ApiModel(value = "Colleges对象", description = "院校")
public class Colleges implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("院校id")
        private Integer id;

      @ApiModelProperty("国家")
      private String country;

      @ApiModelProperty("gpa")
      private Float gpa;

      @ApiModelProperty("语言")
      private String language;

      @ApiModelProperty("参加")
      private Float score;

      @ApiModelProperty("gre")
      private Float gre;

      @ApiModelProperty("gmat")
      private Float gmat;

      @ApiModelProperty("院校名称")
      private String name;

      @ApiModelProperty("排名")
      private Integer sort;

      @ApiModelProperty("参加时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime createTime;


}
