package com.phucdn.learnSpringSecurity.utils;

public final class Constant {
	public static final int DEFAULT_PASSWORD_LENGTH = 12; 
	
	public static class EMPLOYEE_DEMO {
		public static final String ACTIVATE_STATUS = "Activate";
		public static final String IN_ACTICATE_STATUS = "InActivate";
	}
	
	public static class DEPARTMENT_DEMO {
		public static final String ACTIVATE_STATUS = "Activate";
		public static final String IN_ACTICATE_STATUS = "InActivate";
	}
	
	public static class EMPLOYEE_DEPARTMENT_DEMO {
		public static final String ACTIVATE_STATUS = "Activate";
		public static final String IN_ACTICATE_STATUS = "InActivate";
	}
	
	public static class LOCKER_DEMO {
		public static final String ACTIVATE_STATUS = "Activate";
		public static final String IN_ACTIVATE_STATUS = "InActivate";
		public static final String DESCRIPTION = "Create new Personal locker for new emp in dep on "+DateInstance.getCurrentTime();
		public static final String CREATE_BY = "admin1";
		public static final String UPDATE_BY = "admin2";
	}
}
