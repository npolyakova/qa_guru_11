package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebRemoteDriver() {
        // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(getWebConfig().remoteDriver(),
                getWebConfig().webRemoteDriverUser(),
                getWebConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return getWebConfig().videoStorage();
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}