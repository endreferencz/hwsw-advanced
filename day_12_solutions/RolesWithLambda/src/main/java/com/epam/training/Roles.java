package com.epam.training;

import java.util.HashSet;
import java.util.Set;

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
        return filterRoles(role -> role.isElevated());
    }

    public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
        return filterRoles(role -> accessLevel >= role.getAccessLevel());
    }

    public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
        return filterRoles(role -> accessLevel < role.getAccessLevel());
    }

    public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
        return filterRoles(role -> accessLevel == role.getAccessLevel() && role.isElevated());
    }

}
