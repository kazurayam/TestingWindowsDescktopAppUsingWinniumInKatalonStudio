import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import java.io.InvalidObjectException
import java.net.MalformedURLException
import java.net.URL
import org.openqa.selenium.winium.DesktopOptions
import org.openqa.selenium.winium.WiniumDriver
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils

WiniumDriver driver = null

// setup:
DesktopOptions desktop = new DesktopOptions()
desktop.setApplicationPath("C:\\Windows\\System32\\notepad.exe")
try {
    driver = new WiniumDriver(new URL('http://localhost:9999'), desktop)
    //driver.manage().window().maximize() // https://github.com/2gis/Winium.Desktop/issues/199
} catch (MalformedURLException e) {
    e.printStackTrace()
}

// expect:
driver.findElementByClassName('Edit').sendKeys('6501 日立')

// take screenshot of the window and save the image into file
Path tmpDir = Paths.get(RunConfiguration.getProjectDir()).resolve('tmp')
Files.createDirectories(tmpDir)
Path output = tmpDir.resolve('screenshot1.png')
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
FileUtils.copyFile(scrFile, output.toFile())


// cleanup:
driver.close()
