package com.abc.domain;

public enum EnrollmentStatus {
	//ö����
		SUCCESS("ע��ɹ�"),SECTIONFULL("ע��ʧ�ܣ�����Ա"),
		PREREQ("ע��ʧ�ܣ�ǰ����δ��"),ENROLLED("ע��ʧ�ܣ��Ѿ�ע��");
		
		//ʵ������
		private final String value;
		
		EnrollmentStatus(String value){
			this.value=value;
		}
		
		public String value() {
			return value;
		}

}
