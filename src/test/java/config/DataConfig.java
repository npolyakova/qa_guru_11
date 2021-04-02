package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:data.properties")
public interface DataConfig extends Config {

    @Key("fio")
    String fio();

    @Key("phone")
    String phone();

    @Key("email")
    String email();

    @Key("city")
    String city();

}
