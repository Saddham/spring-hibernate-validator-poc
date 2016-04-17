package com.saddham.spring.hibernate.validation.domain;

import javax.validation.Payload;

public class ValidationSeverity {
	public interface Error extends Payload {
	}

	public interface Warning extends Payload {
	}
}
