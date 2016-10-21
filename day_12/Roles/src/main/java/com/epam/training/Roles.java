package com.epam.training;

import java.util.HashSet;
import java.util.Set;

public class Roles {

	public Set<Role> getElevatedRoles() {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.isEnabled() && currentRole.isElevated()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}
	
	public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() >= accessLevel) {
				if (currentRole.isEnabled()) {
					roles.add(currentRole);
				}
			}
		}
		return roles;
	}
	
	public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() < accessLevel && currentRole.isEnabled()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}
	
	public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() == accessLevel && currentRole.isEnabled() && currentRole.isElevated()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}
	
	
}
