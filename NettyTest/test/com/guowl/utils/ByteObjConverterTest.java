package com.guowl.utils;

import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;

public class ByteObjConverterTest {
	@Test
	public void testByteObjConvert() {
		TestObj obj = new TestObj();
		obj.setName("guowl");

		byte[] bytes = ByteObjConverter.ObjectToByte(obj);
		Assert.assertEquals(obj.toString(), ByteObjConverter.byteToObject(bytes).toString());
	}
}

class TestObj implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private String				name;

	public String toString() {
		return "name=" + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
