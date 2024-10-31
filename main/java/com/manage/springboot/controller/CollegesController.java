package com.manage.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manage.springboot.common.Result;
import com.manage.springboot.entity.Colleges;
import com.manage.springboot.service.ICollegesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/colleges")
public class CollegesController {

    @Resource
    private ICollegesService collegesService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Colleges colleges) {
        collegesService.saveOrUpdate(colleges);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        collegesService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        collegesService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(collegesService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(collegesService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<Colleges> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(collegesService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
    @GetMapping("/findBy")
    public Result findBy(Colleges colleges) {
        LambdaQueryWrapper<Colleges> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Colleges::getId);
        wrapper.eq(!Objects.isNull(colleges.getCountry()),Colleges::getCountry,colleges.getCountry());
        wrapper.eq(!Objects.isNull(colleges.getLanguage()),Colleges::getLanguage,colleges.getLanguage());
        wrapper.select(Colleges::getName);
        // 数据库： 8.5 15 2.6
        // 输入 : 8
        if (!Objects.isNull(colleges.getGpa())||!Objects.isNull(colleges.getScore())) {
            wrapper.and(w -> {
                w.or().gt(!Objects.isNull(colleges.getGmat()), Colleges::getGmat, colleges.getGmat());
                w.or().gt(!Objects.isNull(colleges.getGre()), Colleges::getGre, colleges.getGre());
                w.or().le(!Objects.isNull(colleges.getGpa()),Colleges::getGpa,colleges.getGpa());
                w.le(!Objects.isNull(colleges.getScore()),Colleges::getScore,colleges.getScore());
            });
        }


        List<Colleges> list = collegesService.list(wrapper);
        List<String> collect = list.stream().map(Colleges::getName).collect(Collectors.toList());
        return Result.success(collect);
    }


}

