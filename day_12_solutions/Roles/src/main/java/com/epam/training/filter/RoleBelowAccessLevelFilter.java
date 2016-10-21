package com.epam.training.filter;

import com.epam.training.Role;
import com.epam.training.RoleFilter;

public class RoleBelowAccessLevelFilter implements RoleFilter {

    private int accessLevel;

    public RoleBelowAccessLevelFilter(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean keep(Role role) {
        return role.getAccessLevel() < accessLevel;
    }

}
