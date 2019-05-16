package util;

public class HtmlUtil {
	public static String sanitizing(String str) {

		if(null == str || "".equals(str)) {
			return str;
		}
		str = str.replaceAll("&","&amp;");
		str = str.replaceAll("<","&lt;");
		str = str.replaceAll(">","&gt;");
		str = str.replaceAll("\"","&quot;");
		str = str.replaceAll("&","&#39;");

		return str;
	}

}
