package com.spring.permissions;

public enum UserPermissions {
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write");
	
	private final String persimsion;

	private UserPermissions(String persimsion) {
		this.persimsion = persimsion;
	}

	public String getPersimsion() {
		return persimsion;
	}
	
	
	/*
	 * public static void main(String[] args) { String persimsion2 =
	 * UserPermissions.STUDENT_WRITE.getPersimsion();
	 * System.out.println(persimsion2); }
	 */
	
	

}
