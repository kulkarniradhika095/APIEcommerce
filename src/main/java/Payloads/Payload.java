package Payloads;

public class Payload {
	public static String orderPayload1(String country, String productId) {
		return "{\r\n"
				+ "    \"orders\": [\r\n"
				+ "        {\r\n"
				+ "            \"country\": \""+country+"\",\r\n"
				+ "            \"productOrderedId\": \""+productId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}
}
