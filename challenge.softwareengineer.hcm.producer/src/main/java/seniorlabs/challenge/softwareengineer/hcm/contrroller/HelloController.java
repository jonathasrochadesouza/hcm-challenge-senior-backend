package seniorlabs.challenge.softwareengineer.hcm.contrroller;

public class HelloController {

    public String hello(String name) {
        return String.format("Hello, %s", name);
    }

}
