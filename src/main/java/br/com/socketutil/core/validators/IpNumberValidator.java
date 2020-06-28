package br.com.socketutil.core.validators;

import br.com.socketutil.core.pattern.Validator;

public class IpNumberValidator implements Validator<String> {

	@Override
	public boolean isValid(String obj) {
		boolean result = true;
		String[] groups = obj.split("\\.");
		for (int i = 0; i < groups.length; i++) {
			if (Integer.parseInt(groups[i]) < 0 || Integer.parseInt(groups[i]) > 255) {
				result = false;
				break;
			}
		}
		return result;
	}

}
