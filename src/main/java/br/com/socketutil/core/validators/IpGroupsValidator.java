package br.com.socketutil.core.validators;

import br.com.socketutil.core.pattern.Validator;

public class IpGroupsValidator implements Validator<String> {

	@Override
	public boolean isValid(String obj) {
		String[] groups = obj.split("\\.");
		if (groups.length != 4) {
			return false;
		} else {
			return true;
		}
	}

}
