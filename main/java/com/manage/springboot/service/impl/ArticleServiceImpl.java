package com.manage.springboot.service.impl;

import com.manage.springboot.entity.Article;
import com.manage.springboot.mapper.ArticleMapper;
import com.manage.springboot.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
