package com.app.generic.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

/**
 * @author muchamad.girinata
 *
 */
@Component
public class EncodingUtil {

	public static Object convertToObject(byte[] object) {
		Object result = new Object();
		try {
			ByteArrayInputStream baip = new ByteArrayInputStream(object);
			ObjectInputStream ois = new ObjectInputStream(baip);
			result = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static byte[] convertToByte(Object object) {
		byte[] result = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
