package com.abc.domain;

public enum EnrollmentStatus {
	//枚举量
		SUCCESS("注册成功"),SECTIONFULL("注册失败：已满员"),
		PREREQ("注册失败：前驱课未修"),ENROLLED("注册失败：已经注册");
		
		//实例变量
		private final String value;
		
		EnrollmentStatus(String value){
			this.value=value;
		}
		
		public String value() {
			return value;
		}

}
