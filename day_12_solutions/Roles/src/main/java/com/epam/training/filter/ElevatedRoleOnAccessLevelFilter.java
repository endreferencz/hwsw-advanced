package com.epam.training.filter;

import com.epam.training.Role;
import com.epam.training.RoleFilter;

public class ElevatedRoleOnAccessLevelFilter implements RoleFilter {

    private int accessLevel;

    public ElevatedRoleOnAccessLevelFilter(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean keep(Role role) {
        return role.isElevated() && accessLevel == role.getAccessLevel();
    }

}
