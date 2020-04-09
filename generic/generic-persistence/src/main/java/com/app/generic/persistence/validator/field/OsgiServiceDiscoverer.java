package com.app.generic.persistence.validator.field;

import java.util.Collections;
import java.util.List;

import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;

import org.hibernate.validator.HibernateValidator;


/**
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
public class OsgiServiceDiscoverer implements ValidationProviderResolver{

	@Override
	public List<ValidationProvider<?>> getValidationProviders() {
		return Collections.<ValidationProvider<?>>singletonList( 
        		new HibernateValidator());
	}
}
