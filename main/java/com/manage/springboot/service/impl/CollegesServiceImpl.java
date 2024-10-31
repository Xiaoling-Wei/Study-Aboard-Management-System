package com.manage.springboot.service.impl;

import com.manage.springboot.entity.Colleges;
import com.manage.springboot.mapper.CollegesMapper;
import com.manage.springboot.service.ICollegesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 院校 服务实现类
 * </p>
 *
 * @author zsc
 * @since 2023-04-07
 */
@Service
public class CollegesServiceImpl extends ServiceImpl<CollegesMapper, Colleges> implements ICollegesService {

}
