package org.lv.validator;

import org.lv.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object object,Errors errors) {
		//��֤username��sex��age�Ƿ�Ϊnull
		ValidationUtils.rejectIfEmpty(errors, "username", null,"�û�������Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "sex", null,"�Ա���Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "age", null,"���䲻��Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "password", null,"���벻��Ϊ��");
	}
}
