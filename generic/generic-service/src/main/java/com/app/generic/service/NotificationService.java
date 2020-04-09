package com.app.generic.service;

/**
 * This interface is for AccountNotificationService, notification like sms, email, etc.
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 21, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <M> that declare object notification 
 */
public interface NotificationService<M> {
	/**
	 * Method for sending notification from Account
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 21, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param obj
	 * @return
	 */
	Object send(M obj);
}
