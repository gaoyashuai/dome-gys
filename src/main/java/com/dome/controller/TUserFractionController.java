package com.dome.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dome.domain.TUser;
import com.dome.domain.TUserFraction;
import com.dome.domain.Test;
import com.dome.param.ParentParam;
import com.dome.param.Result;
import com.dome.service.ITUserFractionService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 * 分数 前端控制器
 * </p>
 *
 * @author gaoyashuai
 * @since 2020-07-29
 */
@RestController
@RequestMapping("/dome")
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
        test.setObject(objectObjectLinkedHashMap);
        System.out.println(JSON.toJSONString(test));

        Result result = new Result();
        result.setData(objectObjectLinkedHashMap);
        return result;
    }
}

