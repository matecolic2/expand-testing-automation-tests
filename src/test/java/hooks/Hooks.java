package hooks;

import Context.TestContext;
import io.cucumber.java.After;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @After
    public void tearDown() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}