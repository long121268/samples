package com.guowl.sign.http;

import java.util.HashMap;
import java.util.Map;

public class P7Envelop {
	public static void main(String[] args) throws Exception {
		// p7打信封 rsa
		 p7RSA_Envelop();

		// p7打信封 国密
//		p7GM_Envelop();

		// p7解信封 rsa
		 p7RSA_DecryptEnvelop();

		// p7解信封 国密
//		 p7GM_DecryptEnvelop();
	}

	private static void p7RSA_Envelop() {
		p7Envelop("rsa", "des3");
	}

	private static void p7GM_Envelop() {
		p7Envelop("sm2", "SM4");
	}

	/**
	 * p7打信封
	 */
	private static void p7Envelop(String alias, String encAlg) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("businessType", "P7Envelop");
			params.put("alias", alias);
			params.put("EncAlg", encAlg);
			params.put("Data_Format", "PlainData=2732");

			String data = "MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ1Njc4OTB0ZXN0MTIzNDU2Nzg5MHRlc3QxMjM0NTY3ODkwdGVzdDEyMzQ=";
			HttpClient client = new HttpClient();
			client.connect(ServerUrl.URI, data, params);
		} catch (Exception e) {}
	}

	/**
	 * p7解信封 rsa
	 * 
	 * @throws Exception
	 */
	private static void p7RSA_DecryptEnvelop() throws Exception {
		String data = "MIIBGAYJKoZIhvcNAQcDoIIBCTCCAQUCAQAxgdIwgc8CAQAwODAsMQ8wDQYDVQQDEwZEZW1vQ0ExDDAKBgNVBAoTA0pJVDELMAkGA1UEBhMCQ04CCEU1AjBegEd5MA0GCSqGSIb3DQEBAQUABIGAXgn5LD1uSNXVuWU0bjNoCR0/LZ5ZiS2Hp6/XD9rzfNuzyGnzkXyfU3TwAWtWpKaht9b4I68Os4us5liPimZDDqndAb0NgXZZShq/xWwRs6Z/dJHY5Gf6rMTYOODSGKIVBulgjVqzolCzbCDBrGhaS9GkMfDSLMai0VIDjdm49iswKwYJKoZIhvcNAQcBMBQGCCqGSIb3DQMHBAg+xfzJCRz5xIAIdjrF/hSvhlA=";
		System.out.println(data.length());
		p7DecryptEnvelop(data);
	}

	/**
	 * p7解信封 sm2
	 * 
	 * @throws Exception
	 */
	private static void p7GM_DecryptEnvelop() throws Exception {
		String data = "MIIBEgYKKoEcz1UGAQQCA6CCAQIwgf8CAQAxgc4wgcsCAQAwOzAvMQswCQYDVQQGEwJDTjEMMAoGA1UECgwDSklUMRIwEAYDVQQDDAlTTTJEZW1vQ0ECCHMtcXQp3MSWMAsGCSqBHM9VAYItAwR8MHoCIQDsgp2OfMTI9TWL//yMw2ZevQqcIowDJFITVkBkcZX2MQIhAOvQLVe4B7eplq+2CqwnQza59RFRkcXJBBv8mAfK8bQMBCBniUg2sjS15CA/lA02zoBrZ3lFxuuHR3sbAAUgEjNrIAQQ0VP0RmXXPhzdCHG6aYBfGTApBgoqgRzPVQYBBAIBMAkGByqBHM9VAWiAEACwSjWQUwG7BTKm/44HClM=";
		p7DecryptEnvelop(data);
	}

	private static void p7DecryptEnvelop(String data) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("businessType", "P7DectyptEnvelop");
		params.put("Data_Format", "EnvelopData=" + data.length());
		
		HttpClient client = new HttpClient();
		client.connect(ServerUrl.URI, data, params);
	}
}