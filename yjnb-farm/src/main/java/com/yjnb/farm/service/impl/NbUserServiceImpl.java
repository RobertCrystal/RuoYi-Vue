package com.yjnb.farm.service.impl;

import com.yjnb.common.utils.UniqueIdGenerator;
import com.yjnb.farm.domain.NbUser;
import com.yjnb.farm.mapper.NbUserMapper;
import com.yjnb.farm.service.INbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NbUserServiceImpl implements INbUserService {
    @Autowired
    private NbUserMapper nbUserMapper;

    public int userRegister(NbUser nbUser) {
        nbUser.setUserId(UniqueIdGenerator.generateUniqueId());
        return nbUserMapper.userRegister(nbUser);
    }

    public NbUser userLogin(NbUser nbUser) {
        return nbUserMapper.userLogin(nbUser);
    }
}
