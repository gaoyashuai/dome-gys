package com.dome.service;

import com.dome.domain.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author gaoyashuai
 * @since 2020-06-18
 */
public interface ITUserService extends IService<TUser> {

    List<String> getList();

}
