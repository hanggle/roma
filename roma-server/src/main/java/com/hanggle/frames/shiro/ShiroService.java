package com.hanggle.frames.shiro;

import com.hanggle.frames.util.AccountValidatorUtil;
import com.oskyhang.system.entity.BdPermission;
import com.oskyhang.system.entity.BdRole;
import com.oskyhang.system.entity.BdUser;
import com.oskyhang.system.service.BdUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: hanggle
 * @date: 2019/1/15
 */
@Slf4j
@Service
public class ShiroService {

    @Autowired
    private BdUserService bdUserService;

    public BdUser getUserInfoByUsername(String username){
        log.debug("ShiroService[]getUserInfoByUsername, username:{}" + username);
        // 手机号
        if (AccountValidatorUtil.isMobile(username)) {
            return bdUserService.getUserInfo(username, "tel");
        }

        // 邮箱
        if (AccountValidatorUtil.isEmail(username)) {
            return bdUserService.getUserInfo(username, "email");
        }
        // 用户名
        return bdUserService.getUserInfo(username, "username");
    }

    public List<BdRole> selectRoleByUser(String username){
        log.debug("ShiroService[]selectRoleByUser, username:{}", username);
        BdPermission bdPermission = new BdPermission();
        bdPermission.setUrl("/api/user/user/info");

        BdRole bdRole = new BdRole();
        bdRole.setRole("admin");

        return Collections.singletonList(bdRole);
    }

    public List<BdPermission> selectPermission(List<Long> roleIds){
        log.debug("ShiroService[]selectPermission, roleIds:{}", roleIds);
        BdPermission bdPermission = new BdPermission();
        bdPermission.setUrl("1qweqw");

        return Collections.singletonList(bdPermission);
    }
}
