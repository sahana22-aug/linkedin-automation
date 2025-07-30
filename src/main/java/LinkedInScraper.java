import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedInScraper {

    public static void main(String[] args) {

        // 1. Set path to ChromeDriver (make sure this path is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        // 2. Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // 3. Open LinkedIn login page
            driver.get("https://www.linkedin.com/login");

            // 4. Login using credentials
            driver.findElement(By.id("username")).sendKeys("sahananidhi2002@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Sahana@123_123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // 5. Wait to ensure login completes
            Thread.sleep(5000);

            // 6. Create CSV writer
            FileWriter writer = new FileWriter("output.csv");
            writer.append("Page,Name,JobTitle\n");

            // 7. Loop through 100 pages of search results
            for (int page = 1; page <= 100; page++) {
                System.out.println("🔍 Scraping page: " + page);
                System.out.println("──────────────────────────────────────────");

                String url = "https://www.linkedin.com/search/results/people/?keywords=hospitals&page=" + page;
                driver.get(url);

                // Allow results to load
                Thread.sleep(5000);

                // Get all people cards on the page
                List<WebElement> resultCards = driver.findElements(By.cssSelector(".reusable-search__result-container"));

                int count = 1;
                for (WebElement card : resultCards) {
                    try {
                        WebElement nameElement = card.findElement(By.cssSelector("span.entity-result__title-text > a > span[aria-hidden='true']"));
                        String name = nameElement.getText().trim();

                        WebElement titleElement = card.findElement(By.cssSelector("div.entity-result__primary-subtitle"));
                        String title = titleElement.getText().trim();

                        // Print nicely formatted output to console
                        System.out.println(count + ". " + name + " - " + title);
                        count++;

                        // Save to CSV
                        writer.append("Page ").append(String.valueOf(page)).append(",")
                              .append(name).append(",").append(title).append("\n");

                    } catch (Exception e) {
                        System.out.println("⚠️ Skipped one card (missing element)");
                    }
                }

                System.out.println("✅ Finished page " + page);
                System.out.println("──────────────────────────────────────────\n");

                // Wait before next page to reduce bot detection
                Thread.sleep(3000);
            }

            // Finalize CSV
            writer.flush();
            writer.close();
            System.out.println("✅ All data saved to output.csv");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
