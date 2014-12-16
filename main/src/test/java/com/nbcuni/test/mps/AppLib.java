package com.nbcuni.test.mps;

import static org.testng.AssertJUnit.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.base.Splitter;
import com.nbcuni.test.lib.Util;
import com.nbcuni.test.webdriver.CaptureNetworkTraffic;
import com.nbcuni.test.webdriver.CustomWebDriver;
import com.nbcuni.test.webdriver.CustomWebDriverException;
import com.nbcuni.test.webdriver.CustomWebDriverExceptionListener;
import com.nbcuni.test.webdriver.PropertyList;

// TODO: Auto-generated Javadoc
/**************************************************************************
 * MPS Application Library. Copyright
 * 
 * @author Robert Picazo
 * @version 1.0 Date: February 13, 2014
 **************************************************************************/

public class AppLib {

    /** The Constant FOUR_ZERO_FOUR. */
    private static final int FOUR_ZERO_FOUR = 404;

    /** The Constant TWO_ZERO_ZERO. */
    private static final int TWO_ZERO_ZERO = 200;

    /** The cs. */
    private static CustomWebDriver cs = null;

    /** The ul. */
    private Util ul = null;

    /** The wait. */
    private WebDriverWait wait;

    /** The environment. */
    private String environment = "";

    /** The site. */
    private String site = "";

    /** The mps url. */
    private String mpsUrl = "";

    /** The mps user administrator. */
    private String mpsUserAdministrator = "";

    /** The mps password administrator. */
    private String mpsPasswordAdministrator = "";

    /** The mps user limited. */
    private String mpsUserLimited = "";

    /** The mps password limited. */
    private String mpsPasswordLimited = "";

    /** The proxy url. */
    private String proxyUrl = "";

    /** The proxy port. */
    private Integer proxyPort = 0;

    /** The api url. */
    private String apiUrl = "";

    /** The client url. */
    private String clientUrl = "";
    
    /** The perf api url. */
    private String perfApiUrl = "";

    /** The config file name. */
    private static String configFileName = "target/test-classes/config.properties";

    /** The config properties. */
    private static PropertyList configProperties = null;

    /** The is config loaded. */
    private static boolean isConfigLoaded = false;

    /** The Constant FOR_RANDOM_PACKAGE. */
    public static final int FOR_RANDOM_PACKAGE = 10000000;

    /** The Constant WEB_DRIVER_WAIT. */
    public static final int WEB_DRIVER_WAIT = 15;

    /** The gitversion. */
    private String gitversion = "";

    /**
     * Instantiates a new app lib.
     * 
     * @param cs1 Custom Webdriver
     */
    public AppLib(CustomWebDriver cs1) {
        cs = cs1;
        ul = new Util(cs);
        wait = new WebDriverWait(cs, WEB_DRIVER_WAIT);
        try {
            loadConfig();
        } catch (Exception e) {
            new CustomWebDriverException(e, cs);
        }
    }

    /**
     * Instantiates a new app lib.
     * 
     * @throws Exception the exception
     */
    public AppLib() throws Exception {
        loadConfig();
    }

    /**
     * loads config file.
     */
    private void loadConfig() {
        try {
            if (!isConfigLoaded) {
                final URI propsFile = new File(configFileName).toURI();
                configProperties = new PropertyList();
                if (propsFile != null) {
                    if (propsFile.toString().endsWith(".properties")) {
                        try {
                            configProperties.load(propsFile);
                        } catch (IOException e) {
                            Reporter.log(e.toString());
                        }
                    }
                }
            }
        } catch (Exception e) {
            new CustomWebDriverException(e, cs);
        }
    }

    /**
     * gets env.
     */
    private void setEnvironmentFromConfig() {
        try {
            mpsUrl = configProperties.get(environment + ".Site.Url");
            mpsUserAdministrator = configProperties.get(environment + ".Site.Userid");
            mpsPasswordAdministrator = configProperties.get(environment + ".Site.Password");
            mpsUserLimited = configProperties.get(environment + ".Site.UseridLimited");
            mpsPasswordLimited = configProperties.get(environment + ".Site.PasswordLimited");
            proxyUrl = configProperties.get(environment + ".ProxyURL");
            proxyPort = Integer.valueOf(configProperties.get(environment + ".ProxyPort"));
            apiUrl = configProperties.get(environment + ".API.Url");
            clientUrl = configProperties.get(environment + ".Client.Url");
            perfApiUrl = configProperties.get("PERF" + ".API.Url");
        } catch (Exception e) {
            new CustomWebDriverException(e, cs);
        }
    }

    /**
     * Returns the API URL.
     * 
     * @return Return value api URL
     * @throws Exception Code Error
     */
    public final String getApiURL() throws Exception {
        return this.apiUrl;
    }

    /**
     * Returns the Client URL.
     * 
     * @return Return value client URL
     * @throws Exception Code Error
     */
    public final String getClientURL() throws Exception {
        return this.clientUrl;
    }

    /**
     * Returns the mps site URL.
     * 
     * @return Return value site URL
     * @throws Exception Code Error
     */
    public final String getSiteURL() throws Exception {
        return this.mpsUrl;
    }

    /**
     * Gets the administrator user name.
     * 
     * @return the administrator user name
     * @throws Exception the exception
     */
    public final String getAdministratorUserName() throws Exception {
        return this.mpsUserAdministrator;
    }

    /**
     * Gets the administrator user password.
     * 
     * @return the administrator user password
     * @throws Exception the exception
     */
    public final String getAdministratorUserPassword() throws Exception {
        return this.mpsPasswordAdministrator;
    }

    /**
     * Gets the limited user name.
     * 
     * @return the limited user name
     * @throws Exception the exception
     */
    public final String getLimitedUserName() throws Exception {
        return this.mpsUserLimited;
    }

    /**
     * Gets the limited user password.
     * 
     * @return the limited user password
     * @throws Exception the exception
     */
    public final String getLimitedUserPassword() throws Exception {
        return this.mpsPasswordLimited;
    }

    /**
     * Gets the current date time.
     *
     * @return the current date time
     * @throws Exception the exception
     */
    public String getCurrentDateTime() throws Exception {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z");
        df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        String pst = df.format(today);
        return pst;
    }

    /**
     * Log execution info.
     *
     * @throws Exception the exception
     */
    public void logExecutionInfo() throws Exception {
        Reporter.log("***************************************");
        Reporter.log("TEST EXECUTION INFO");
        Reporter.log("Date/Time: " + getCurrentDateTime());
        Reporter.log("Environment: " + getEnvironment());
        Reporter.log("GIT Version: " + getAppVersion());
        Reporter.log("MPS Site: " + getSiteName());
        Reporter.log("Browser: " + getBrowserUserAgentString());
        Reporter.log("***************************************");
    }

    /**
     * Opens the browser with mps Site url.
     * 
     * @return Return value
     * @throws Exception Code Error
     */
    public Homepage openSite() throws Exception {
        maximizeBrowser();
        logExecutionInfo();
        verifyHTTPResponseCode(this.getSiteURL());
        cs.openURL(this.getSiteURL());
        Reporter.log("MPS URL: " + this.getSiteURL());
        Thread.sleep(3000);
        return new Homepage(cs, this);
    }

    /**
     * Open local html file.
     * 
     * @param fileName the file name
     * @throws Exception the exception
     */
    public void openLocalHtmlFile(String fileName) throws Exception {
        maximizeBrowser();
        final URI file = new File(fileName).toURI();
        Reporter.log("Opened local web file: " + file);
        cs.openURL(file.toString().replace("file:/", "file://"));
        Thread.sleep(3000);
    }

    /**
     * Creates the local test html file.
     * 
     * @param filePathAndName the file path and name
     * @throws Exception the exception
     */
    public void createLocalTestHtmlFile(String filePathAndName) throws Exception {
        File file = new File(filePathAndName);
        file.createNewFile();
        Reporter.log("Created local file: " + filePathAndName);
    }

    /**
     * Write html code from page to file.
     * 
     * @param url the url
     * @param filePathAndName the file path and name
     * @throws Exception the exception
     */
    public void writeHTMLCodeFromPageToFile(String url, String filePathAndName) throws Exception {
        File fout = new File(filePathAndName);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        URL testUrl = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(testUrl.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            bw.write(inputLine);
            bw.newLine();
        }
        in.close();
        bw.close();
        Reporter.log("Added MPS loader to local file: " + filePathAndName);
    }

    /**
     * Opens the browser with mps client url.
     *
     * @param url the url
     * @throws Exception Code Error
     */
    public void openClientPage(String url) throws Exception {
        maximizeBrowser();
        logExecutionInfo();
        verifyHTTPResponseCode(url);
        cs.openURL(url);
        Reporter.log("**************************************************");
        Reporter.log("Opened Client URL: " + url);
        Reporter.log(" ");
        Thread.sleep(5000);
        if (closePopupWindowIfExists(cs)) {
            fail("FAIL: unexpected popup dialog while opening the client page");
        }
    }

    /**
     * Gets the http proxy.
     * 
     * @return the http proxy
     */
    public Proxy getHttpProxy() {
        SocketAddress addr = new InetSocketAddress(this.proxyUrl, this.proxyPort);
        Proxy httpProxy = new Proxy(Proxy.Type.HTTP, addr);
        return httpProxy;
    }

    /**
     * Gets the environment.
     * 
     * @return environment being tested
     * @throws Exception Code Error
     */
    public final String getEnvironment() throws Exception {
        return this.environment;
    }

    /**
     * Sets the environment info.
     * 
     * @param sEnv environment
     * @param sSite site
     * @throws Exception Code Error
     */
    public final void setEnvironmentInfo(String sEnv, String sSite) throws Exception {
        Reporter.log("Environment: " + sEnv);
        this.environment = sEnv;

        Reporter.log("Site: " + sSite);
        this.site = sSite;

        this.setEnvironmentFromConfig();
        this.setAppVersion();
        this.setTestNGAttributes();
    }

    /**
     * Gets the site name.
     * 
     * @return site name being tested
     * @throws Exception Code Error
     */
    public final String getSiteName() throws Exception {
        return this.site;
    }

    /**
     * Sets the site name.
     *
     * @param siteName the new site name
     * @throws Exception the exception
     */
    public void setSiteName(String siteName) throws Exception {
        this.site = siteName;
        Reporter.log("Site was set to: " + siteName);
    }

    /**
     * Show errors.
     * 
     * @param err errors
     * @throws Exception Code Error
     */
    public final void showErrors(ArrayList<String> err) throws Exception {
        String tempErr = "";
        if (!err.isEmpty()) {
            for (String xxx : err) {
                tempErr = tempErr + "\n" + xxx;
                Reporter.log(xxx);
            }
            fail(tempErr);
        }
    }

    /**
     * .
     * Validates the page title
     * 
     * @param sPagename Page name
     * @throws Exception Code Error
     */
    public final void validateCorrectPageDisplay(String sPagename) throws Exception {
        String sPage = cs.getTitle();
        ul.compareTextValues(sPage, sPagename);
    }

    /**
     * This method will attain all links on the page and
     * perform a HTTP response verification on the page
     * ensuring that it does not return a error.
     * 
     * @throws Exception - error
     */
    public final void verifyHtttpResponseForAllLinksOnPage() throws Exception {
        ArrayList<String> rawLinks = cs.getAllLinksOnPage();
        for (String xxx : rawLinks) {
            if (xxx.startsWith("http:")) {
                URL url = new URL(xxx.trim());
                Reporter.log("URL: " + url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int code = connection.getResponseCode();
                if ((code == FOUR_ZERO_FOUR)) {
                    fail("Response Code incorrect");
                }
            }
            if (xxx.startsWith("/")) {
                String baseLocation = cs.getLocation();
                String baseURL = baseLocation.replace("com/", "com");
                String rawLinks2 = baseURL + xxx;
                URL url = new URL(rawLinks2.trim());
                Reporter.log("URL: " + url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int code = connection.getResponseCode();
                if ((code == FOUR_ZERO_FOUR)) {
                    fail("Response Code incorrect");
                }
            }
        }
    }

    /**
     * Maximizes browser window.
     */
    public void maximizeBrowser() {
        cs.manage().window().maximize();
    }

    /**
     * Selecting an open window based on window title.
     * 
     * @param custWebDr - web driver
     * @param strWinTitle - String
     */
    public final void selectAppWindow(CustomWebDriver custWebDr, final String strWinTitle) {
        try {
            final Set<String> windows = custWebDr.getWindowHandles();
            for (String win : windows) {
                if (custWebDr.switchTo().window(win).getTitle().toLowerCase().contains(strWinTitle.toLowerCase())) {
                    custWebDr.switchTo().window(win);
                    custWebDr.switchTo().defaultContent();
                    Reporter.log("Switched to window " + strWinTitle);
                    break;
                }
            }
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    /**
     * Closes popup windows sending accept command if it exists.
     * 
     * @param webDriver - webdriver
     * @return if pop up window was closed
     */
    public Boolean closePopupWindowIfExists(CustomWebDriver webDriver) {
        String message = "";
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            message = alert.getText();
            alert.accept();
            Reporter.log("Closed popup window with message '" + message + "'");
        } catch (Exception e) {
            Reporter.log("No popup window exists");
            return false;
        }
        webDriver.switchTo().defaultContent();
        return true;
    }

    /**
     * Refresh the browser.
     * 
     * @throws Exception the exception
     */
    public void refreshBrowser() throws Exception {
        cs.navigate().refresh();
        Reporter.log("Browser refreshed");
    }

    /**
     * Sets the browser to specific dimensions.
     * 
     * @param width the width
     * @param height the height
     * @throws Exception the exception
     */
    public void setBrowserSize(int width, int height) throws Exception {
        cs.manage().window().setPosition(new Point(0, 0));
        cs.manage().window().setSize(new Dimension(width, height));
        Reporter.log("Resized browser window to " + width + "x" + height);
    }

    /**
     * Scrolls the browser window to top page.
     * 
     * @throws Exception the exception
     */
    public void scrollToTopOfPage() throws Exception {
        JavascriptExecutor js = cs;
        js.executeScript("document.location = \"#\";");
        Reporter.log("Scrolled to object top of page on " + cs.getCurrentUrl());
    }

    /**
     * Scrolls the browser window to the element for visibility.
     * 
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void scrollToElementOnPage(String xpath) throws Exception {
        Locatable element = (Locatable) cs.findElementByXPath(xpath);
        Point p = element.getCoordinates().onPage();
        JavascriptExecutor js = cs;
        js.executeScript("window.scrollTo(" + p.getX() + "," + (p.getY()) + ");");
        Reporter.log("Scrolled to object " + xpath + " on " + cs.getCurrentUrl());
    }

    /**
     * Scrolls the browser window by x y coordinates.
     * 
     * @param x - horizontal position
     * @param y - vertical position
     * @throws Exception the exception
     */
    public void scrollToElementOnPage(int x, int y) throws Exception {
        JavascriptExecutor js = cs;
        js.executeScript("window.scrollTo(" + x + "," + y + ");");
    }

    /**
     * Navigates to the specified URL.
     * 
     * @param url the url
     */
    public void navigateToURL(String url) {
        cs.navigate().to(url);
        Reporter.log("Navigated to " + url);
    }

    /**
     * Switches web driver to the specified window.
     * 
     * @param windowTitle - text from title bar
     * @throws Exception the exception
     */
    public void switchToWindow(String windowTitle) throws Exception {
        Set<String> windows = cs.getWindowHandles();
        boolean found = false;
        for (String window : windows) {
            cs.switchTo().window(window);
            if (cs.getTitle().toLowerCase().contains(windowTitle)) {
                Reporter.log("Switched to the window with title " + windowTitle);
                found = true;
                break;
            }
        }
        if (!found) {
            fail("Fail - window with title " + windowTitle + " was not found");
        }
    }

    /**
     * Switch to window.
     * 
     * @throws Exception the exception
     */
    public void switchToWindow() throws Exception {
        // Switch to new window opened
        for (String winHandle : cs.getWindowHandles()) {
            cs.switchTo().window(winHandle);
        }
        Reporter.log("Switched to the window with title " + cs.getTitle() + " and URL " + cs.getLocation());
    }

    /**
     * Wait for object.
     * 
     * @param xpath the xpath
     * @param timeoutInSec the timeout in sec
     * @return true, if successful
     * @throws Exception the exception
     */
    public boolean waitForObject(String xpath, int timeoutInSec) throws Exception {
        boolean found = false;
        for (int i = 0; i < timeoutInSec; i++) {
            int count = cs.findElementsByXPath(xpath).size();
            if (count > 0) {
                found = true;
                break;
            }
            Thread.sleep(2000);
        }
        return found;
    }

    /**
     * Wait for all ajax calls.
     * 
     * @param secondsTimeout the seconds timeout
     * @throws Exception the exception
     */
    static void waitForAllAjaxCalls(int secondsTimeout) throws Exception {
        JavascriptExecutor js = cs;
        int count = 1;
        while (true) {
            Boolean ajaxIsComplete = (Boolean) js.executeScript("return jQuery.active == 0");
            System.out.println("Ajax running: " + ajaxIsComplete);
            if (ajaxIsComplete || secondsTimeout == count) {
                break;
            }
            Thread.sleep(500);
            count = count++;
        }
    }

    /**
     * Removes the domain from url.
     * 
     * @param url the url
     * @return the string
     * @throws Exception the exception
     */
    public String removeDomainFromURL(String url) throws Exception {
        String domain = url.substring(0, url.lastIndexOf("com/") + 4);
        return url.replace(domain, "");
    }

    /**
     * Scroll down to object.
     * 
     * @param xpath the xpath
     * @param timeoutInSec the timeout in sec
     * @return true, if successful
     * @throws Exception the exception
     */
    public boolean scrollDownToObject(String xpath, int timeoutInSec) throws Exception {
        boolean found = false;
        for (int i = 0; i < timeoutInSec; i++) {
            JavascriptExecutor js = cs;
            js.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            int count = cs.findElementsByXPath(xpath).size();
            if (count > 0) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Gets the random number.
     * 
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     * @return the random number
     * @throws Exception the exception
     */
    public int getRandomNumber(int lowerBound, int upperBound) throws Exception {
        Random random = new Random();
        int pickedNumber = 0;
        if (lowerBound == 0 && upperBound > 1) {
            upperBound = upperBound - 1;
            pickedNumber = random.nextInt(upperBound) + lowerBound;
        } else if (lowerBound == 1 && upperBound > 1) {
            pickedNumber = random.nextInt(upperBound) + lowerBound;
        } else if (lowerBound == 0 && upperBound == 1) {
            pickedNumber = 0;
        } else if (lowerBound == 1 && upperBound == 1) {
            pickedNumber = 1;
        }
        return pickedNumber;
    }

    /**
     * Gets the component info.
     * 
     * @param component the component
     * @param attribute the attribute
     * @return the component info
     * @throws Exception the exception
     */
    public String getComponentInfo(String component, String attribute) throws Exception {
        String returnValue = "";
        if (component.contains("[")) {
            if (attribute.equalsIgnoreCase("serviceid")) {
                returnValue = component.substring(component.indexOf("[") + 1, component.indexOf("]"));
            } else {
                returnValue = component.substring(component.indexOf("]")).replace("]", "").trim();
            }
        } else {
            returnValue = component;
        }
        return returnValue;
    }

    /**
     * Accept popup window.
     * 
     * @param webDriver the web driver
     */
    public final void acceptPopupWindow(CustomWebDriver webDriver) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            Reporter.log("Accepted popup window - " + alert.getText());
            alert.accept();
            Reporter.log("After accept pop up");
        } catch (Exception e) {
            Reporter.log("No popup window displayed");
        }
    }

    /**
     * Parses the data.
     * 
     * @param data the data
     * @param parse the parse
     * @return the string[]
     * @throws Exception the exception
     */
    public String[] parseData(String data, String parse) throws Exception {
        String[] arrData = data.split(parse);
        return arrData;
    }

    /**
     * Map free wheel data.
     * 
     * @param globalFWVars the global fw vars
     * @param pageFWValues the page fw values
     * @return the hash map
     * @throws Exception the exception
     */
    public HashMap<String, String> mapFreeWheelData(String globalFWVars, String pageFWValues) throws Exception {
        String[] globalVars = parseData(globalFWVars, ",");
        pageFWValues = pageFWValues.replace(",", ",|");
        String[] pageValue = parseData(pageFWValues, ",");
        if (globalVars.length != pageValue.length) {
            fail("Fail: invalid number of freewheel data and variable items. GlobalDefauls: " + globalFWVars
                    + " Page values: " + pageFWValues);
        }
        HashMap<String, String> data = new HashMap<String, String>();
        for (int i = 0; i < pageValue.length; i++) {
            data.put(globalVars[i].trim(), pageValue[i].replace("|", "").trim());
        }
        return data;
    }

    /**
     * Gets the random id number.
     * 
     * @return the random id number
     * @throws Exception the exception
     */
    public String getRandomIdNumber() throws Exception {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MMdd");
        Date date = new Date();
        String id =
                "-" + dateFormat.format(date) + "-" + cal.get(Calendar.SECOND) + cal.get(Calendar.MINUTE)
                        + cal.get(Calendar.MILLISECOND);
        return id;
    }

    /**
     * Gets the random package id number.
     * 
     * @return the random package id number
     * @throws Exception the exception
     */
    public String getRandomPackageIdNumber() throws Exception {
        int num = (int) Math.round(Math.random() * FOR_RANDOM_PACKAGE);
        String pkgId = String.valueOf(num);
        return pkgId;
    }

    /**
     * Construct expected free wheel entry.
     * 
     * @param globalDefaultFWEntry the global default fw entry
     * @param data the data
     * @return the string
     * @throws Exception the exception
     */
    public String constructExpectedFreeWheelEntry(String globalDefaultFWEntry, HashMap<String, String> data)
            throws Exception {
        String[] gdEntry = parseData(globalDefaultFWEntry, ",");
        String fwValues = "";
        for (int i = 0; i < gdEntry.length; i++) {
            if (i == gdEntry.length - 1) {
                fwValues = fwValues + data.get(gdEntry[i].trim());
            } else {
                fwValues = fwValues + data.get(gdEntry[i].trim()) + ",";
            }
        }
        return fwValues;
    }

    /**
     * Click modify button if exists.
     * 
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void clickModifyButtonIfExists(String xpath) throws Exception {
        int count = cs.findElementsByXPath(xpath).size();
        if (count == 1) {
            cs.click(xpath);
            Reporter.log("Clicked on Modify button");
        }
    }

    /**
     * Type text in text area object.
     * 
     * @param xpath the xpath
     * @param text the text
     * @throws Exception the exception
     */
    public void typeTextInTextAreaObject(String xpath, String text) throws Exception {
        WebElement textArea = cs.findElement(By.xpath(xpath));
        textArea.sendKeys(text);
    }

    /**
     * Executes client command variables.
     * 
     * @param jsCommand example: mps._adloads[0]."+adUnit+".size.toString()
     * @return the value using java script
     * @throws Exception the exception
     */
    public String getValueUsingJavaScript(String jsCommand) throws Exception {
        JavascriptExecutor js = cs;
        String value = "";
        try {
            value = js.executeScript(jsCommand).toString();
        } catch (Exception e) {
            value = "";
        }
        if (containsHTML(value)) {
            Reporter.log("Executed JavaScript command [" + jsCommand + "] = value returned ["
                    + wrapHTMLCodeWithXMPTag(value) + "]");
        } else {
            Reporter.log("Executed JavaScript command [" + jsCommand + "] = value returned [" + value + "]");
        }
        Reporter.log(" ");
        return value;
    }

    /**
     * Contains html.
     * 
     * @param input the input
     * @return true, if successful
     * @throws Exception the exception
     */
    public boolean containsHTML(String input) throws Exception {
        return input.matches(".*\\<[^>]+>.*");
    }

    /**
     * Execute java script.
     * 
     * @param jsCommand the js command
     * @throws Exception the exception
     */
    public void executeJavaScript(String jsCommand) throws Exception {
        JavascriptExecutor js = cs;
        js.executeScript(jsCommand);
        Reporter.log(" ");
        Reporter.log("Executed JavaScript command [" + jsCommand + "]");
        Reporter.log(" ");
    }

    /**
     * Splits a string value into key values.
     * 
     * @param data - string text
     * @param delimiter - creates array
     * @param keySeparator - key value separator
     * @return map of key values
     * @throws Exception the exception
     */
    public Map<String, String> splitToMap(String data, String delimiter, String keySeparator) throws Exception {
        return Splitter.on(delimiter).withKeyValueSeparator(keySeparator).split(data);
    }

    /**
     * Removes the white spaces from string.
     * 
     * @param data the data
     * @return the string
     */
    public String removeWhiteSpacesFromString(String data) {
        return data.replaceAll(" ", "");
    }

    /**
     * Removes the brackets from string.
     * 
     * @param data the data
     * @return the string
     */
    public String removeBracketsFromString(String data) {
        String regex = "\\[|\\]|\\{|\\}";
        return data.replaceAll(regex, "");
    }

    /**
     * Gets the browser user agent string.
     * 
     * @return the browser user agent string
     */
    public String getBrowserUserAgentString() {
        String s = (String) ((JavascriptExecutor) cs).executeScript("return navigator.userAgent;");
        return s;
    }

    /**
     * Wrap html code with xmp tag.
     * 
     * @param code the code
     * @return the string
     * @throws Exception the exception
     */
    public String wrapHTMLCodeWithXMPTag(String code) throws Exception {
        code = "<xmp>" + code + "</xmp>";
        return code;
    }

    /**
     * Find duplicate gpt names.
     * 
     * @param adUnitData the ad unit data
     * @return the hash map
     * @throws Exception the exception
     */
    public HashMap<String, ArrayList<String>> findDuplicateGptNames(ArrayList<HashMap<String, String>> adUnitData)
            throws Exception {
        ArrayList<String> duplicateGpt = new ArrayList<String>();
        HashMap<String, ArrayList<String>> duplicateNames = new HashMap<String, ArrayList<String>>();
        ArrayList<String> singles = new ArrayList<String>();
        for (HashMap<String, String> hm : adUnitData) {
            String gptName = hm.get("gpt");
            if (!singles.contains(gptName)) {
                singles.add(gptName);
            } else {
                if (!duplicateGpt.contains(gptName)) {
                    duplicateGpt.add(gptName);
                }
            }
        }
        for (HashMap<String, String> hm : adUnitData) {
            String gptName = hm.get("gpt");
            if (duplicateGpt.contains(gptName)) {
                if (duplicateNames.containsKey(gptName)) {
                    duplicateNames.get(gptName).add(hm.get("name"));
                    Reporter.log("added dupe: " + duplicateNames.get(gptName).get(1));
                } else {
                    ArrayList<String> value = new ArrayList<String>();
                    value.add(hm.get("name"));
                    duplicateNames.put(gptName, value);
                    Reporter.log("added dupe: " + duplicateNames.get(gptName).get(0));
                }
            }
        }
        return duplicateNames;
    }

    /**
     * Gets the URL from network traffic.
     * 
     * @param domain the domain
     * @return the URL from network traffic
     * @throws Exception the exception
     */
    public ArrayList<String> getURLFromNetworkTraffic(String domain) throws Exception {
        ArrayList<String> urlList = new ArrayList<String>();
        Reporter.log("get url from network traffic for " + domain);
        ArrayList<HashMap<String, String>> tempHar = cs.getHarInfoByDomain(domain);
        for (HashMap<String, String> x : tempHar) {
            CaptureNetworkTraffic.getInstance();
            Reporter.log("\nRequest URL: " + x.get(CaptureNetworkTraffic.REQUEST_URL));
            Reporter.log("");
            urlList.add(x.get(CaptureNetworkTraffic.REQUEST_URL));
        }
        return urlList;
    }

    /**
     * Decode url.
     * 
     * @param inputURL the input url
     * @return the string
     * @throws Exception the exception
     */
    public String decodeURL(String inputURL) throws Exception {
        Reporter.log("HTML Decoding URL");
        return java.net.URLDecoder.decode(inputURL, "UTF-8");
    }

    /**
     * Sets the test ng attributes.
     * 
     * @throws Exception the exception
     */
    public void setTestNGAttributes() throws Exception {
        CustomWebDriverExceptionListener.setAppVersion(getAppVersion());
        CustomWebDriverExceptionListener.setEnvironment(getEnvironment());
    }

    /**
     * Gets the app version.
     * 
     * @return the app version
     * @throws Exception the exception
     */
    private String getAppVersion() throws Exception {
        if (gitversion.length() == 0) {
            setAppVersion();
        }
        return gitversion;
    }

    /**
     * Sets the app version.
     *
     * @throws Exception the exception
     */
    private void setAppVersion() throws Exception {
        String version = "";
        String url = "/healthcheck.php";
        URLConnection connection = new URL(getSiteURL() + url).openConnection();
        connection.setRequestProperty("Accept-Charset", "text/html; charset=UTF-8");
        InputStream response = connection.getInputStream();
        String body = IOUtils.toString(response);
        version = body.substring(body.indexOf("SCM_VERSION"));
        version = version.substring(0, version.indexOf("[")).replace("SCM_VERSION]", "");
        gitversion = version.trim();
    }

    /**
     * Gets the page url.
     * 
     * @param destroy the destroy
     * @return the page url
     * @throws Exception the exception
     */
    public String getPageURL(boolean destroy) throws Exception {
        String currentURL = cs.getCurrentUrl();
        String pageURL = currentURL.replace(getSiteURL(), "");
        if (destroy) {
            pageURL = pageURL.replace("modify", "destroy");
        }
        return pageURL;
    }

    /**
     * Gets the formatted date.
     * 
     * @return the formatted date
     * @throws Exception the exception
     */
    public String getFormattedDate() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        Reporter.log("Formatted today's date: " + today);
        return today;
    }

    /**
     * Gets the tomorrows date.
     * 
     * @return the tomorrows date
     * @throws Exception the exception
     */
    public String getTomorrowsDate() throws Exception {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        date = cal.getTime();
        String tom = dateFormat.format(date);
        Reporter.log("Formatted tomorrow's date: " + tom);
        return tom;
    }

    /**
     * Gets the time now.
     * 
     * @return the time now
     * @throws Exception the exception
     */
    public String getTimeNow() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mma");
        String now = sdf.format(cal.getTime());
        Reporter.log("Got time now: " + now);
        return now;
    }

    /**
     * Enter live date.
     * 
     * @param date the date
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void enterLiveDate(String date, String xpath) throws Exception {
        if (date.isEmpty()) {
            String today = getFormattedDate();
            cs.type(xpath, today);
            Reporter.log("Typed live date: " + today);
        } else {
            cs.type(xpath, date);
            Reporter.log("Typed live date: " + date);
        }
    }

    /**
     * Enter live time.
     * 
     * @param time the time
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void enterLiveTime(String time, String xpath) throws Exception {
        if (time.isEmpty()) {
            String now = getTimeNow();
            cs.type(xpath, now);
            Reporter.log("Typed live time: " + now);
        } else {
            cs.type(xpath, time);
            Reporter.log("Typed live time: " + time);
        }
    }

    /**
     * Enter hide date.
     * 
     * @param date the date
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void enterHideDate(String date, String xpath) throws Exception {
        if (date.isEmpty()) {
            String tomorrow = getTomorrowsDate();
            cs.type(xpath, tomorrow);
            Reporter.log("Typed hide date: " + tomorrow);
        } else {
            cs.type(xpath, date);
            Reporter.log("Typed hide date: " + date);
        }
    }

    /**
     * Enter hide time.
     * 
     * @param time the time
     * @param xpath the xpath
     * @throws Exception the exception
     */
    public void enterHideTime(String time, String xpath) throws Exception {
        if (time.isEmpty()) {
            String now = "12:00AM";
            cs.type(xpath, now);
            Reporter.log("Typed hide time: " + now);
        } else {
            cs.type(xpath, time);
            Reporter.log("Typed hide time: " + time);
        }
    }

    /**
     * Gets the head additions.
     * 
     * @param input the input
     * @return the head additions
     * @throws Exception the exception
     */
    public String getHeadAdditions(String input) throws Exception {
        String value = cs.getText(input);
        return value;
    }

    /**
     * Gets the header additions.
     * 
     * @param input the input
     * @return the header additions
     * @throws Exception the exception
     */
    public String getHeaderAdditions(String input) throws Exception {
        String value = cs.getText(input);
        return value;
    }

    /**
     * Gets the footer additions.
     * 
     * @param input the input
     * @return the footer additions
     * @throws Exception the exception
     */
    public String getFooterAdditions(String input) throws Exception {
        String value = cs.getText(input);
        return value;
    }

    /**
     * Gets the body tag additions.
     * 
     * @param input the input
     * @return the body tag additions
     * @throws Exception the exception
     */
    public String getBodyTagAdditions(String input) throws Exception {
        String value = cs.getText(input);
        return value;
    }

    /**
     * Type head additions.
     * 
     * @param modify the modify
     * @param input the input
     * @param additions the additions
     * @throws Exception the exception
     */
    public void typeHeadAdditions(String modify, String input, String additions) throws Exception {
        String headAdditions = getHeadAdditions(input);
        cs.click(modify);
        Reporter.log("Clicked button to modify Head Additions");
        cs.type(input, additions + headAdditions);
        Reporter.log("Typed Head Additions: " + wrapHTMLCodeWithXMPTag(additions + headAdditions));
    }

    /**
     * Type header additions.
     * 
     * @param modify the modify
     * @param input the input
     * @param additions the additions
     * @throws Exception the exception
     */
    public void typeHeaderAdditions(String modify, String input, String additions) throws Exception {
        String headerAdditions = getHeaderAdditions(input);
        cs.click(modify);
        Reporter.log("Clicked button to modify Header Additions");
        cs.type(input, additions + headerAdditions);
        Reporter.log("Typed Header Additions: " + wrapHTMLCodeWithXMPTag(additions + headerAdditions));
    }

    /**
     * Type footer additions.
     * 
     * @param modify the modify
     * @param input the input
     * @param additions the additions
     * @throws Exception the exception
     */
    public void typeFooterAdditions(String modify, String input, String additions) throws Exception {
        String footerAdditions = getHeadAdditions(input);
        cs.click(modify);
        Reporter.log("Clicked button to modify Footer Additions");
        cs.type(input, additions + footerAdditions);
        Reporter.log("Typed Footer Additions: " + wrapHTMLCodeWithXMPTag(additions + footerAdditions));
    }

    /**
     * Type body tag additions.
     * 
     * @param modify the modify
     * @param input the input
     * @param additions the additions
     * @throws Exception the exception
     */
    public void typeBodyTagAdditions(String modify, String input, String additions) throws Exception {
        String bodyTagAdditions = getBodyTagAdditions(input);
        cs.click(modify);
        Reporter.log("Clicked button to modify Body Tag Additions");
        cs.type(input, additions + bodyTagAdditions);
        Reporter.log("Typed Body Tag Additions: " + wrapHTMLCodeWithXMPTag(additions + bodyTagAdditions));
    }

    /**
     * Gets the id number.
     * 
     * @param deleteButtonData the delete button data
     * @return the id number
     */
    public String getIdNumber(String deleteButtonData) {
        int startIndex = deleteButtonData.indexOf("(") + 2;
        String tempString = deleteButtonData.substring(startIndex);
        String idNumber = tempString.substring(0, tempString.indexOf("'"));
        try {
            Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
            Reporter.log("WARNING: No valid id number found in " + deleteButtonData);
            idNumber = "";
        }
        return idNumber;
    }

    /**
     * Checks if is alpha numeric.
     * 
     * @param s the string
     * @return true, if is alpha numeric
     */
    public boolean isAlphaNumeric(String s) {
        String pattern = "^[a-zA-Z0-9]*$";
        if (s.matches(pattern)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a full site name (e.g. bravo-web) given the abbreviated
     * name (e.g. BRAV-WEB). Requires a list of all sites, in alphabetical
     * order.
     *
     * @param abbreviatedName the abbreviated name
     * @param sites the array of all available sites
     * @return the full site name
     */
    public String getFullSiteName(String abbreviatedName, String[] sites) {
        String site, type, fullSiteName = "";
        int index = abbreviatedName.indexOf('•');
        if (index != -1) {
            site = abbreviatedName.substring(0, index).toLowerCase();
            type = abbreviatedName.substring(index + 1).toLowerCase();
        } else {
            site = abbreviatedName.toLowerCase();
            type = "";
        }
        for (String s : sites) {
            if (s.contains(site) && s.contains(type)) {
                fullSiteName = s;
                break;
            }
        }
        if (!fullSiteName.isEmpty()) {
            Reporter.log(abbreviatedName + " = " + fullSiteName);
        } else {
            Reporter.log("Warning: No site found matching " + abbreviatedName);
        }

        return fullSiteName;
    }

    /**
     * Verify http response code.
     *
     * @param url the url
     * @throws Exception the exception
     */
    public void verifyHTTPResponseCode(String url) throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        int code = connection.getResponseCode();
        if ((code != TWO_ZERO_ZERO)) {
            fail("Fail: page Response Code: " + code + ". URL: " + cs.getCurrentUrl());
        } else {
            Reporter.log("Page Response Code: " + code);
        }
    }

    /**
     * Verify character does not exists.
     *
     * @param actualText the actual text
     * @param textNotExpected the text not expected
     * @throws Exception the exception
     */
    public void verifyCharacterDoesNotExists(String actualText, String textNotExpected) throws Exception {
        if (actualText.contains(textNotExpected)) {
            fail("FAIL: unexpected text '" + textNotExpected + "' displays on string '" + actualText + "'");
        } else {
            Reporter.log("Pass: text '" + textNotExpected + "' DOES NOT display on string '" + actualText + "'");
        }
    }
    
    /**
     * Returns the API URL on performance test environment.
     * 
     * @return Return value api URL
     * @throws Exception Code Error
     */
    public final String getperfApiURL() throws Exception {
        return this.perfApiUrl;
    }
}
