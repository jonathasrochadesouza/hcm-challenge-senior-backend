package seniorlabs.challenge.softwareengineer.hcm.contrroller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void helloOk() {
        HelloController controller = new HelloController();
        String response = controller.hello("World");
        assertEquals("Hello, World", response);
    }

    @Test
    void helloFails() {
        HelloController controller = new HelloController();
        String response = controller.hello("_World");
        assertNotEquals("Hello, World", response);
    }

}
