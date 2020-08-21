package com.dome.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dome.domain.Book;
import com.dome.domain.TUserFraction;
import com.dome.domain.Test;
import com.dome.param.ParentParam;
import com.dome.param.Result;
import com.dome.repository.BookRepo;
import com.dome.service.ITUserFractionService;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分数 前端控制器
 * </p>
 *
 * @author gaoyashuai
 * @since 2020-07-29
 */
@RestController
@RequestMapping("/dome/test01")
public class TUserFractionController {

    @Resource
    private ITUserFractionService userFractionService;

    @PostMapping("/groupByAndSum")
    public Result groupByAndSum(@RequestBody ParentParam parentParam) {
        List<TUserFraction> tUserFractions = userFractionService.getBaseMapper().selectList(new QueryWrapper<TUserFraction>().lambda()
                .groupBy(TUserFraction::getUserId));

        Map<String, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        objectObjectLinkedHashMap.put("123112", "ddd");
        objectObjectLinkedHashMap.put("345", "ddd");
        objectObjectLinkedHashMap.put("3334444", "ddd");
        for (Object o : objectObjectLinkedHashMap.keySet()) {
            System.out.println(o.toString());
        }
        Test test = new Test();
//        test.setObject(objectObjectLinkedHashMap);
        System.out.println(JSON.toJSONString(test));

        Result result = new Result();
        result.setData(objectObjectLinkedHashMap);
        return result;
    }

    @Resource
    BookRepo bookRepo;

    // 存数据
    @PostMapping("/saveEs")
    public Result saveEs(@RequestBody Book book) {

        Book save = bookRepo.save(book);

        Result result = new Result();
        result.setCode("200");
        result.setMessage("success");
        result.setData(save);
        return result;
    }

    // 根据name查找数据
    @GetMapping("/book/get/{name}")
    public Result getBook(@PathVariable String name) {
        List<Book> byNameLike = bookRepo.findByNameLike(name);

        Result result = new Result();
        result.setCode("200");
        result.setMessage("success");
        result.setData(byNameLike);
        return result;
    }

    @GetMapping("/book/all")
    public List<Book> getAll() {
        return Lists.newArrayList(bookRepo.findAll());
    }

    @DeleteMapping("/book/delete/{id}")
    public Result deleteById(@PathVariable String id) {
        Book book = new Book();
        book.setId(id);
        bookRepo.delete(book);

        Result result = new Result();
        result.setCode("200");
        result.setMessage("success");
        return result;
    }
}
