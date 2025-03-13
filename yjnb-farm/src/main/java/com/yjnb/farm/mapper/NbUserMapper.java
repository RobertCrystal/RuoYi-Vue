package com.yjnb.farm.mapper;

import com.yjnb.farm.domain.NbUser;

public interface NbUserMapper {
    public NbUser userLogin(NbUser nbUser);
    public int userRegister(NbUser nbUser);
}
