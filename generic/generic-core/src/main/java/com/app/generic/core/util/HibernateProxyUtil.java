package com.app.generic.core.util;


import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Component;

@Component
public class HibernateProxyUtil {
	
	@SuppressWarnings("unchecked")
	public static <M> M initializeAndUnproxy(M model) {
	    if (model == null) {
	        throw new 
	           NullPointerException("Entity passed for initialization is null");
	    }

	    Hibernate.initialize(model);
	    if (model instanceof HibernateProxy) {
	        model = (M) ((HibernateProxy) model).getHibernateLazyInitializer()
	                .getImplementation();
	    }
	    return model;
	}

}
