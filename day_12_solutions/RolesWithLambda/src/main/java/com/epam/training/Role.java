package com.epam.training;

public enum Role {
	
	ADMIN(true, 10), USER(true, 8), TRAINER(true, 9), PARTICIPANT(false, 2, false), DEVELOPER(true, 5), ASSISTANT(false, 4);

	private boolean elevated;

	private boolean enabled;

	private int accessLevel;
	
	private Role(boolean elevated, int accessLevel) {
		this.elevated = elevated;
		this.enabled = true;
		this.accessLevel = accessLevel;
	}

	private Role(boolean elevated, int accessLevel, boolean enabled) {
		this.elevated = elevated;
		this.enabled = enabled;
		this.accessLevel = accessLevel;
	}

	public boolean isElevated() {
		return elevated;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}