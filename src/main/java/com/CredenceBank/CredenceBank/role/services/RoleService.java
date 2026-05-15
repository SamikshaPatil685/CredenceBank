package com.CredenceBank.CredenceBank.role.services;

import com.CredenceBank.CredenceBank.res.Response;
import com.CredenceBank.CredenceBank.role.entity.Role;

import java.util.List;

public interface RoleService {

    Response<Role> createRole(Role roleRequest);

    Response<Role> updateRole(Role roleRequest);

    Response<List<Role>> getAllRoles();

    Response<?> deleteRole(Long id);

}
