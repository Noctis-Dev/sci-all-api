package com.sci_all.demo.service;

import com.sci_all.demo.persistance.entities.Role;

public interface IRoleService {

    Role findRoleByName(String name);

}
