package com.enumvals;

public class EnumTest {
	
	private enum Vals {
		AFRICA, BANGLADESH;
	}
	
	private enum validateResult{
		error("01", "Invalid Details"),
		suxs("00", "Success");
		
		private String code;
		private String description;
		
		private validateResult(String code, String description) {
			this.code = code;
			this.description = description;
		}
		
		public static validateResult ok() {
			return suxs;
		}
		
		public static validateResult fail() {
			return error;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
		
		
	}
	
	public static void main(String[] args) {
		printMessage(validateResult.ok());
		printMessage(validateResult.fail());
	}
	
	private static void printMessage(validateResult res) {
		System.out.println(res.getCode());
		System.out.println(res.getDescription());
	}
}
