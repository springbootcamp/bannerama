# bannerama

instant spring boot application banners

Simply put, it turns this:

```java
@SpringBootApplication
public class ExampleApp {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ExampleApp.class);
    app.setBanner(Bannerama.builder()
      .title("The spring boot banner example app")
      .additionalVersion("Camunda Version", "7.12.0-ee")
      .build());

    app.run(args);
  }
}
```

```yaml
spring:
  application:
    name: bannerama-example
```

into this:

```text

  _                                                                                           _      
 | |__   __ _ _ __  _ __   ___ _ __ __ _ _ __ ___   __ _        _____  ____ _ _ __ ___  _ __ | | ___ 
 | '_ \ / _` | '_ \| '_ \ / _ \ '__/ _` | '_ ` _ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \
 | |_) | (_| | | | | | | |  __/ | | (_| | | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/
 |_.__/ \__,_|_| |_|_| |_|\___|_|  \__,_|_| |_| |_|\__,_|      \___/_/\_\__,_|_| |_| |_| .__/|_|\___|
                                                                                       |_|           
  :: The spring boot banner example app  ::

  > Application Version	= N/A
  > SpringBoot Version 	= N/A
  > Camunda Version	= 7.12.0-ee

```

without adding a custom `banner.txt` to the `resources` folder.

(`N/A` is caused by missing version info, see known issues #1 and #2)

## Links

* <https://github.com/dtmo/jfiglet>
* [Figlet Fonts](http://www.figlet.org/fontdb.cgi)
