package br.jus.tjse.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

//@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidarProcesso.ProcessoValidation.class })
public @interface ValidarProcesso {

	String message() default "Processo não válido!";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};

	public class ProcessoValidation implements ConstraintValidator<ValidarProcesso, String> {
		@Override
		public void initialize(final ValidarProcesso id) {
		}

		@Override
		public boolean isValid(final String id, ConstraintValidatorContext ctx) {
			return id.length() > 9;
		}
	}

}
