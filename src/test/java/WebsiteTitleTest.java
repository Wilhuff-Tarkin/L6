import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WebsiteTitleTest {

    private WebDriver driver;

    private final String siiPortalURL = "https://siiportal.sii.pl/";
    private final String onetURL = "https://www.onet.pl/";
    private final String kotuszkowoURL = "http://kotuszkowo.pl/";
    private final String filmwebURL = "https://www.filmweb.pl/";
    private final String seleniumDocsURL = "https://www.selenium.dev/documentation/en/webdriver/";

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Tag("SiiPortal")
    @Tag("Regression")
    @DisplayName("Sii portal")
    @ParameterizedTest
    @ValueSource(strings = {"Strona główna Bydgoszcz", "Strona główna Lublin"})
    void siiPortalTest(String expectedTitle) {
        driver.get(siiPortalURL);
        checkWebsiteTitle(expectedTitle);
    }

    @Tag("Onet")
    @Tag("Regression")
    @DisplayName("Onet.pl")
    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    void onetTest(String expectedTitle) {
        driver.get(onetURL);
        checkWebsiteTitle(expectedTitle);
    }

    @Tag("Kotuszkowo")
    @Tag("Regression")
    @DisplayName("Kotuszkowo blog")
    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    void kotuszkowoTest(String expectedTitle) {
        driver.get(kotuszkowoURL);
        checkWebsiteTitle(expectedTitle);
    }

    @Tag("Filmweb")
    @Tag("Regression")
    @DisplayName("Filmweb")
    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    void filmwebTest(String expectedTitle) {
        driver.get(filmwebURL);
        checkWebsiteTitle(expectedTitle);
    }

    @Tag("SeleniumDocs")
    @Tag("Regression")
    @DisplayName("Selenium documentation")
    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    void seleniumDocsTest(String expectedTitle) {
        driver.get(seleniumDocsURL);
        checkWebsiteTitle(expectedTitle);
    }

    public void checkWebsiteTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertThat("Title not as expected", actualTitle, equalTo(expectedTitle));
    }
}
