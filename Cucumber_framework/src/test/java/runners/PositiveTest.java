package runners;




import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
        features = "C:\\Users\\Cyril.s\\Downloads\\Cucumber_framework\\Cucumber_framework\\src\\test\\resources\\FeatureFiles",
        glue = "steps",
        tags = {"@Search-Cars"}        
        )

public class PositiveTest  {
	@BeforeClass
    public static void setup() {
		
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String currentUsersHomeDir = System.getProperty("user.dir");
		System.out.println("Home Directory - "+currentUsersHomeDir);
		String fileName = currentUsersHomeDir+"\\ExtenReports\\Report" + strDate+".html";
		File newFile = new File(fileName);
		
       // ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("C:\\Users\\Cyril.s\\Downloads\\Cucumber_framework\\Cucumber_framework\\ExtenReports\\extentreports.html"),false);
       
		// Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "InternetExplorer");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }
	
}


