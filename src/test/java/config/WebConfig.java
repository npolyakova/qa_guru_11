package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:web.properties")

public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();

    @Key("web.remote.driver")
    String remoteDriver();

    @Key("web.video.storage")
    String videoStorage();
}