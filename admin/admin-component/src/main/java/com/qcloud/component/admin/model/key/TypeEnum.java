package com.qcloud.component.admin.model.key;

public class TypeEnum {
	public enum AdminEnableType {
		ENABLE(1, "启用"), DISABLE(0, "禁用");
		private final int key;
		private final String name;

		private AdminEnableType(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}
}
