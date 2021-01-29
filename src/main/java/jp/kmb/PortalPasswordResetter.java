package jp.kmb;

public class PortalPasswordResetter {

	private final static String browser_chrome = "chrome";
	private final static String browser_firefox = "firefox";
	private final static String browser_ie = "ie";
	private final static String browser_edge = "edge";

	public static void main(String args[]) {
		try {

			if (args[0].equals(browser_chrome)) {

				chromeDriverCheck.openchrome();

			} else if (args[0].equals(browser_firefox)) {

				firefoxDriverCheck.openff();

			} else if (args[0].equals(browser_ie)) {

				ie11DriverCheck.openie();

			} else if (args[0].equals(browser_edge)) {

				edgeDriverCheck.openEdge();

			} else {
				System.out.println("ex) java -jar xxx.jar [chrome | firefox | ie | edge]");
			}

		} catch (ArrayIndexOutOfBoundsException ae) {

			System.out.println("引数が指定されていません。ex) java -jar xxx.jar [chrome | firefox | ie | edge]");
			ae.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			//
		}
	}
}
