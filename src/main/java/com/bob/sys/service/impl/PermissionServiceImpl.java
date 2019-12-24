package com.bob.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bob.sys.entity.Permission;
import com.bob.sys.mapper.PermissionMapper;
import com.bob.sys.service.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 琵琶晚翠
 * @since 2019-12-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
