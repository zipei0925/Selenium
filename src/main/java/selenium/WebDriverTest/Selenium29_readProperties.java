package selenium.WebDriverTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Selenium29_readProperties {

    public static String browserName;
    public static String serverUrl;

    public static void main(String[] args) throws IOException {
        Properties ppt = new Properties();
        InputStream ips = new FileInputStream("config.properties");
        ppt.load(ips);

        browserName = ppt.getProperty("browserName");
        serverUrl = ppt.getProperty("serverUrl");

        System.out.println(browserName);
        System.out.println(serverUrl);

        ips.close();
    }
}
