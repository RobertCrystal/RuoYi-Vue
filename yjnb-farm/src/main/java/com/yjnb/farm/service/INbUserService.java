package com.yjnb.farm.service;

import com.yjnb.farm.domain.NbUser;

public interface INbUserService {
    public NbUser userLogin(NbUser nbFarmUser);
    public int userRegister(NbUser nbFarmUser);
}
