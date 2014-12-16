package com.nbcuni.test.mps;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import static org.testng.AssertJUnit.fail;

import com.nbcuni.test.lib.Util;
import com.nbcuni.test.mps.content_types.ContentTypes;
import com.nbcuni.test.mps.globals.Components;
import com.nbcuni.test.mps.globals.DartAdUnits;
import com.nbcuni.test.mps.globals.GlobalDefaults;
import com.nbcuni.test.mps.globals.Globals;
import com.nbcuni.test.mps.globals.MPSAccounts;
import com.nbcuni.test.mps.logsandtools.LogsAndTools;
import com.nbcuni.test.mps.packages.Packages;
import com.nbcuni.test.mps.pages.Pages;
import com.nbcuni.test.mps.quicksearch.QuickSearch;
import com.nbcuni.test.mps.scheduling.Scheduling;
import com.nbcuni.test.mps.sections.Sections;
import com.nbcuni.test.webdriver.CustomWebDriver;

// TODO: Auto-generated Javadoc
/**************************************************************************
 * MPS Homepage Application Library. Copyright
 * 
 * @author Robert Picazo
 * @version 1.0 Date: February 13, 2014
 **************************************************************************/

public class Homepage {

    /** The cs. */
    private static CustomWebDriver cs;

    /** The al. */
    private static AppLib al;

    /** The ul. */
    private final Util ul;

    // MPS Homepage Objects
    /** The site button. */
    private static String siteButton = "//a[text()='xx']";

    /** The site button list. */
    private static String siteButtonList = "//ul[@id='navlist']/li[xx]/a";

    /** The Site_ button_ fandango apps. */
    private static String Site_Button_FandangoApps = "//a[text()='fandango-apps']";

    /** The Site_ button_ fandango web. */
    private static String Site_Button_FandangoWeb = "//a[text()='fandango-web']";

    /** The Site_ button_ partners. */
    private static String Site_Button_Partners = "//a[text()='partners']";

    /** The Site_ button_ sandbox. */
    private static String Site_Button_Sandbox = "//a[text()='sandbox']";

    /** The header link login to mps. */
    private static String headerLinkLoginToMPS = "//a[text()='[Login To MPS]']";

    /** The header link change site. */
    private static String headerLinkChangeSite = "//a[text()='[change site]']";

    /** The Header_ link_ mp s_ home. */
    private static String Header_Link_MPS_Home = "//img[@alt='Master Page Service']";

    /** The header label site name. */
    private static String headerLabelSiteName = "//strong[@id='header-instance-name']";

    /** The Header_ label_ site name_ upper case. */
    private static String Header_Label_SiteName_UpperCase = "//strong[text()='xx']";

    /** The Site_ search_ input. */
    private static String Site_Search_Input = "//input[@id='form-cid-input']";

    // MPS URL Objects
    /** The url edit page. */
    private static String urlEditPage = "/pages/modify/";

    /** The url edit section. */
    private static String urlEditSection = "/sections/modify/";

    /** The url edit content types. */
    private static String urlEditContentType = "/ctypes/modify/";

    /** The url edit packages. */
    private static String urlEditPackage = "/packages/modify/";

    /** The url page gpt visualizer. */
    private static String urlPageGptVisualizer = "/preview/gpt/";

    /** The url global defaults page. */
    private static String urlGlobalDefaultsPage = "/globalsettings/global_defaults";

    /** The url components page. */
    private static String urlComponentsPage = "/globalsettings/components";

    /** The url component bulk importer. */
    private static String urlComponentBulkImporter = "/globalsettings/component_bulk_import";

    /** The url component page associations. */
    private static String urlComponentPageAssociations = "/globalsettings/component_page_associations";

    /** The url content affinity groups. */
    private static String urlContentAffinityGroups = "/globalsettings/content_affinity_groups";

    /** The url cag bulk operations. */
    private static String urlCagBulkOperations = "/globalsettings/cag_bulk";

    /** The url cag envelope keys. */
    private static String urlCagEnvelopeKeys = "/globalsettings/cag_envelopes";

    /** The url dart ad units. */
    private static String urlDartAdUnits = "/globalsettings/dart_adunits";

    /** The url dart ad units swap. */
    private static String urlDartAdUnitsSwap = "/globalsettings/swap_dart_adunits";

    /** The url dart allowable keys. */
    private static String urlDartAllowableKeys = "/globalsettings/dart_keys";

    /** The url dart content type mapping. */
    private static String urlDartContentTypeMapping = "/globalsettings/dart_ct_mapping";

    /** The url dart tags bulk append. */
    private static String urlDartTagsBulkAppend = "/globalsettings/dart_bulk_append";

    /** The url omniture content types. */
    private static String urlOmnitureContentTypes = "/globalsettings/omniture_content_type";

    /** The url omniture sub content types. */
    private static String urlOmnitureSubContentTypes = "/globalsettings/omniture_subct_mapping";

    /** The url site instances. */
    private static String urlSiteInstances = "/globalsettings/site";

    /** The url notification contacts. */
    private static String urlNotificationContacts = "/globalsettings/notification_contacts";

    /** The url mps accounts auth2. */
    private static String urlMPSAccountsAuth2 = "/globalsettings/accounts";

    /** The url schedule ads pages envelopes. */
    private static String urlScheduleAdsPagesEnvelopes = "/scheduling/adunits";

    /** The url schedule ads content types. */
    private static String urlScheduleAdsContentTypes = "/scheduling/ctypes";

    /** The url schedule insertion pages sections. */
    private static String urlScheduleInsertionPagesSections = "/scheduling/insertions";

    /** The url schedule package sunrise sunset. */
    private static String urlSchedulePackageSunriseSunset = "/scheduling/packages";

    /** The url mps change log. */
    private static String urlMPSChangeLog = "/reports/sitelog";

    /** The url page updates statistic. */
    private static String urlPageUpdatesStatistic = "/reports/pageupdates";

    /** The url gpt request decoder. */
    private static String urlGPTRequestDecoder = "/reports/gptdecoder";

    // Login Objects
    /** The login button sign on using google. */
    private static String loginButtonSignOnUsingGoogle = "//img[@title='Sign into MPS with Google+']";

    /** The login label error. */
    private static String loginLabelError = "//section[@class='alertify-logs']//article";

    /** The google login input user name. */
    private static String googleLoginInputUserName = "//input[@id='Email']";

    /** The google login input password. */
    private static String googleLoginInputPassword = "//input[@id='Passwd']";

    /** The google login button sign in. */
    private static String googleLoginButtonSignIn = "//input[@id='signIn']";

    /** The google login button mps accept. */
    private static String googleLoginButtonMPSAccept = "//button[@id='submit_approve_access' and not(@disabled)]";

    /** The google login button mps cancel. */
    private static String googleLoginButtonMPSCancel = "//button[@id='submit_deny_access'] and not(@disabled)]";

    /** The google login verification method. */
    private static String googleLoginVerificationMethod = "//div[@id='challengeZippyAnchor']";

    /** The google login verification method option email. */
    private static String googleLoginVerificationMethodOptionEmail = "//input[@id='RecoveryEmailChallenge']";

    /** The Google login_ verification method_ input_ email. */
    private static String GoogleLogin_VerificationMethod_Input_Email = "//input[@id='emailAnswer']";

    /** The Google login_ verification method_ button_ continue. */
    private static String GoogleLogin_VerificationMethod_Button_Continue = "//*[@id='submitChallenge']";

    /** The Google login_ choose account. */
    private static String GoogleLogin_ChooseAccount = "//a[@id='account-chooser-link']";

    /** The Google login_ add account. */
    private static String GoogleLogin_AddAccount = "//a[@id='account-chooser-add-account']";

    /** The Google login_ text_ page content. */
    private static String GoogleLogin_Text_PageContent = "//body";

    /** The Google login_ account security_ button_ revoke access. */
    private static String GoogleLogin_AccountSecurity_Button_RevokeAccess = "//*[text()='Revoke access']";

    /** The Google login_ account security_ button_ ok. */
    private static String GoogleLogin_AccountSecurity_Button_OK = "//button[@name='ok']";

    /** The Google login_ logout_ url. */
    private static String GoogleLogin_Logout_URL = "http://accounts.google.com/logout";

    /** The Google login_ link_ revoke access. */
    private static String GoogleLogin_Link_RevokeAccess = "//a";

    /** The Header_ label_ user name. */
    private static String Header_Label_UserName = "//div[@id='headerbar']";

    /** The Header_ link_ logout. */
    private static String Header_Link_Logout = "//a[text()='[logout]']";

    // Header Tabs
    /** The Header_ page_ tab. */
    private static String Header_Page_Tab = "//a[text()='Pages']";

    /** The Header_ sections_ tab. */
    private static String Header_Sections_Tab = "//a[text()='Sections']";

    /** The Header_ content types_ tab. */
    private static String Header_ContentTypes_Tab = "//a[text()='Content Types']";

    /** The Header_ packages_ tab. */
    private static String Header_Packages_Tab = "//a[text()='Packages']";

    /** The Header_ globals_ tab. */
    private static String Header_Globals_Tab = "//a[text()='Globals']";

    /** The Header_ scheduling_ tab. */
    private static String Header_Scheduling_Tab = "//a[text()='Scheduling']";

    /** The Header_ logsand tools_ tab. */
    private static String Header_LogsandTools_Tab = "//a[text()='Logs & Tools']";

    // Main Content Sections
    /** The Header_ input_ enter content id or web url. */
    private static String Header_Input_EnterContentIdOrWebURL = "//input[@id='form-cid-input']";

    /** The Header_ label_ env and site name. */
    private static String Header_Label_EnvAndSiteName = "//div[@id='header-navtop-selection']";

    /** The Section_ action items. */
    private static String Section_ActionItems = "//div[@id='mps-action-items']";

    /** The Section_ action items_ header. */
    private static String Section_ActionItems_Header = Section_ActionItems + "//div[@class='home-banner']";

    /** The Section_ action items_ content. */
    private static String Section_ActionItems_Content = Section_ActionItems + "//div[@class='home-infobox']";

    /** The Page main content. */
    private static String PageMainContent = "//div[@id='maincontent']";

    // MPS Mode Overview
    /** The Section_ mps mode_ button_ debug mode. */
    private static String Section_MPSMode_Button_DebugMode = "//button[@title='Debug Mode']";

    /** The Section_ mps mode_ button_ mps overlay. */
    private static String Section_MPSMode_Button_MPSOverlay = "//button[@title='MPS Overlay']";

    /** The Section_ mps mode_ button_ instance redirect. */
    private static String Section_MPSMode_Button_InstanceRedirect = "//button[@title='Instance Redirect']";

    /** The Section_ mps mode_ instance redirect_ input. */
    private static String Section_MPSMode_InstanceRedirect_Input = "//input[@id='alertify-text']";

    /** The Section_ mps mode_ instance redirect_ ok. */
    private static String Section_MPSMode_Popup_Button_OK = "//button[@id='alertify-ok']";

    /** The Section_ mps mode_ instance redirect_ cancel. */
    private static String Section_MPSMode_InstanceRedirect_Cancel = "//button[@id='alertify-cancel']";

    /** The Section_ mps mode_ button_ mps cookies. */
    private static String Section_MPSMode_Button_MPSCookies = "//button[contains(text(),'mps cookies')]";

    /** The Section_ mps mode_ text_ mps cookies. */
    private static String Section_MPSMode_Text_MPSCookies = "//article[@class='alertify-inner']";

    /** The Section_ mps mode_ button_ clear cookies. */
    private static String Section_MPSMode_Button_ClearCookies = "//button[contains(text(),'clear cookies')]";

    /** The Section_ mps mode_ label_ status. */
    private static String Section_MPSMode_Label_Status = "//p[@id='home-banner-toggle-msg']";

    /** The Section_ site data analysis_ header. */
    private static String Section_SiteDataAnalysis_Header = PageMainContent + "/div[@class='home-banner'][1]";

    /** The Section_ site data analysis_ content. */
    private static String Section_SiteDataAnalysis_Content = PageMainContent + "/div[@class='home-infobox'][1]";

    /** The Section_ scheduled items_ header. */
    private static String Section_ScheduledItems_Header = PageMainContent + "/div[@class='home-banner'][2]";

    /** The Section_ scheduled items_ content. */
    private static String Section_ScheduledItems_Content = PageMainContent + "/div[@class='home-infobox'][2]";

    /** The Section_ newest pages added_ header. */
    private static String Section_NewestPagesAdded_Header = PageMainContent + "/div[@class='home-banner'][3]";

    /** The Section_ newest pages added_ content. */
    private static String Section_NewestPagesAdded_Content = PageMainContent + "/div[@class='home-infobox'][3]";

    /** The Section_ recently_ active_ users_ header. */
    private static String Section_Recently_Active_Users_Header = PageMainContent + "/div[@class='home-banner'][4]";

    /** The Section_ recently_ active_ users_ content. */
    private static String Section_Recently_Active_Users_Content = PageMainContent + "/div[@class='home-infobox'][4]";

    /** The DB update_ table. */
    private static String DBUpdate_Table = "//table";

    /** The DB update_ table_ rows. */
    private static String DBUpdate_Table_Rows = DBUpdate_Table + "//tr[xx]";

    /** The DB update_ header_ label_ updated. */
    private static String DBUpdate_Header_Label_Updated = "//h1[text()='Your database is up to date!']";

    /** The Section_ debug_ view. */
    private static String Section_Debug_View = "//div[@id='kohana-profiler']";

    /**
     * Instantiates a new homepage.
     * 
     * @param custWebDr
     *            the cust web dr
     * @param al2
     *            the al2
     */
    public Homepage(final CustomWebDriver custWebDr, final AppLib al2) {
        cs = custWebDr;
        al = al2;
        ul = new Util(cs);
        try {
            // Thread.sleep(3000);
        } catch (Exception e) {
            fail("Homepage - " + e.toString());
        }
    }

    /**
     * Click site button.
     * 
     * @throws Exception
     *             the exception
     */
    public void clickSiteButton() throws Exception {
        try {
            cs.click(siteButton.replace("xx", al.getSiteName()));
            Reporter.log("Clicked on site button " + al.getSiteName());
        } catch (Exception e) {
            String url = cs.getLocation();
            String title = cs.getTitle();
            String html = cs.getAttribute("//body", "outerHTML");
            String msg = "url=" + url + " pageTitle=" + title + " html=" + html;
            fail("Clicking on site " + al.getSiteName() + " failed. " + msg + " [" + e.toString() + "]");
        }
    }

    /**
     * Click site button.
     * 
     * @param siteName
     *            the site name
     * @throws Exception
     *             the exception
     */
    public void clickSiteButton(String siteName) throws Exception {
        try {
            cs.click(siteButton.replace("xx", siteName));
            al.setSiteName(siteName);
            Reporter.log("Clicked on site button: " + siteName);
            Thread.sleep(3000);
        } catch (Exception e) {
            String url = cs.getLocation();
            String title = cs.getTitle();
            String html = cs.getAttribute("//body", "outerHTML");
            String msg = "url=" + url + " pageTitle=" + title + " html=" + html;
            fail("Clicking on site " + al.getSiteName() + " failed. " + msg + " [" + e.toString() + "]");
        }
    }

    /**
     * Click logon to mps link.
     * 
     * @throws Exception
     *             the exception
     */
    public void clickLogonToMPSLink() throws Exception {
        cs.click(headerLinkLoginToMPS);
        Reporter.log("Clicked on Login to MPS link");
    }

    /**
     * Click logout link.
     * 
     * @throws Exception
     *             the exception
     */
    public void clickLogoutLink() throws Exception {
        cs.click(Header_Link_Logout);
        Reporter.log("Clicked on Logout link");
    }

    /**
     * Click change site link.
     * 
     * @throws Exception
     *             the exception
     */
    public void clickChangeSiteLink() throws Exception {
        cs.click(headerLinkChangeSite);
        Reporter.log("Clicked on Change Site link");
    }

    /**
     * Click sign in with google button.
     * 
     * @throws Exception
     *             the exception
     */
    public void clickSignInWithGoogleButton() throws Exception {
        cs.click(loginButtonSignOnUsingGoogle);
        Reporter.log("Clicked on Google Sign On button");
    }

    /**
     * Enter google credentials.
     * 
     * @throws Exception
     *             the exception
     */
    public void enterGoogleAdministratorCredentials() throws Exception {
        cs.type(googleLoginInputUserName, al.getAdministratorUserName());
        Thread.sleep(2000);
        cs.type(googleLoginInputPassword, al.getAdministratorUserPassword());
        Thread.sleep(2000);
        cs.click(googleLoginButtonSignIn);
        Reporter.log("Entered Google administrator credentials for " + al.getAdministratorUserName()
                + " and clicked sign in");
    }

    /**
     * Enter google limited credentials.
     *
     * @throws Exception
     *             the exception
     */
    public void enterGoogleLimitedCredentials() throws Exception {
        cs.type(googleLoginInputUserName, al.getLimitedUserName());
        Thread.sleep(2000);
        cs.type(googleLoginInputPassword, al.getLimitedUserPassword());
        Thread.sleep(2000);
        cs.click(googleLoginButtonSignIn);
        Reporter.log("Entered Google limited credentials for " + al.getLimitedUserName() + " and clicked sign in");
    }

    /**
     * Check if google api error exists.
     * 
     * @throws Exception
     *             the exception
     */
    public void checkIfGoogleAPIErrorExists() throws Exception {
        String title = cs.getTitle();
        if (title.contains("exception")) {
            String pageSource = cs.findElement(By.tagName("body")).getText();
            fail("Google API Error: " + pageSource + " URL: " + cs.getLocation());
        }
    }

    /**
     * Enter google credentials.
     * 
     * @param user
     *            the user
     * @param password
     *            the password
     * @throws Exception
     *             the exception
     */
    public void enterGoogleCredentials(String user, String password) throws Exception {
        cs.type(googleLoginInputUserName, user);
        Thread.sleep(2000);
        cs.type(googleLoginInputPassword, password);
        Thread.sleep(2000);
        cs.click(googleLoginButtonSignIn);
        Reporter.log("Entered Google credentials for " + user + " and clicked sign in");
    }

    /**
     * Enter google validation if requested.
     * 
     * @throws Exception
     *             the exception
     */
    public void enterGoogleValidationIfRequested() throws Exception {
        int count = cs.findElementsByXPath(googleLoginVerificationMethod).size();
        if (count > 0) {
            cs.click(googleLoginVerificationMethod);
            cs.click(googleLoginVerificationMethodOptionEmail);
            cs.type(GoogleLogin_VerificationMethod_Input_Email, "robert.picazo@nbcuni.com");
            cs.click(GoogleLogin_VerificationMethod_Button_Continue);
            Reporter.log("Google Verification - completed Google verification");
        }
    }

    /**
     * Google request permission.
     * 
     * @param access
     *            the access
     * @throws Exception
     *             the exception
     */
    public void googleRequestPermission(Boolean access) throws Exception {
        String title = cs.getTitle();
        if (title.contains("request")) {
            if (access) {
                if (!al.waitForObject(googleLoginButtonMPSAccept, 2)) {
                    enterGoogleValidationIfRequested();
                }
                List<WebElement> mpsAccept = cs.findElementsByXPath(googleLoginButtonMPSAccept);
                if (mpsAccept.size() != 0) {
                    mpsAccept.get(0).click();
                    Reporter.log("Clicked on Google Accept button");
                }
                checkIfGoogleAPIErrorExists();
            } else {
                if (!al.waitForObject(googleLoginButtonMPSCancel, 30)) {
                    enterGoogleValidationIfRequested();
                }
                List<WebElement> mpsCancel = cs.findElementsByXPath(googleLoginButtonMPSCancel);
                if (mpsCancel.size() != 0) {
                    mpsCancel.get(0).click();
                    Reporter.log("Clicked on Google Cancel button");
                }
                checkIfGoogleAPIErrorExists();
            }
        }
    }

    /**
     * Verify homepage access.
     * 
     * @throws Exception
     *             the exception
     */
    public void verifyHomepageAccess() throws Exception {
        if (!cs.getText(Section_ActionItems_Header).contains("MPS Action Items")) {
            fail("Homepage did not load.");
        }
        Reporter.log("Homepage displayed");
    }

    /**
     * Verify user is logged on.
     * 
     * @param user
     *            the user
     */
    public void verifyUserIsLoggedOn(String user) {
        String text = cs.getText(Header_Label_UserName);
        if (text.contains(user)) {
            Reporter.log("User " + user + " is logged on");
        } else {
            fail("User " + user + " is not logged on");
        }
    }

    /**
     * Verify user is logged off.
     * 
     * @param user
     *            the user
     */
    public void verifyUserIsLoggedOff(String user) {
        String text = cs.getText(Header_Label_UserName);
        if (text.contains(user)) {
            fail("User " + user + " was not logged off");
        } else {
            Reporter.log("User " + user + " is logged off");
        }
    }

    /**
     * Click pages tab.
     * 
     * @return the pages
     * @throws Exception
     *             the exception
     */
    public Pages clickPagesTab() throws Exception {
        cs.click(Header_Page_Tab);
        Reporter.log("Click on Pages tab");
        return new Pages(cs, al);
    }

    /**
     * Open page.
     *
     * @param id the id
     * @return the pages
     * @throws Exception the exception
     */
    public Pages openPage(String id) throws Exception {
        String url = al.getSiteURL() + urlEditPage + id;
        cs.openURL(url);
        Reporter.log("Access Page Edit from URL: " + url);
        return new Pages(cs, al);
    }

    /**
     * Open section.
     *
     * @param id the id
     * @return the sections
     * @throws Exception the exception
     */
    public Sections openSection(String id) throws Exception {
        String url = al.getSiteURL() + urlEditSection + id;
        cs.openURL(url);
        Reporter.log("Access Section Edit from URL: " + url);
        return new Sections(cs, al);
    }

    /**
     * Open content type.
     *
     * @param id the id
     * @return the content types
     * @throws Exception the exception
     */
    public ContentTypes openContentType(String id) throws Exception {
        String url = al.getSiteURL() + urlEditContentType + id;
        cs.openURL(url);
        Reporter.log("Access Content Type Edit from URL: " + url);
        return new ContentTypes(cs, al);
    }

    /**
     * Open package.
     *
     * @param id the id
     * @return the packages
     * @throws Exception the exception
     */
    public Packages openPackage(String id) throws Exception {
        String url = al.getSiteURL() + urlEditPackage + id;
        cs.openURL(url);
        Reporter.log("Access Package Edit from URL: " + url);
        return new Packages(cs, al);
    }

    /**
     * Open global defaults.
     *
     * @return the global defaults
     * @throws Exception the exception
     */
    public GlobalDefaults openGlobalDefaults() throws Exception {
        String url = al.getSiteURL() + urlGlobalDefaultsPage;
        cs.openURL(url);
        Reporter.log("Access Global Defaults from URL: " + url);
        return new GlobalDefaults(cs, al);
    }

    /**
     * Open components.
     *
     * @return the components
     * @throws Exception the exception
     */
    public Components openComponents() throws Exception {
        String url = al.getSiteURL() + urlComponentsPage;
        cs.openURL(url);
        Reporter.log("Access Components from URL: " + url);
        return new Components(cs, al);
    }

    /**
     * Open dart ad units.
     *
     * @return the dart ad units
     * @throws Exception the exception
     */
    public DartAdUnits openDartAdUnits() throws Exception {
        String url = al.getSiteURL() + urlDartAdUnits;
        cs.openURL(url);
        Reporter.log("Access Dart Ad Units from URL: " + url);
        return new DartAdUnits(cs, al);
    }

    /**
     * Open mps accounts.
     *
     * @return the MPS accounts
     * @throws Exception the exception
     */
    public MPSAccounts openMPSAccounts() throws Exception {
        String url = al.getSiteURL() + urlMPSAccountsAuth2;
        cs.openURL(url);
        Reporter.log("Access MPS Accounts from URL: " + url);
        return new MPSAccounts(cs, al);
    }

    /**
     * Click sections tab.
     * 
     * @return the sections
     * @throws Exception
     *             the exception
     */
    public Sections clickSectionsTab() throws Exception {
        cs.click(Header_Sections_Tab);
        Reporter.log("Click on Sections tab");
        return new Sections(cs, al);
    }

    /**
     * Click content types tab.
     * 
     * @return the content types
     * @throws Exception
     *             the exception
     */
    public ContentTypes clickContentTypesTab() throws Exception {
        cs.click(Header_ContentTypes_Tab);
        Reporter.log("Click on Content Types tab");
        Thread.sleep(3000);
        return new ContentTypes(cs, al);
    }

    /**
     * Click packages tab.
     * 
     * @return the packages
     * @throws Exception
     *             the exception
     */
    public Packages clickPackagesTab() throws Exception {
        cs.click(Header_Packages_Tab);
        Reporter.log("Click on Packages tab");
        return new Packages(cs, al);
    }

    /**
     * Click globals tab.
     * 
     * @return the globals
     * @throws Exception
     *             the exception
     */
    public Globals clickGlobalsTab() throws Exception {
        cs.click(Header_Globals_Tab);
        Reporter.log("Click on Globals tab");
        return new Globals(cs, al);
    }

    /**
     * Click scheduling tab.
     * 
     * @return the scheduling
     * @throws Exception
     *             the exception
     */
    public Scheduling clickSchedulingTab() throws Exception {
        cs.click(Header_Scheduling_Tab);
        Reporter.log("Click on Scheduling tab");
        return new Scheduling(cs, al);
    }

    /**
     * Click logsand tools tab.
     * 
     * @return the logs and tools
     * @throws Exception
     *             the exception
     */
    public LogsAndTools clickLogsandToolsTab() throws Exception {
        cs.click(Header_LogsandTools_Tab);
        Reporter.log("Click on Logs and Tools tab");
        return new LogsAndTools(cs, al);
    }

    /**
     * Logon to site.
     * 
     * @throws Exception
     *             the exception
     */
    public void logonToSite() throws Exception {
        clickSiteButton();
        clickSignInWithGoogleButton();
        enterGoogleAdministratorCredentials();
        googleRequestPermission(true);
    }

    /**
     * Logon to site.
     * 
     * @param siteName
     *            the site name
     * @throws Exception
     *             the exception
     */
    public void logonToSite(String siteName) throws Exception {
        clickSiteButton(siteName);
        clickSignInWithGoogleButton();
        enterGoogleAdministratorCredentials();
        googleRequestPermission(true);
        al.setSiteName(siteName);
    }

    /**
     * Logon to site limited.
     *
     * @throws Exception
     *             the exception
     */
    public void logonToSiteLimited() throws Exception {
        clickSiteButton();
        clickSignInWithGoogleButton();
        enterGoogleLimitedCredentials();
        googleRequestPermission(true);
    }

    /**
     * Select random site.
     * 
     * @return the string
     * @throws Exception
     *             the exception
     */
    public String selectRandomSite() throws Exception {
        List<WebElement> sites = cs.findElementsByXPath(siteButtonList.replace("[xx]", ""));
        int num = al.getRandomNumber(0, sites.size());
        String siteName = sites.get(num).getText();
        clickSiteButton(siteName);
        return siteName;
    }

    /**
     * Gets the random site.
     *
     * @return the random site
     * @throws Exception the exception
     */
    public String getRandomSite() throws Exception {
        List<WebElement> sites = cs.findElementsByXPath(siteButtonList.replace("[xx]", ""));
        int num = al.getRandomNumber(0, sites.size());
        String siteName = sites.get(num).getText();
        return siteName;
    }

    /**
     * Gets a random site not equal to the current site.
     *
     * @return the random other site
     * @throws Exception the exception
     */
    public String getRandomOtherSite() throws Exception {
        String randomSite = getRandomSite();
        while (randomSite.equals(al.getSiteName())) {
            randomSite = getRandomSite();
        }
        return randomSite;
    }

    /**
     * Verify header site name.
     * 
     * @param expected
     *            the expected
     * @throws Exception
     *             the exception
     */
    public void verifyHeaderSiteName(String expected) throws Exception {
        Reporter.log("Verify header site name '" + expected.toUpperCase() + "' on " + cs.getLocation());
        String actual = cs.getText(headerLabelSiteName);
        ul.verifyAndCompareTextValues(actual.toLowerCase(), expected.toLowerCase());
    }

    /**
     * Verify mps authentication error msg displays.
     * 
     * @throws Exception
     *             the exception
     */
    public void verifyMPSAuthenticationErrorMsgDisplays() throws Exception {
        Reporter.log("Verify MPS authentication error msg displays");
        String actualMsg = cs.getText(loginLabelError).replace("\n", "").replace("\r", "");
        String expectedMsg =
                "Your Google account has not been configured for MPS access yet. || You have been logged out of MPS.Have a nice day!";
        ul.verifyTextContainsExpectedText(expectedMsg, actualMsg);
    }

    /**
     * Log out and log in as limited.
     *
     * @throws Exception
     *             the exception
     */
    public void logOutAndLogInAsLimited() throws Exception {
        Reporter.log("Logging out " + al.getAdministratorUserName() + " and logging in " + al.getLimitedUserName());
        cs.openURL(GoogleLogin_Logout_URL);
        Reporter.log("Going to URL " + GoogleLogin_Logout_URL);
        Thread.sleep(5000);
        cs.click(GoogleLogin_ChooseAccount);
        Reporter.log("Clicked button for 'Sign in with a different account'");
        cs.click(GoogleLogin_AddAccount);
        Reporter.log("Clicked button for 'Add account'");
        enterGoogleLimitedCredentials();
        Reporter.log("Returning to MPS");
        al.openSite();
        clickLogoutLink();
        clickLogonToMPSLink();
        clickSignInWithGoogleButton();
        Thread.sleep(5000);
        if (cs.findElementsByXPath(googleLoginButtonMPSAccept).size() == 1) {
            cs.click(googleLoginButtonMPSAccept);
        }
        if (cs.getText(GoogleLogin_Text_PageContent).contains("Unable to get refresh token")) {
            Reporter.log("Unable to get refresh token. Revoking Google access and trying again.");
            cs.click(GoogleLogin_Link_RevokeAccess);
            Reporter.log("Clicked Revoke Access link");
            Thread.sleep(5000);
            al.switchToWindow();
            cs.click(GoogleLogin_AccountSecurity_Button_RevokeAccess);
            Reporter.log("Clicked button on Google Account Security page for 'Revoke Access'");
            Thread.sleep(1000);
            cs.click(GoogleLogin_AccountSecurity_Button_OK);
            Reporter.log("Accepted popup");
            al.openSite();
            clickLogonToMPSLink();
            clickSignInWithGoogleButton();
            Thread.sleep(5000);
            cs.click(googleLoginButtonMPSAccept);
        }
    }

    /**
     * Open db update page.
     *
     * @throws Exception
     *             the exception
     */
    public void openDBUpdatePage() throws Exception {
        String url = al.getSiteURL() + "/updates";
        cs.openURL(url);
        Thread.sleep(5000);
    }

    /**
     * Check db updates. DO NOT AUTOMATE UPDATING DB - WE MUST PERFORM MANUALLY
     * JUST IN CASE A PROCESS GETS STUCK
     * 
     * @throws Exception the exception
     */
    public final void checkDBUpdates() throws Exception {
        if (cs.isVisible(DBUpdate_Header_Label_Updated)) {
            String msg = cs.getText(DBUpdate_Header_Label_Updated);
            Reporter.log("No Action Required. " + msg);
        } else {
            int count = cs.findElementsByXPath(DBUpdate_Table_Rows.replace("[xx]", "")).size();
            if (count > 1) {
                fail((count - 1) + " database updates exists and MUST BE executed manually. "
                        + "Please access the folowing URL and click on the Run All Updates button. " + cs.getLocation());
            } else {
                fail("Invalid response for DB updates. " + cs.getLocation());
            }
        }
    }

    /**
     * Gets the list of all sites.
     *
     * @return the sites
     */
    public String[] getSites() {
        List<String> siteNames = new LinkedList<String>();
        List<WebElement> sites = cs.findElementsByXPath(siteButtonList.replace("[xx]", ""));
        for (WebElement site : sites) {
            siteNames.add(site.getText());
        }
        return siteNames.toArray(new String[0]);
    }

    /**
     * Click home page header logo.
     */
    public void clickHomePageHeaderLogo() {
        cs.click(Header_Link_MPS_Home);
        Reporter.log("Navigate to Home Page");
    }

    /**
     * Homepage search for content.
     *
     * @param content the content
     * @return the pages
     * @throws Exception the exception
     */
    public Pages homepageSearchForContent(String content) throws Exception {
        WebElement element = cs.findElementByXPath(Site_Search_Input);
        element.sendKeys(content);
        element.submit();
        Reporter.log("Searched for " + "'" + content + "'" + " content on Home Page");
        return new Pages(cs, al);
    }

    /**
     * Launch quick search page.
     *
     * @return the quick search
     * @throws Exception the exception
     */
    public QuickSearch launchQuickSearchPage() throws Exception {
        homepageSearchForContent("dummydata");
        Reporter.log("Loaded Quick Search page");
        return new QuickSearch(cs, al);
    }

    /**
     * Gets the button mode.
     *
     * @param xpath the xpath
     * @return the button mode
     */
    public String getButtonMode(String xpath) {
        String mode = cs.getAttribute(xpath, "class");
        if (mode.contains("enabled")) {
            return "enabled";
        } else if (mode.contains("disabled")) {
            return "disabled";
        } else {
            fail("Unable to determine mode for " + xpath);
            return "";
        }
    }

    /**
     * Gets the debug mode.
     *
     * @return the debug mode
     */
    public String getDebugMode() {
        String mode = getButtonMode(Section_MPSMode_Button_DebugMode);
        Reporter.log("Debug mode is " + mode);
        return mode;
    }

    /**
     * Click debug mode.
     *
     * @throws Exception the exception
     */
    public void clickDebugMode() throws Exception {
        cs.click(Section_MPSMode_Button_DebugMode);
        Reporter.log("Clicked 'Debug Mode' button on MPS Mode Overview");
        Thread.sleep(2000);
    }

    /**
     * Verify debug mode.
     *
     * @param mode the mode
     * @throws Exception the exception
     */
    public void verifyDebugMode(String mode) throws Exception {
        ul.verifyTextContainsExpectedText(mode, getDebugMode());
        verifyMPSModeLabel("debug", mode);
        clickMPSCookiesButton();
        verifyMPSCookies("__debugmode__=2", mode);
        closeMPSCookiesPopup();
    }

    /**
     * Gets the MPS overlay.
     *
     * @return the MPS overlay
     */
    public String getMPSOverlay() {
        String mode = getButtonMode(Section_MPSMode_Button_MPSOverlay);
        Reporter.log("MPS Overlay is " + mode);
        return mode;
    }

    /**
     * Click mps overlay.
     *
     * @throws Exception the exception
     */
    public void clickMPSOverlay() throws Exception {
        cs.click(Section_MPSMode_Button_MPSOverlay);
        Reporter.log("Clicked 'MPS Overlay' button on MPS Mode Overview");
        Thread.sleep(2000);
    }

    /**
     * Verify mps overlay.
     *
     * @param mode the mode
     * @throws Exception the exception
     */
    public void verifyMPSOverlay(String mode) throws Exception {
        ul.verifyTextContainsExpectedText(mode, getMPSOverlay());
        verifyMPSModeLabel("overlay", mode);
        clickMPSCookiesButton();
        verifyMPSCookies("__overlay__=1", mode);
        closeMPSCookiesPopup();
    }

    /**
     * Click instance redirect.
     *
     * @throws Exception the exception
     */
    public void clickInstanceRedirect() throws Exception {
        cs.click(Section_MPSMode_Button_InstanceRedirect);
        Reporter.log("Clicked 'Instance Redirect' button on MPS Mode Overview");
        Thread.sleep(2000);
    }

    /**
     * Enter instance redirect.
     *
     * @param site the site
     * @param acceptPopup the accept popup
     */
    public void enterInstanceRedirect(String site, boolean acceptPopup) {
        cs.type(Section_MPSMode_InstanceRedirect_Input, site);
        Reporter.log("Typed '" + site + "' for instance redirect");
        if (acceptPopup) {
            cs.click(Section_MPSMode_Popup_Button_OK);
            Reporter.log("Submitted instance redirect");
        } else {
            cs.click(Section_MPSMode_InstanceRedirect_Cancel);
            Reporter.log("Canceled instance redirect");
        }
    }

    /**
     * Gets the instance redirect.
     *
     * @return the instance redirect
     */
    public String getInstanceRedirect() {
        String mode = getButtonMode(Section_MPSMode_Button_InstanceRedirect);
        Reporter.log("Instance Redirect is " + mode);
        return mode;
    }

    /**
     * Gets the instance redirect button text.
     *
     * @return the instance redirect button text
     */
    public String getInstanceRedirectButtonText() {
        String text = cs.getText(Section_MPSMode_Button_InstanceRedirect);
        Reporter.log("Instance Redirect = " + text);
        return text;
    }

    /**
     * Verify instance redirect.
     *
     * @param mode the mode
     * @param site the site
     * @throws Exception the exception
     */
    public void verifyInstanceRedirect(String mode, String site) throws Exception {
        ul.verifyTextContainsExpectedText(mode, getInstanceRedirect());
        if (mode.equals("enabled")) {
            ul.verifyTextContainsExpectedText(getInstanceRedirectButtonText(), site);
            verifyMPSModeLabel("redirect", site);
        } else {
            verifyMPSModeLabel("redirect", mode);
        }
        clickMPSCookiesButton();
        verifyMPSCookies("__instance__=" + site, mode);
        closeMPSCookiesPopup();
    }

    /**
     * Verify mps mode label.
     *
     * @param mode the mode
     * @param state the state
     */
    public void verifyMPSModeLabel(String mode, String state) {
        String text = cs.getText(Section_MPSMode_Label_Status).toLowerCase();
        ul.verifyTextContainsExpectedText(text, mode);
        ul.verifyTextContainsExpectedText(text, state);
    }

    /**
     * Click mps cookies button.
     *
     * @throws Exception the exception
     */
    public void clickMPSCookiesButton() throws Exception {
        cs.click(Section_MPSMode_Button_MPSCookies);
        Reporter.log("Click 'mps cookies' button");
        Thread.sleep(2000);
    }

    /**
     * Verify mps cookies.
     *
     * @param cookies the cookies
     * @param mode the mode
     */
    public void verifyMPSCookies(String cookies, String mode) {
        String text = cs.getText(Section_MPSMode_Text_MPSCookies);
        if (mode.equals("enabled")) {
            ul.verifyTextContainsExpectedText(text, cookies);
        } else if (mode.equals("disabled")) {
            if (text.contains(cookies)) {
                fail("Cookie still set for '" + cookies + "'");
            } else {
                Reporter.log("Pass: Cookie is cleared");
            }
        } else {
            fail("Mode must be either enabled or disabled");
        }
    }

    /**
     * Close mps cookies popup.
     */
    public void closeMPSCookiesPopup() {
        cs.click(Section_MPSMode_Popup_Button_OK);
    }

    /**
     * Click clear cookies button.
     *
     * @throws Exception the exception
     */
    public void clickClearCookiesButton() throws Exception {
        cs.click(Section_MPSMode_Button_ClearCookies);
        Reporter.log("Click 'clear cookies' button");
        Thread.sleep(2000);
    }

    /**
     * Verify debug window appears.
     */
    public void verifyDebugWindowAppears() {
        int count = cs.findElementsByXPath(Section_Debug_View).size();
        if (count == 1) {
            Reporter.log("Pass: Debug window is visible");
        } else {
            fail("Debug mode failed");
        }
    }

    /**
     * Reset global defaults.
     *
     * @param settings the settings
     * @throws Exception the exception
     */
    public void resetGlobalDefaults(HashMap<String, String> settings) throws Exception {
        openGlobalDefaults().resetGlobalDefaults(settings);
    }
}
