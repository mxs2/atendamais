import com.example.application.services.SamplePersonService;
import com.example.application.views.add.AddView;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest (classes = AddView.class)
@TestPropertySource(properties = {
        "application.views.mainlayout=enabled"
})
public class AddViewTest extends TestBenchTestCase {

    @MockBean
    private SamplePersonService samplePersonService;

    @BeforeEach
    public void setup() {
        // Setup WebDriver (using ChromeDriver for example)
        WebDriver webDriver = new ChromeDriver();
        setDriver(webDriver);

        // Navigate to the Site
        getDriver().get("http://localhost:8080");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void testFormSubmission() {
        String testCase = "Verificar se ao tentar abrir a pagina de adicionar sem estar logado é feito o" +
                " redirecionamento para a pagina de login";
        driver.navigate().to("http://localhost:8080/adicionar");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "http://localhost:8080/login";
        Assertions.assertEquals(expectedResult, actualResult, testCase);
    }
}