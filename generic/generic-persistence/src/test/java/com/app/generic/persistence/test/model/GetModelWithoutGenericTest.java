package com.app.generic.persistence.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.app.generic.persistence.enums.Status;
import com.app.generic.persistence.model.GenericModel;
import com.app.generic.persistence.util.ObjectUtil;

import lombok.Data;

public class GetModelWithoutGenericTest {

	@Test
	public void test01() {
		TestModel model =  new TestModel(1L, "Alim..", Status.LIVE);
		model = ObjectUtil.getModelWithoutBaseModel(model);
		assertEquals(model.getStatus(), null);
	}
	
	private class TestModel extends GenericModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long id;
		private String name;
		
		public TestModel(Long id, String name,Status status) {
			super();
			this.id = id;
			this.name = name;
			this.setStatus(status);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
