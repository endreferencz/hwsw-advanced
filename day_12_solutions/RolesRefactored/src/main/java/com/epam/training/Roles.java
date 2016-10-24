package com.epam.training;

import java.util.HashSet;
import java.util.Set;

import com.epam.training.filter.ElevatedRoleFilter;
import com.epam.training.filter.ElevatedRoleOnAccessLevelFilter;
import com.epam.training.filter.RoleAboveAccessLevelFilter;
import com.epam.training.filter.RoleBelowAccessLevelFilter;

public class Roles {

    public Set<Role> filterRoles(RoleFilter roleFilter) {
        Set<Role> roles = new HashSet<Role>();
        for (Role currentRole : Role.values()) {
            if (currentRole.isEnabled() && roleFilter.keep(currentRole)) {
                roles.add(currentRole);
            }
        }
        return roles;
    }

    public Set<Role> getElevatedRoles() {
        return filterRoles(new ElevatedRoleFilter());
    }

    public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
        return filterRoles(new RoleAboveAccessLevelFilter(accessLevel));
    }

    public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
        return filterRoles(new RoleBelowAccessLevelFilter(accessLevel));
    }

    public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
        return filterRoles(new ElevatedRoleOnAccessLevelFilter(accessLevel));
    }

}
