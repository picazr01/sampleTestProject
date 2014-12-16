package com.nbcuni.test.mps;

import static org.testng.AssertJUnit.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nbcuni.test.lib.Util;
import com.nbcuni.test.webdriver.CustomWebDriver;
import com.nbcuni.test.webdriver.WebDriverClientExecution;

/**
 * The Class TC357_Login_Verify_ability_to_login_MPS_site.
 */
public class TC357_Login_Verify_ability_to_login_MPS_site {

    /** The wd. */
    private CustomWebDriver wd;

    /** The al. */
    private AppLib al;

    /** The ul. */
    private Util ul;

    /**
     * Instantiate the TestNG Before Class Method.
     * 
     * @param sEnv - environment
     * @param sSite the s site
     */
    @BeforeClass(alwaysRun = true)
    @Parameters({ "Environment", "Site" })
    public void startSelenium(String sEnv, String sSite) {
        try {
            wd = WebDriverClientExecution.getInstance().getDriver();
            al = new AppLib(wd);
            al.setEnvironmentInfo(sEnv, sSite);
            ul = new Util(wd);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    /**
     * Instantiate the TestNG After Class Method.
     */
    @AfterClass(alwaysRun = true)
    public void stopSelenium() {
        try {
            wd.quit();
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    /**
     * 
     * 
     * @throws Exception No Return values are needed
     * 
     */
    @Test(groups = { "full", "login" })
    public void tc357_Login_Verify_ability_to_login_MPS_site() throws Exception {
        Homepage homepage = al.openSite();
        homepage.clickSiteButton();
        homepage.clickSignInWithGoogleButton();
        homepage.enterGoogleAdministratorCredentials();
        homepage.googleRequestPermission(true);
        homepage.verifyUserIsLoggedOn(al.getAdministratorUserName());
    }
}
