package com.guowl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cn.com.jit.ida.util.pki.encoders.Base64;

public class TestString {
	
	public static void main(String[] args) throws Exception{
		FileWriter f = new FileWriter("d:/1.txt");
		BufferedWriter w = new BufferedWriter(f);
		for (int i = 0; i < 1000; i++) {
			w.write(i + " ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
			w.write(System.lineSeparator());
		}
	}
	@Test
	public void getHex() {
		System.out.println(Long.toHexString(0));
	}

	@Test
	public void getString() {
		System.out.println(this.getString(1024 * 1024));
	}

	@Test
	public void testStrToBtye() {
		String str4k = getString(5000);
		// byte[] bs =str4k.getBytes();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 10000 * 600; i++) {
			byte[] bs = str4k.getBytes();
			new String(bs);
		}

		System.out.println(System.currentTimeMillis() - beginTime);
	}

	@Test
	public void testByte() throws Exception {
		System.out.println(Arrays.toString("9999".getBytes()));
		System.out.println(new String("999999999").getBytes());

		Object o = null;
		System.out.println((byte[]) o);

		System.out.println(new String(new byte[] { -71, -6, -61, -36, -65, -30, 86, 69, 82, 73, 70, 89, -76, -19, -50,
				-13 }, "gbk"));

	}

	@Test
	public void testLength() {
		String a = "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";
		System.out.println(a.length());
	}

	@Test
	public void base64Decoder() {
		String plainData = "MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdA==";
		String decoder = new String(Base64.decode(plainData));
		System.out.println(decoder.length());
		System.out.println(decoder);
	}

	@Test
	public void base64Encoder() {
		String plainData = "test";
		String encoder = new String(Base64.encode(plainData.getBytes()));
		System.out.println(encoder.length());
		System.out.println(encoder);
		System.out.println(Arrays.toString(Base64.encode(plainData.getBytes())));
	}

	@Test
	public void testSplit() {
		String a = "MemTotal:        8016676 kB";
		String[] b = a.split("\\s{1,}");
		System.out.println(b[1]);
	}

	private String getString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("s");
		}
		return sb.toString();
	}
	@Test
	public void testGetString(){
		System.out.println(getString(2048));
	}

	@Test
	public void getStrFile() {
		File f = new File("D:/1.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			String str = get10KStr(1024);
			fw.write(str);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static String get10KStr(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1024 * 10 * num; i++) {
			sb.append("s");
		}
		return sb.toString();
	}
}
