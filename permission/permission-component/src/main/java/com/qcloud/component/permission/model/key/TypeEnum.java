package com.qcloud.component.permission.model.key;

public class TypeEnum {
	public enum PermissionType {
		P1(1, "菜单"), P2(2, "资源");
		private final int key;
		private final String name;

		private PermissionType(int key, String name) {
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

	public enum AccountEnableType {
		ENABLE(1, "启用"), DISABLE(0, "停用");
		private final int key;
		private final String name;

		private AccountEnableType(int key, String name) {
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
