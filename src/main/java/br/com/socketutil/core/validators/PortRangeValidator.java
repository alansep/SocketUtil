package br.com.socketutil.core.validators;

import br.com.socketutil.core.exception.SocketUtilException;
import br.com.socketutil.core.pattern.Validator;

public class PortRangeValidator implements Validator<Integer>{

	@Override
	public boolean isValid(Integer obj) {
		if(obj == null) {
			throw new SocketUtilException("Invalid port number.");
		}
		return obj > 0 && obj <= 65535;
	}
	
}
