package com.app.generic.service.validator;

/**
 * Every each validator interface must be extends on this class.
 * <br>for example:
 * 
 * <pre>
 * public interface xxxxSValidator extends BaseValidator<M>{
 * 	boolean checkAccountBalance(M model);
 * }
 * </pre>
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <M>
 */
public interface BaseValidator<M> {
	/**
	 * This method using for validate your Object
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param obj
	 * @return true or false
	 */
	boolean validate(M obj);
}
