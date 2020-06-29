package com.dome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dome.Timer.TimerTaskTest;
import com.dome.domain.TUser;
import com.dome.dao.TUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dome.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gaoyashuai
 * @since 2020-06-18
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<String> getList() {
        List<String> collect = tUserMapper.selectList(new QueryWrapper<TUser>().lambda()
                .eq(TUser::getDeleted, false)
                .and(i -> i.eq(TUser::getCreator, "李白").ne(TUser::getSalt, "活着"))
        ).stream().map(TUser::getUserId).collect(Collectors.toList());
        return collect;
    }
}
