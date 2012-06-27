package co.com.tactusoft.crm.security;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ExpiredExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory base;

	public ExpiredExceptionHandlerFactory(ExceptionHandlerFactory base) {
		this.base = base;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new ExpiredExceptionHandler(base.getExceptionHandler());
	}

}
