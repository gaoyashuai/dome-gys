package com.dome.service.impl;

import com.dome.domain.TUser;
import com.dome.dao.TUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dome.service.ITUserService;
import org.springframework.stereotype.Service;

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

}
