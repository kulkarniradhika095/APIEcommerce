package datadriven;


public class Environment {
	private static String filePath = "/src/main/java/Environment.properties";
	public static String baseUrl;
	public static String APIlogin;
	public static String APIAddProduct;
	public static String APIPlaceOrder;
	public static String APIDeleteProduct;
	public static String APIGetOrderDetails;
	public static String UserName;
	public static String PASSWORD;
	

	static {
		Prop prop = new Prop();
		String baseDirectory = System.getProperty("user.dir");
		baseUrl = prop.getValue(baseDirectory + filePath, "baseUrl");
		APIlogin = prop.getValue(baseDirectory + filePath, "APIlogin");
		APIAddProduct = prop.getValue(baseDirectory + filePath, "APIAddProduct");
		APIPlaceOrder = prop.getValue(baseDirectory + filePath, "APIPlaceOrder");
		APIDeleteProduct = prop.getValue(baseDirectory + filePath, "APIDeleteProduct");
		APIGetOrderDetails = prop.getValue(baseDirectory + filePath, "APIGetOrderDetails");
		UserName = prop.getValue(baseDirectory + filePath, "UserName");
		PASSWORD = prop.getValue(baseDirectory + filePath, "Password");
		
	}
}
