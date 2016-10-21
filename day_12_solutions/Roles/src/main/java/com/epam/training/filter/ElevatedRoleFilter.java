package com.epam.training.filter;

import com.epam.training.Role;
import com.epam.training.RoleFilter;

public class ElevatedRoleFilter implements RoleFilter {

    @Override
    public boolean keep(Role role) {
        return role.isElevated();
    }

}
