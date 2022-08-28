package configreader;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:my-properyiies.properties")
public interface FrameworkProperties extends Config {

    @Key("isRemote")
    boolean isRemote();

    @Key("url.rozetka")
    String getUrlRozetka();

    @Key("url.itunes")
    String getUrlITunes();
}
