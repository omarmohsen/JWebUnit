/**
 * Copyright (c) 2002-2012, JWebUnit team.
 *
 * This file is part of JWebUnit.
 *
 * JWebUnit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JWebUnit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JWebUnit.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.jwebunit.junit;

import java.awt.Image;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.net.URL;

import net.sourceforge.jwebunit.api.HttpHeader;
import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.api.ITestingEngine;
import net.sourceforge.jwebunit.exception.TestingEngineResponseException;
import net.sourceforge.jwebunit.html.Table;
import net.sourceforge.jwebunit.util.TestContext;

import junit.framework.TestCase;

/**
 * Deprecated: use JUnit 4 and {@link JWebUnit} instead.
 * Superclass for JUnit 3 TestCases which provides web application navigation and 
 * JUnit assertions. This class uses and is generated from {@link net.sourceforge.jwebunit.junit.WebTester}.
 * 
 * @author JavaCC
 */
@Deprecated
public abstract class WebTestCase extends TestCase {
    protected WebTester tester = null;

    protected WebTester customTester = null;

    /***
      * From 2.1 you can provide your own WebTester to run test cases.
      */
    public WebTestCase(WebTester customTester) {
        super();
        this.customTester = customTester;
    }

    public WebTestCase(String name, WebTester customTester) {
        super(name);
        this.customTester = customTester;
    }

    public WebTestCase(String name) {
        super(name);
    }

    public WebTestCase() {
        super();
    }

    protected void tearDown() throws Exception {
        closeBrowser();
        super.tearDown();
    }

    /**
     * Get internal WebTester.
     */
    public WebTester getTester() {
        return this.tester;
    }

    /**
     * Clean up unused memory. Using <tt>setUp</tt> and <tt>tearDown</tt> is
     * not an option for this requires the subclasses of this class to call the
     * respective <tt>super</tt> methods.
     *
     * <p>Original patch contributed by Budi Boentaran.
     */
    public void runBare() throws Throwable {
        try {
            if (customTester == null)
                tester = new WebTester();
            else
                tester = customTester;
            super.runBare();
        } finally {
            tester = null;
            customTester = null;
        }
    }

    /**
     * Provides access to the testing engine for subclasses - in case functionality not yet wrappered required by test.
     *
     * If the testing engine is not explicitly set the JWebUnit framework will default to using the orignal testing engine,
     * which is, htmlunit.
     *
     * @return IJWebUnitDialog instance used to wrapper htmlunit conversation.
     * @deprecated You should not use plugin specific functionality. Please ask for a new core feature instead.
     */
    public ITestingEngine getDialog() {
        try {
            return tester.getDialog();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the base url for the test context.
     * 
     * @param url Base url value - A trailing "/" is appended if not provided.
     */
    public void setBaseUrl(String url) {
        try {
            tester.setBaseUrl(url);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the base url for the test context.
     * 
     * @param url Base url value - A trailing "/" is appended if not provided.
     */
    public void setBaseUrl(URL url) {
        try {
            tester.setBaseUrl(url);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * UserAgentTest
     * 
     * 
     */
    public void setUrlandAgent(String url, String agent) {
        try {
            tester.setUrlandAgent(url, agent);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Protected version of deprecated getDialog(). Not deprecated for internal use.
     *
     * @return IJWebUnitDialog instance.
     */
    public ITestingEngine getTestingEngine() {
        try {
            return tester.getTestingEngine();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Close the current conversation.
     */
    public void closeBrowser() {
        try {
            tester.closeBrowser();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Close the current window.
     */
    public void closeWindow() {
        try {
            tester.closeWindow();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the testing engine.
     *
     * @param aIJWebUnitDialog Testing engine.
     */
    public void setDialog(ITestingEngine aIJWebUnitDialog) {
        try {
            tester.setDialog(aIJWebUnitDialog);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Provide access to test testContext.
     *
     * @return TestContext
     */
    public TestContext getTestContext() {
        try {
            return tester.getTestContext();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Allows setting an external test testContext class that might be extended from TestContext. Example:
     * setTestContext(new CompanyATestContext());
     *
     * CompanyATestContext extends TestContext.
     *
     * @param aTestContext
     */
    public void setTestContext(TestContext aTestContext) {
        try {
            tester.setTestContext(aTestContext);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Begin conversation at a URL absolute or relative to base URL. Use
     * {@link TestContext#setBaseUrl(String) getTestContext().setBaseUrl(String)} to define base URL. Absolute URL
     * should start with "http://", "https://" or "www.".
     *
     * @param url absolute or relative URL (relative to base URL).
     * @throws TestingEngineResponseException If something bad happend (404)
     */
    public void beginAt(String aRelativeURL)throws TestingEngineResponseException {
        try {
            tester.beginAt(aRelativeURL);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Return the value of a web resource based on its key. This translates to a property file lookup with the locale
     * based on the current TestContext.
     *
     * @param key name of the web resource.
     * @return value of the web resource, encoded according to TestContext.
     */
    public String getMessage(String key) {
        try {
            return tester.getMessage(key);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Return the value of a web resource based on its key, using MessageFormat
     * to perform parametric substitution with formatting.
     *
     * @see MessageFormat
     * @param key
     *            name of the web resource.
     * @param args
     *            array of arguments to be formatted into message
     * @return value of the web resource after formatting
     */
    public String getMessage(String key, Object[] args) {
        try {
            return tester.getMessage(key, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the page response has a particular code.
     * 
     * @param status the expected status code 
     */
    public void assertResponseCode(int status) {
        try {
            tester.assertResponseCode(status);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the page response has a particular code between lower and higher
     * (<code>lower <= status <= higher</code>).
     * 
     * @param lower the lower bound for the expected status code 
     * @param higher the upper bound for the expected status code 
     */
    public void assertResponseCodeBetween(int lower, int higher) {
        try {
            tester.assertResponseCodeBetween(lower, higher);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
	 * Should the tester ignore failing status codes (300+)? Otherwise,
	 * failing status codes will throw an exception.
	 * 
	 * @param ignore
	 */
    public void setIgnoreFailingStatusCodes(boolean ignore) {
        try {
            tester.setIgnoreFailingStatusCodes(ignore);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a header is present.
     * 
     * @param name The header to find
     */
    public void assertHeaderPresent(String name) {
        try {
            tester.assertHeaderPresent(name);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a header is NOT present.
     * 
     * @param name The header to find
     */
    public void assertHeaderNotPresent(String name) {
        try {
            tester.assertHeaderNotPresent(name);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a header is equal to a particular value.
     * 
     * @param name Header to find
     * @param value Value to compare against
     */
    public void assertHeaderEquals(String name, String value) {
        try {
            tester.assertHeaderEquals(name, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a header matches a particular pattern.
     * 
     * @param name Header to find
     * @param regexp Pattern to compare against
     */
    public void assertHeaderMatches(String name, String regexp) {
        try {
            tester.assertHeaderMatches(name, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get a particular header value.
     * 
     * @param name Header to find
     * @return The found header value, or null
     */
    public String getHeader(String name) {
        try {
            return tester.getHeader(name);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get all response headers.
     * 
     * @return A map of response headers
     * @deprecated This method do not deal with several headers with same name. Use {@link #getResponseHeaders()} instead.
     */
    @Deprecated
    public Map<String,String> getAllHeaders() {
        try {
            return tester.getAllHeaders();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Return all HTTP headers that are in last response. It is possible to have several headers with same name.
     * 
     * @return A list of {@link HttpHeader} elements.
     */
    public List<HttpHeader> getResponseHeaders() {
        try {
            return tester.getResponseHeaders();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current html page in conversation matches an expected
     * value.
     *
     * @param title
     *            expected title value
     */
    public void assertTitleEquals(String title) {
        try {
            tester.assertTitleEquals(title);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current html page in conversation is not
     * equal to another value.
     *
     * @param title
     *            unexpected title value
     * @deprecated Replaced by {@link #assertTitleNotEquals(String)}
     */
    @Deprecated
    public void assertTitleNotSame(String title) {
        try {
            tester.assertTitleNotSame(title);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current html page in conversation is not
     * equal to another value.
     *
     * @param title
     *            unexpected title value
     */
    public void assertTitleNotEquals(String title) {
        try {
            tester.assertTitleNotEquals(title);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current html page in conversation matches an expected regexp.
     *
     * @param regexp expected title regexp
     */
    public void assertTitleMatch(String regexp) {
        try {
            tester.assertTitleMatch(regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current html page matches the value of a specified web
     * resource.
     *
     * @param titleKey
     *            web resource key for title
     */
    public void assertTitleEqualsKey(String titleKey) {
        try {
            tester.assertTitleEqualsKey(titleKey);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert title of current page matches formatted message resource
     *
     * @param titleKey
     * @param args
     */
    public void assertTitleEqualsKey(String titleKey, Object[] args) {
        try {
            tester.assertTitleEqualsKey(titleKey, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a web resource's value is present.
     *
     * @param key
     *            web resource name
     */
    public void assertKeyPresent(String key) {
        try {
            tester.assertKeyPresent(key);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a web resource's value (with formatting) is present
     *
     * @param key
     * @param args
     */
    public void assertKeyPresent(String key, Object[] args) {
        try {
            tester.assertKeyPresent(key, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied text is present.
     *
     * @param text
     */
    public void assertTextPresent(String text) {
        try {
            tester.assertTextPresent(text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied regexp is matched in the text of a page.
     *
     * @param regexp
     */
    public void assertMatch(String regexp) {
        try {
            tester.assertMatch(regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a given string matches a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public void assertMatch(String regexp, String text) {
        try {
            tester.assertMatch(regexp, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a given string does not match a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public void assertNotMatch(String regexp, String text) {
        try {
            tester.assertNotMatch(regexp, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a given string matches a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public void assertMatch(String message, String regexp, String text) {
        try {
            tester.assertMatch(message, regexp, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a given string does not match a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public void assertNotMatch(String message, String regexp, String text) {
        try {
            tester.assertNotMatch(message, regexp, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a web resource's value is not present.
     *
     * @param key web resource name
     */
    public void assertKeyNotPresent(String key) {
        try {
            tester.assertKeyNotPresent(key);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a web resource's formatted value is not present.
     *
     * @param key
     *            web resource name
     */
    public void assertKeyNotPresent(String key, Object[] args) {
        try {
            tester.assertKeyNotPresent(key, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied text is not present.
     *
     * @param text
     */
    public void assertTextNotPresent(String text) {
        try {
            tester.assertTextNotPresent(text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied regexp is not present.
     *
     * @param regexp
     */
    public void assertNoMatch(String regexp) {
        try {
            tester.assertNoMatch(regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     *
     * @param tableSummaryNameOrId
     * @return Object that represent a html table in a way independent from plugin.
     */
    public Table getTable(String tableSummaryNameOrId) {
        try {
            return tester.getTable(tableSummaryNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a table with a given summary or id value is present.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     */
    public void assertTablePresent(String tableSummaryNameOrId) {
        try {
            tester.assertTablePresent(tableSummaryNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a table with a given summary or id value is not present.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     */
    public void assertTableNotPresent(String tableSummaryNameOrId) {
        try {
            tester.assertTableNotPresent(tableSummaryNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the value of a given web resource is present in a specific table.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param key web resource name
     */
    public void assertKeyInTable(String tableSummaryOrId, String key) {
        try {
            tester.assertKeyInTable(tableSummaryOrId, key);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the value of a given web resource is present in a specific
     * table.
     *
     * @param tableSummaryOrId
     *            summary or id attribute value of table
     * @param key
     *            web resource name
     */
    public void assertKeyInTable(String tableSummaryOrId, String key, Object[] args) {
        try {
            tester.assertKeyInTable(tableSummaryOrId, key, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied text is present in a specific table.
     *
     * @param tableSummaryNameOrId
     *            summary, name or id attribute value of table
     * @param text
     */
    public void assertTextInTable(String tableSummaryNameOrId, String text) {
        try {
            tester.assertTextInTable(tableSummaryNameOrId, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied regexp is matched in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param regexp
     */
    public void assertMatchInTable(String tableSummaryNameOrId, String regexp) {
        try {
            tester.assertMatchInTable(tableSummaryNameOrId, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of a set of web resources are all present in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param keys Array of web resource names.
     */
    public void assertKeysInTable(String tableSummaryOrId, String[] keys) {
        try {
            tester.assertKeysInTable(tableSummaryOrId, keys);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of a set of web resources are all present in a
     * specific table.
     *
     * @param tableSummaryOrId
     *            summary or id attribute value of table
     * @param keys
     *            Array of web resource names.
     */
    public void assertKeysInTable(String tableSummaryOrId, String[] keys, Object[][] args) {
        try {
            tester.assertKeysInTable(tableSummaryOrId, keys, args);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a set of text values are all present in a specific table.
     *
     * @param tableSummaryOrId
     *            summary, name or id attribute value of table
     * @param text
     *            Array of expected text values.
     */
    public void assertTextInTable(String tableSummaryOrId, String[] text) {
        try {
            tester.assertTextInTable(tableSummaryOrId, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a set of regexp values are all matched in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param text Array of expected regexps to match.
     */
    public void assertMatchInTable(String tableSummaryOrId, String[] regexp) {
        try {
            tester.assertMatchInTable(tableSummaryOrId, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the value of a given web resource is not present in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param key web resource name
     */
    public void assertKeyNotInTable(String tableSummaryOrId, String key) {
        try {
            tester.assertKeyNotInTable(tableSummaryOrId, key);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied text is not present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text
     */
    public void assertTextNotInTable(String tableSummaryNameOrId, String text) {
        try {
            tester.assertTextNotInTable(tableSummaryNameOrId, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that none of a set of text values are present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text Array of text values
     */
    public void assertTextNotInTable(String tableSummaryNameOrId, String[] text) {
        try {
            tester.assertTextNotInTable(tableSummaryNameOrId, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that supplied regexp is not present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text
     */
    public void assertNoMatchInTable(String tableSummaryNameOrId, String regexp) {
        try {
            tester.assertNoMatchInTable(tableSummaryNameOrId, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that none of a set of regexp values are present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text Array of text values
     */
    public void assertNoMatchInTable(String tableSummaryNameOrId, String[] regexp) {
        try {
            tester.assertNoMatchInTable(tableSummaryNameOrId, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific table matches an ExpectedTable.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedTable represents expected values (colspan supported).
     */
    public void assertTableEquals(String tableSummaryNameOrId, Table expectedTable) {
        try {
            tester.assertTableEquals(tableSummaryNameOrId, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedCellValues double dimensional array of expected values
     */
    public void assertTableEquals(String tableSummaryNameOrId, String[][] expectedCellValues) {
        try {
            tester.assertTableEquals(tableSummaryNameOrId, expectedCellValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected values (colspan and rowspan supported).
     */
    public void assertTableRowsEqual(String tableSummaryNameOrId, int startRow, Table expectedTable) {
        try {
            tester.assertTableRowsEqual(tableSummaryNameOrId, startRow, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected values (colspan and rowspan supported).
     */
    public void assertTableRowsEqual(String tableSummaryNameOrId, int startRow, String[][] expectedTable) {
        try {
            tester.assertTableRowsEqual(tableSummaryNameOrId, startRow, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the number of rows for a specific table equals expected value.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedRowCount expected row count.
     */
    public void assertTableRowCountEquals(String tableSummaryNameOrId, int expectedRowCount) {
        try {
            tester.assertTableRowCountEquals(tableSummaryNameOrId, expectedRowCount);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific table matches an ExpectedTable.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param expectedTable represents expected regexps (colspan supported).
     */
    public void assertTableMatch(String tableSummaryOrId, Table expectedTable) {
        try {
            tester.assertTableMatch(tableSummaryOrId, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param expectedCellValues double dimensional array of expected regexps
     */
    public void assertTableMatch(String tableSummaryOrId, String[][] expectedCellValues) {
        try {
            tester.assertTableMatch(tableSummaryOrId, expectedCellValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected regexps (colspan and rowspan supported).
     */
    public void assertTableRowsMatch(String tableSummaryOrId, int startRow, Table expectedTable) {
        try {
            tester.assertTableRowsMatch(tableSummaryOrId, startRow, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected regexps (colspan and rowspan not supported).
     */
    public void assertTableRowsMatch(String tableSummaryOrId, int startRow, String[][] expectedTable) {
        try {
            tester.assertTableRowsMatch(tableSummaryOrId, startRow, expectedTable);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a form input element with a given name is present.
     *
     * @param formElementName
     */
    public void assertFormElementPresent(String formElementName) {
        try {
            tester.assertFormElementPresent(formElementName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a form input element with a given name is not present.
     *
     * @param formElementName
     */
    public void assertFormElementNotPresent(String formElementName) {
        try {
            tester.assertFormElementNotPresent(formElementName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a form checkbox with a given name is present.
     *
     * @param checkboxName checkbox name.
     */
    public void assertCheckboxPresent(String checkboxName) {
        try {
            tester.assertCheckboxPresent(checkboxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a given checkbox is present.
     *
     * @param checkboxName checkbox name attribut.
     * @param checkboxValue checkbox value attribut.
     */
    public void assertCheckboxPresent(String checkboxName, String checkboxValue) {
        try {
            tester.assertCheckboxPresent(checkboxName, checkboxValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a form checkbox with a given name is not present.
     *
     * @param checkboxName checkbox name.
     */
    public void assertCheckboxNotPresent(String checkboxName) {
        try {
            tester.assertCheckboxNotPresent(checkboxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a given checkbox is not present.
     *
     * @param checkboxName checkbox name.
     * @param checkboxValue checkbox value attribut.
     */
    public void assertCheckboxNotPresent(String checkboxName, String checkboxValue) {
        try {
            tester.assertCheckboxNotPresent(checkboxName, checkboxValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that there is a form present.
     *
     */
    public void assertFormPresent() {
        try {
            tester.assertFormPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that there is a form with the specified name or id present.
     *
     * @param nameOrID
     */
    public void assertFormPresent(String nameOrID) {
        try {
            tester.assertFormPresent(nameOrID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that there is not a form present.
     *
     */
    public void assertFormNotPresent() {
        try {
            tester.assertFormNotPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that there is not a form with the specified name or id present.
     *
     * @param nameOrID
     */
    public void assertFormNotPresent(String nameOrID) {
        try {
            tester.assertFormNotPresent(nameOrID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific form element has an expected value. Can be used to check hidden input.
     *
     * @param formElementName
     * @param expectedValue
     * @see #assertTextFieldEquals(String, String)
     * @deprecated use an explicit testing method, e.g. {@link #assertTextFieldEquals(String, String)}
     */
    public void assertFormElementEquals(String formElementName, String expectedValue) {
        try {
            tester.assertFormElementEquals(formElementName, expectedValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific form element matches an expected regexp.
     *
     * @param formElementName
     * @param regexp
     */
    public void assertFormElementMatch(String formElementName, String regexp) {
        try {
            tester.assertFormElementMatch(formElementName, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a form element had no value / is empty.
     *
     * @param formElementName
     * @see #setTextField(String, String)
     * @see #setHiddenField(String, String)
     * @deprecated use an explicit testing method, e.g. {@link #setTextField(String, String)} or {@link #setHiddenField(String, String)} 
     */
    public void assertFormElementEmpty(String formElementName) {
        try {
            tester.assertFormElementEmpty(formElementName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an input text element with name <code>formElementName</code> has the <code>expectedValue</code>
     * value.
     *
     * @param formElementName the value of the name attribute of the element
     * @param expectedValue the expected value of the given input element
     */
    public void assertTextFieldEquals(String formElementName, String expectedValue) {
        try {
            tester.assertTextFieldEquals(formElementName, expectedValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an input hidden element with name <code>formElementName</code> has the <code>expectedValue</code>
     * value.
     *
     * @param formElementName the value of the name attribute of the element
     * @param expectedValue the expected value of the given input element
     */
    public void assertHiddenFieldPresent(String formElementName, String expectedValue) {
        try {
            tester.assertHiddenFieldPresent(formElementName, expectedValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific checkbox is selected.
     *
     * @param checkBoxName
     */
    public void assertCheckboxSelected(String checkBoxName) {
        try {
            tester.assertCheckboxSelected(checkBoxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific checkbox is selected.
     *
     * @param checkBoxName
     * @param checkBoxValue
     */
    public void assertCheckboxSelected(String checkBoxName, String checkBoxValue) {
        try {
            tester.assertCheckboxSelected(checkBoxName, checkBoxValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific checkbox is not selected.
     *
     * @param checkBoxName
     */
    public void assertCheckboxNotSelected(String checkBoxName) {
        try {
            tester.assertCheckboxNotSelected(checkBoxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific checkbox is not selected.
     *
     * @param checkBoxName
     * @param checkBoxValue
     */
    public void assertCheckboxNotSelected(String checkBoxName, String checkBoxValue) {
        try {
            tester.assertCheckboxNotSelected(checkBoxName, checkBoxValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is present in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for.
     */
    public void assertRadioOptionPresent(String name, String radioOption) {
        try {
            tester.assertRadioOptionPresent(name, radioOption);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is not present in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for.
     */
    public void assertRadioOptionNotPresent(String name, String radioOption) {
        try {
            tester.assertRadioOptionNotPresent(name, radioOption);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is selected in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for selection.
     */
    public void assertRadioOptionSelected(String name, String radioOption) {
        try {
            tester.assertRadioOptionSelected(name, radioOption);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is not selected in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for selection.
     */
    public void assertRadioOptionNotSelected(String name, String radioOption) {
        try {
            tester.assertRadioOptionNotSelected(name, radioOption);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that given options are present in a select box (by label).
     *
     * @param selectName name of the select element.
     * @param optionLabels option labels.
     */
    public void assertSelectOptionsPresent(String selectName, String[] optionLabels) {
        try {
            tester.assertSelectOptionsPresent(selectName, optionLabels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is present in a select box (by label).
     *
     * @param selectName name of the select element.
     * @param optionLabel option label.
     */
    public void assertSelectOptionPresent(String selectName, String optionLabel) {
        try {
            tester.assertSelectOptionPresent(selectName, optionLabel);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that given options are present in the Nth select box (by label).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionLabels option labels.
     */
    public void assertSelectOptionsPresent(String selectName, int index, String[] optionLabels) {
        try {
            tester.assertSelectOptionsPresent(selectName, index, optionLabels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is present in the Nth select box (by label).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionLabel option label.
     */
    public void assertSelectOptionPresent(String selectName, int index, String optionLabel) {
        try {
            tester.assertSelectOptionPresent(selectName, index, optionLabel);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that given options are present in a select box (by value).
     *
     * @param selectName name of the select element.
     * @param optionValues option labels.
     */
    public void assertSelectOptionValuesPresent(String selectName, String[] optionValues) {
        try {
            tester.assertSelectOptionValuesPresent(selectName, optionValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is present in a select box (by value).
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public void assertSelectOptionValuePresent(String selectName, String optionValue) {
        try {
            tester.assertSelectOptionValuePresent(selectName, optionValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that given options are present in the Nth select box (by value).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionValues option labels.
     */
    public void assertSelectOptionValuesPresent(String selectName, int index, String[] optionValues) {
        try {
            tester.assertSelectOptionValuesPresent(selectName, index, optionValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is present in the Nth select box (by value).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionValue option value.
     */
    public void assertSelectOptionValuePresent(String selectName, int index, String optionValue) {
        try {
            tester.assertSelectOptionValuePresent(selectName, index, optionValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option value is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public void assertSelectOptionValueNotPresent(String selectName, String optionValue) {
        try {
            tester.assertSelectOptionValueNotPresent(selectName, optionValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param expectedOption option label.
     */
    public void assertSelectOptionNotPresent(String selectName, String optionLabel) {
        try {
            tester.assertSelectOptionNotPresent(selectName, optionLabel);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option value is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public void assertSelectOptionValueNotPresent(String selectName, int index, String optionValue) {
        try {
            tester.assertSelectOptionValueNotPresent(selectName, index, optionValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a specific option is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param expectedOption option label.
     */
    public void assertSelectOptionNotPresent(String selectName, int index, String optionLabel) {
        try {
            tester.assertSelectOptionNotPresent(selectName, index, optionLabel);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the display values of a select element's options match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedOptions expected labels for the select box.
     */
    public void assertSelectOptionsEqual(String selectName, String[] expectedOptions) {
        try {
            tester.assertSelectOptionsEqual(selectName, expectedOptions);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the display values of
     * the Nth select element's options match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param expectedOptions expected labels for the select box.
     */
    public void assertSelectOptionsEqual(String selectName, int index, String[] expectedOptions) {
        try {
            tester.assertSelectOptionsEqual(selectName, index, expectedOptions);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the display values of a select element's options do not match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedOptions expected display values for the select box.
     */
    public void assertSelectOptionsNotEqual(String selectName, String[] expectedOptions) {
        try {
            tester.assertSelectOptionsNotEqual(selectName, expectedOptions);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the display values of the Nth select element's
     * options do not match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param expectedOptions expected display values for the select box.
     */
    public void assertSelectOptionsNotEqual(String selectName, int index, String[] expectedOptions) {
        try {
            tester.assertSelectOptionsNotEqual(selectName, index, expectedOptions);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of the Nth select element's options match
     * a given array of strings.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param expectedValues expected values for the select box.
     */
    public void assertSelectOptionValuesEqual(String selectName, int index, String[] expectedValues) {
        try {
            tester.assertSelectOptionValuesEqual(selectName, index, expectedValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of a select element's options match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedValues expected values for the select box.
     */
    public void assertSelectOptionValuesEqual(String selectName, String[] expectedValues) {
        try {
            tester.assertSelectOptionValuesEqual(selectName, expectedValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of a select element's options do not match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param optionValues expected values for the select box.
     */
    public void assertSelectOptionValuesNotEqual(String selectName, String[] optionValues) {
        try {
            tester.assertSelectOptionValuesNotEqual(selectName, optionValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the values of the Nth select element's options do not match a
     * given array of strings.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionValues expected values for the select box.
     */
    public void assertSelectOptionValuesNotEqual(String selectName, int index, String[] optionValues) {
        try {
            tester.assertSelectOptionValuesNotEqual(selectName, index, optionValues);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected display label(s) of a select box matches given label(s).
     *
     * @param selectName name of the select element.
     * @param labels expected display label(s) of the selected option.
     */
    public void assertSelectedOptionsEqual(String selectName, String[] labels) {
        try {
            tester.assertSelectedOptionsEqual(selectName, labels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected display label(s) of a select box matches given label(s).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param labels expected display label(s) of the selected option.
     */
    public void assertSelectedOptionsEqual(String selectName, int index, String[] labels) {
        try {
            tester.assertSelectedOptionsEqual(selectName, index, labels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided value.
     * @param selectName name of the select element
     * @param optionLabel expected value of the option label
     */
    public void assertSelectedOptionEquals(String selectName, String optionLabel) {
        try {
            tester.assertSelectedOptionEquals(selectName, optionLabel);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided value in the Nth select element with the specified name.
     * @param selectName name of the select element
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param optionLabel expected value of the option label
     */
    public void assertSelectedOptionEquals(String selectName, int index, String option) {
        try {
            tester.assertSelectedOptionEquals(selectName, index, option);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected value(s) of a select box matches given value(s).
     *
     * @param selectName name of the select element.
     * @param values expected value(s) of the selected option.
     */
    public void assertSelectedOptionValuesEqual(String selectName, String[] values) {
        try {
            tester.assertSelectedOptionValuesEqual(selectName, values);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected value(s) of the Nth
     * select box with the specified name matches given value(s).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param values expected value(s) of the selected option.
     */
    public void assertSelectedOptionValuesEqual(String selectName, int index, String[] values) {
        try {
            tester.assertSelectedOptionValuesEqual(selectName, index, values);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected value of a select box matches given value.
     *
     * @param selectName name of the select element.
     * @param value expected value of the selected option.
     */
    public void assertSelectedOptionValueEquals(String selectName, String value) {
        try {
            tester.assertSelectedOptionValueEquals(selectName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected value of a select box matches given value.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param value expected value of the selected option.
     */
    public void assertSelectedOptionValueEquals(String selectName, int index, String value) {
        try {
            tester.assertSelectedOptionValueEquals(selectName, index, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected display value(s) of a select box matches a given value(s).
     *
     * @param selectName name of the select element.
     * @param regexps expected display value of the selected option.
     */
    public void assertSelectedOptionsMatch(String selectName, String[] regexps) {
        try {
            tester.assertSelectedOptionsMatch(selectName, regexps);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the currently selected display value(s) of a select box matches a given value(s).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param regexps expected display value of the selected option.
     */
    public void assertSelectedOptionsMatch(String selectName, int index, String[] regexps) {
        try {
            tester.assertSelectedOptionsMatch(selectName, index, regexps);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided regular expression value.
     * @param selectName name of the select element
     * @param regexp the regular expression to match
     */
    public void assertSelectedOptionMatches(String selectName, String regexp) {
        try {
            tester.assertSelectedOptionMatches(selectName, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided regular expression in the Nth select element with the specified name.
     * @param selectName name of the select element
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param regexp the regular expression to match
     */
    public void assertSelectedOptionMatches(String selectName, int index, String regexp) {
        try {
            tester.assertSelectedOptionMatches(selectName, index, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a submit button is present. <br/> A submit button can be the following HTML elements:
     * <ul>
     * <li>submit input
     * <li>image input
     * <li>submit button
     * </ul>
     *
     */
    public void assertSubmitButtonPresent() {
        try {
            tester.assertSubmitButtonPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a submit button with a given name is present. <br/> A submit button can be the following HTML
     * elements:
     * <ul>
     * <li>submit input
     * <li>image input
     * <li>submit button
     * </ul>
     *
     * @param buttonName
     */
    public void assertSubmitButtonPresent(String buttonName) {
        try {
            tester.assertSubmitButtonPresent(buttonName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no submit button is present in the current form. <br/> A submit button can be the following HTML
     * elements:
     * <ul>
     * <li>submit input
     * <li>image input
     * <li>submit button
     * </ul>
     *
     * @param buttonName
     */
    public void assertSubmitButtonNotPresent() {
        try {
            tester.assertSubmitButtonNotPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a submit button with a given name is not present. <br/> A submit button can be the following HTML
     * elements:
     * <ul>
     * <li>submit input
     * <li>image input
     * <li>submit button
     * </ul>
     *
     * @param buttonName
     */
    public void assertSubmitButtonNotPresent(String buttonName) {
        try {
            tester.assertSubmitButtonNotPresent(buttonName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a submit button with a given name and value is present. <br/> A submit button can be the following
     * HTML elements:
     * <ul>
     * <li>submit input
     * <li>image input
     * <li>submit button
     * </ul>
     *
     * @param buttonName
     * @param buttonValue
     */
    public void assertSubmitButtonPresent(String buttonName, String buttonValue) {
        try {
            tester.assertSubmitButtonPresent(buttonName, buttonValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a reset button is present. <br/> A reset button can be the following HTML elements:
     * <ul>
     * <li>reset input
     * <li>reset button
     * </ul>
     *
     */
    public void assertResetButtonPresent() {
        try {
            tester.assertResetButtonPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a reset button with a given name is present.<br/> A reset button can be the following HTML elements:
     * <ul>
     * <li>reset input
     * <li>reset button
     * </ul>
     *
     * @param buttonName
     */
    public void assertResetButtonPresent(String buttonName) {
        try {
            tester.assertResetButtonPresent(buttonName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no reset button is present in the current form.<br/> A reset button can be the following HTML
     * elements:
     * <ul>
     * <li>reset input
     * <li>reset button
     * </ul>
     *
     * @param buttonName
     */
    public void assertResetButtonNotPresent() {
        try {
            tester.assertResetButtonNotPresent();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a reset button with a given name is not present.<br/> A reset button can be the following HTML
     * elements:
     * <ul>
     * <li>reset input
     * <li>reset button
     * </ul>
     *
     * @param buttonName
     */
    public void assertResetButtonNotPresent(String buttonName) {
        try {
            tester.assertResetButtonNotPresent(buttonName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a button with a given id is present in the current window.<br/> A button can be the following HTML
     * elements:
     * <ul>
     * <li>button input
     * <li>button button
     * </ul>
     *
     * @param buttonId
     */
    public void assertButtonPresent(String buttonId) {
        try {
            tester.assertButtonPresent(buttonId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a button with a given text is present in the current window.
     *
     * @param text Text representation of button content.
     */
    public void assertButtonPresentWithText(String text) {
        try {
            tester.assertButtonPresentWithText(text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a button with a given text is not present in the current window.
     *
     * @param text Text representation of button content.
     */
    public void assertButtonNotPresentWithText(String text) {
        try {
            tester.assertButtonNotPresentWithText(text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a button with a given id is not present in the current window.
     *
     * @param buttonId
     */
    public void assertButtonNotPresent(String buttonId) {
        try {
            tester.assertButtonNotPresent(buttonId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link with a given id is present in the response.
     *
     * @param linkId
     */
    public void assertLinkPresent(String linkId) {
        try {
            tester.assertLinkPresent(linkId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no link with the given id is present in the response.
     *
     * @param linkId
     */
    public void assertLinkNotPresent(String linkId) {
        try {
            tester.assertLinkNotPresent(linkId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing the supplied text is present.
     *
     * @param linkText
     */
    public void assertLinkPresentWithText(String linkText) {
        try {
            tester.assertLinkPresentWithText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no link containing the supplied text is present.
     *
     * @param linkText
     */
    public void assertLinkNotPresentWithText(String linkText) {
        try {
            tester.assertLinkNotPresentWithText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing the supplied text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void assertLinkPresentWithText(String linkText, int index) {
        try {
            tester.assertLinkPresentWithText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no link containing the supplied text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void assertLinkNotPresentWithText(String linkText, int index) {
        try {
            tester.assertLinkNotPresentWithText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing the Exact text is present.
     *
     * @param linkText
     */
    public void assertLinkPresentWithExactText(String linkText) {
        try {
            tester.assertLinkPresentWithExactText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no link containing the Exact text is present.
     *
     * @param linkText
     */
    public void assertLinkNotPresentWithExactText(String linkText) {
        try {
            tester.assertLinkNotPresentWithExactText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing the Exact text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void assertLinkPresentWithExactText(String linkText, int index) {
        try {
            tester.assertLinkPresentWithExactText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that no link containing the Exact text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void assertLinkNotPresentWithExactText(String linkText, int index) {
        try {
            tester.assertLinkNotPresentWithExactText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing a specified image is present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public void assertLinkPresentWithImage(String imageFileName) {
        try {
            tester.assertLinkPresentWithImage(imageFileName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing a specified image is present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public void assertLinkPresentWithImage(String imageFileName, int index) {
        try {
            tester.assertLinkPresentWithImage(imageFileName, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing a specified image is not present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public void assertLinkNotPresentWithImage(String imageFileName) {
        try {
            tester.assertLinkNotPresentWithImage(imageFileName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a link containing a specified image is not present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public void assertLinkNotPresentWithImage(String imageFileName, int index) {
        try {
            tester.assertLinkNotPresentWithImage(imageFileName, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an element with a given id is present.
     *
     * @param anID element id to test for.
     */
    public void assertElementPresent(String anID) {
        try {
            tester.assertElementPresent(anID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an element with a given id is not present.
     *
     * @param anID element id to test for.
     */
    public void assertElementNotPresent(String anID) {
        try {
            tester.assertElementNotPresent(anID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an element with a given xpath is present.
     *
     * @param xpath element xpath to test for.
     */
    public void assertElementPresentByXPath(String xpath) {
        try {
            tester.assertElementPresentByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that an element with a given xpath is not present.
     *
     * @param xpath element xpath to test for.
     */
    public void assertElementNotPresentByXPath(String xpath) {
        try {
            tester.assertElementNotPresentByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get all the comments in a document, as a list of strings.
     */
    public List<String> getComments() {
        try {
            return tester.getComments();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a comment is present.
     * 
     * @param comment
     */
    public void assertCommentPresent(String comment) {
        try {
            tester.assertCommentPresent(comment);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a comment is not present.
     * 
     * @param comment
     */
    public void assertCommentNotPresent(String comment) {
        try {
            tester.assertCommentNotPresent(comment);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a given element contains specific text.
     *
     * @param elementID id of element to be inspected.
     * @param text to check for.
     */
    public void assertTextInElement(String elementID, String text) {
        try {
            tester.assertTextInElement(elementID, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    
    public void assertTextNotInElement(String elementID, String text) {
        try {
            tester.assertTextNotInElement(elementID, text);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a given element matches a specific regexp.
     *
     * @param elementID id of element to be inspected.
     * @param regexp to match.
     */
    public void assertMatchInElement(String elementID, String regexp) {
        try {
            tester.assertMatchInElement(elementID, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a given element does not match a specific regexp.
     *
     * @param elementID id of element to be inspected.
     * @param regexp to match.
     */
    public void assertNoMatchInElement(String elementID, String regexp) {
        try {
            tester.assertNoMatchInElement(elementID, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a window with the given name is open.
     *
     * @param windowName
     */
    public void assertWindowPresent(String windowName) {
        try {
            tester.assertWindowPresent(windowName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a window with the given ID is open.
     *
     * @param windowID Javascript window ID.
     */
    public void assertWindowPresent(int windowID) {
        try {
            tester.assertWindowPresent(windowID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that at least one window with the given title is open.
     *
     * @param title
     */
    public void assertWindowPresentWithTitle(String title) {
        try {
            tester.assertWindowPresentWithTitle(title);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that the number of opened windows equals given value.
     *
     * @param windowCount Window count
     */
    public void assertWindowCountEquals(int windowCount) {
        try {
            tester.assertWindowCountEquals(windowCount);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a frame with the given name or ID is present.
     *
     * @param frameNameOrId Name or ID of the frame. ID is checked first.
     */
    public void assertFramePresent(String frameNameOrId) {
        try {
            tester.assertFramePresent(frameNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Checks to see if a cookie is present in the response.
     *
     * @param cookieName The cookie name
     */
    public void assertCookiePresent(String cookieName) {
        try {
            tester.assertCookiePresent(cookieName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Check to see if a cookie has the given value.
     *
     * @param cookieName The cookie name
     * @param expectedValue The cookie value
     */
    public void assertCookieValueEquals(String cookieName, String expectedValue) {
        try {
            tester.assertCookieValueEquals(cookieName, expectedValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Check to see if a cookie value match the given regexp.
     *
     * @param cookieName The cookie name
     * @param regexp The regexp
     */
    public void assertCookieValueMatch(String cookieName, String regexp) {
        try {
            tester.assertCookieValueMatch(cookieName, regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * @deprecated Use {@link WebTester#getElementAttributeByXPath(String, String)}
     */
    public String getFormElementValue(String formElementName) {
        try {
            return tester.getFormElementValue(formElementName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Begin interaction with a specified form. If form interaction methods are called without explicitly calling this
     * method first, JWebUnit will attempt to determine itself which form is being manipulated.
     *
     * It is not necessary to call this method if their is only one form on the current page.
     *
     * @param index 0-based index of the form to work with.
     */
    public void setWorkingForm(int index) {
        try {
            tester.setWorkingForm(index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Begin interaction with a specified form. If form interaction methods are called without explicitly calling this
     * method first, JWebUnit will attempt to determine itself which form is being manipulated.
     *
     * It is not necessary to call this method if their is only one form on the current page.
     *
     * @param nameOrId name or id of the form to work with.
     */
    public void setWorkingForm(String nameOrId) {
        try {
            tester.setWorkingForm(nameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Begin interaction with a specified form. If form interaction methods are called without explicitly calling this
     * method first, JWebUnit will attempt to determine itself which form is being manipulated.
     *
     * It is not necessary to call this method if their is only one form on the current page.
     *
     * @param nameOrId name or id of the form to work with.
     * @param index The 0-based index, when more than one form with the same name is expected.
     */
    public void setWorkingForm(String nameOrId, int index) {
        try {
            tester.setWorkingForm(nameOrId, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the value of a text or password input field.
     *
     * @param inputName name of form element.
     * @param value value to set.
     */
    public void setTextField(String inputName, String value) {
        try {
            tester.setTextField(inputName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the value of an hidden input field.
     *
     * @param inputName name of form element.
     * @param value value to set.
     */
    public void setHiddenField(String inputName, String value) {
        try {
            tester.setHiddenField(inputName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select a specified checkbox. If the checkbox is already checked then the checkbox will stay checked.
     *
     * @param checkBoxName name of checkbox to be selected.
     */
    public void checkCheckbox(String checkBoxName) {
        try {
            tester.checkCheckbox(checkBoxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select a specified checkbox. If the checkbox is already checked then the checkbox will stay checked.
     *
     * @param checkBoxName name of checkbox to be selected.
     * @param value value of checkbox to be selected.
     */
    public void checkCheckbox(String checkBoxName, String value) {
        try {
            tester.checkCheckbox(checkBoxName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Deselect a specified checkbox. If the checkbox is already unchecked then the checkbox will stay unchecked.
     *
     * @param checkBoxName name of checkbox to be deselected.
     */
    public void uncheckCheckbox(String checkBoxName) {
        try {
            tester.uncheckCheckbox(checkBoxName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Deselect a specified checkbox. If the checkbox is already unchecked then the checkbox will stay unchecked.
     *
     * @param checkBoxName name of checkbox to be deselected.
     * @param value value of checkbox to be deselected.
     */
    public void uncheckCheckbox(String checkBoxName, String value) {
        try {
            tester.uncheckCheckbox(checkBoxName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select options with given display labels in a select element.
     *
     * @param selectName name of select element.
     * @param labels labels of options to be selected.
     */
    public void selectOptions(String selectName, String[] labels) {
        try {
            tester.selectOptions(selectName, labels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select an option with a given display label in a select element.
     *
     * @param selectName name of select element.
     * @param label label of option to be selected.
     */
    public void selectOption(String selectName, String label) {
        try {
            tester.selectOption(selectName, label);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select an option with a given display label in Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param label label of option to be selected.
     */
    public void selectOption(String selectName, int index, String label) {
        try {
            tester.selectOption(selectName, index, label);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select options with given display labels in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param labels labels of options to be selected.
     */
    public void selectOptions(String selectName, int index, String[] labels) {
        try {
            tester.selectOptions(selectName, index, labels);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select options with given values in a select element.
     *
     * @param selectName name of select element.
     * @param values values of options to be selected.
     */
    public void selectOptionsByValues(String selectName, String[] values) {
        try {
            tester.selectOptionsByValues(selectName, values);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select an option with a given value in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param values values of options to be selected.
     */
    public void selectOptionByValue(String selectName, String value) {
        try {
            tester.selectOptionByValue(selectName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select options with given values in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param values values of options to be selected.
     */
    public void selectOptionsByValues(String selectName, int index, String[] values) {
        try {
            tester.selectOptionsByValues(selectName, index, values);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Select an option with a given value in a select element.
     *
     * @param selectName name of select element.
     * @param values values of options to be selected.
     */
    public void selectOptionByValue(String selectName, int index, String value) {
        try {
            tester.selectOptionByValue(selectName, index, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Submit form - default submit button will be used (unnamed submit button, or named button if there is only one on
     * the form.
     */
    public void submit() {
        try {
            tester.submit();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Submit form by pressing named button.
     *
     * @param buttonName Submit button name attribut value.
     */
    public void submit(String buttonName) {
        try {
            tester.submit(buttonName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Submit the form by pressing the named button with the given value (label). Useful if you have more than one
     * submit button with same name.
     *
     * @param buttonName Submit button name attribut value.
     * @param buttonValue Submit button value attribut value.
     */
    public void submit(String buttonName, String buttonValue) {
        try {
            tester.submit(buttonName, buttonValue);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Reset the current form using the default reset button. See {@link #getForm}for an explanation of how the current
     * form is established.
     */
    public void reset() {
        try {
            tester.reset();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selection of a link containing given text.
     *
     * @param linkText Text in the link.
     */
    public void clickLinkWithText(String linkText) {
        try {
            tester.clickLinkWithText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selecting Nth link containing given text.
     *
     * @param linkText Text in the link.
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void clickLinkWithText(String linkText, int index) {
        try {
            tester.clickLinkWithText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selection of a link with the exact given text.
     *
     * @param linkText Text of the link.
     */
    public void clickLinkWithExactText(String linkText) {
        try {
            tester.clickLinkWithExactText(linkText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selecting Nth link with the exact given text.
     *
     * @param linkText Text of the link.
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public void clickLinkWithExactText(String linkText, int index) {
        try {
            tester.clickLinkWithExactText(linkText, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Click the button with the given id.
     *
     * @param buttonId Button ID attribut value.
     */
    public void clickButton(String buttonId) {
        try {
            tester.clickButton(buttonId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Clicks a button with <code>text</code> of the value attribute.
     *
     * @param buttonValueText The text of the button (contents of the value attribute).
     */
    public void clickButtonWithText(String buttonValueText) {
        try {
            tester.clickButtonWithText(buttonValueText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selection of a link with a given image.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public void clickLinkWithImage(String imageFileName) {
        try {
            tester.clickLinkWithImage(imageFileName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selection of a link with a given image.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public void clickLinkWithImage(String imageFileName, int index) {
        try {
            tester.clickLinkWithImage(imageFileName, index);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Navigate by selection of a link with given id.
     *
     * @param linkId id of link
     */
    public void clickLink(String linkId) {
        try {
            tester.clickLink(linkId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Clicks a radio option. Asserts that the radio option exists first. *
     *
     * @param radioGroup name of the radio group.
     * @param radioOption value of the option to check for.
     */
    public void clickRadioOption(String radioGroup, String radioOption) {
        try {
            tester.clickRadioOption(radioGroup, radioOption);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Click element with given xpath.
     *
     * @param xpath xpath of the element.
     */
    public void clickElementByXPath(String xpath) {
        try {
            tester.clickElementByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get the attribute value of the given element. 
     * For example, if you have an element <code>&lt;img src="test.gif" alt="picture"&gt;</code>
     * getElementAttributeByXPath("//img[@src='test.gif']", "alt") returns "picture".
     *
     * @param xpath XPath of the element
     * @param attribute Name of the attribute
     * @return The value of the attribute
     */
    public String getElementAttributeByXPath(String xpath, String attribute) {
        try {
            return tester.getElementAttributeByXPath(xpath, attribute);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * @deprecated Use {@link #getElementAttributeByXPath(String, String)} 
     */
    public String getElementAttributByXPath(String xpath, String attribute) {
        try {
            return tester.getElementAttributByXPath(xpath, attribute);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get text of the given element.
     *
     * @param xpath xpath of the element.
     */
    public String getElementTextByXPath(String xpath) {
        try {
            return tester.getElementTextByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get an element for a particular xpath.
     *
     * @param xpath XPath to search
     * @return the requested element
	 * @throws AssertionError if the element xpath is not found
     */
    public IElement getElementByXPath(String xpath) {
        try {
            return tester.getElementByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get an element for a particular ID.
     *
     * @param id element ID to find
     * @return the requested element
	 * @throws AssertionError if the element is not found
     */
    public IElement getElementById(String id) {
        try {
            return tester.getElementById(id);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get elements for a particular xpath.
     *
     * @param xpath XPath to search
     * @return the requested elements found
     */
    public List<IElement> getElementsByXPath(String xpath) {
        try {
            return tester.getElementsByXPath(xpath);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a label for a given ID exists.
     */
    public void assertLabelPresent(String id) {
        try {
            tester.assertLabelPresent(id);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert a label exists.
     */
    public void assertLabelMatches(String regexp) {
        try {
            tester.assertLabelMatches(regexp);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get all the fields of type <code>input</code>, <code>textarea</code> or <code>select</code>
     * that are referenced or contained in a particular label.
     * 
     * @param label The label to consider
     * @return A list of all fields contained or referenced in this label
     */
    public List<IElement> getFieldsForLabel(IElement label) {
        try {
            return tester.getFieldsForLabel(label);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get the current value of a given labelled field. 
     * 
     * @param identifier the HTML ID for the given labelled field
     * @param label the label found for the given HTML ID
     * @return the value found in a field for the given label/ID, or 
     * 		<code>null</code> if none was found
     */
    public String getLabeledFieldValue(String identifier, IElement label) {
        try {
            return tester.getLabeledFieldValue(identifier, label);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert that a labeled field exists (for the given ID) and the
     * field that it labels equals the given text
     * 
     * @param id the HTML ID for the given labelled field
     * @param fieldText the text that the field's value should equal
     * @see #getLabeledFieldValue(String, IElement, String)
     * @see #getLabel(String)
     */
    public void assertLabeledFieldEquals(String id, String fieldText) {
        try {
            tester.assertLabeledFieldEquals(id, fieldText);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    
    public void setLabeledFormElementField(String id, String value) {
        try {
            tester.setLabeledFormElementField(id, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Make a given window active.
     *
     * @param windowName Name of the window.
     */
    public void gotoWindow(String windowName) {
        try {
            tester.gotoWindow(windowName);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Make a given window active.
     *
     * @param windowID Javascript ID of the window
     * @deprecated Javascript ID does'nt not exists. Currently this is an index
     * in the list of available windows, but this is not portable (and probably not stable).
     * Use {@link #gotoWindow(String)} or {@link #gotoWindowByTitle(String)} instead.
     */
    @Deprecated
    public void gotoWindow(int windowID) {
        try {
            tester.gotoWindow(windowID);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Make the root window active. Used to reset the effect of {@link ITestingEngine#gotoFrame(String)}.
     */
    public void gotoRootWindow() {
        try {
            tester.gotoRootWindow();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Make first window with the given title active.
     *
     * @param title Title of the window.
     */
    public void gotoWindowByTitle(String title) {
        try {
            tester.gotoWindowByTitle(title);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Make the given frame active.
     *
     * @param frameNameOrId Name or ID of the frame. ID is checked first.
     */
    public void gotoFrame(String frameNameOrId) {
        try {
            tester.gotoFrame(frameNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Go to the given page like if user has typed the URL manually in the browser. Use
     * {@link TestContext#setBaseUrl(String) getTestContext().setBaseUrl(String)} to define base URL. Absolute URL
     * should start with "http://", "https://" or "www.".
     *
     * @param url absolute or relative URL (relative to base URL).
     * @throws TestingEngineResponseException If something bad happend (404)
     */
    public void gotoPage(String url)throws TestingEngineResponseException {
        try {
            tester.gotoPage(url);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Print all the cookies to stdout.
     *
     */
    public void dumpCookies() {
        try {
            tester.dumpCookies();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get the source of the HTML page (like in a real browser), or HTTP body for a non HTML content.
     *
     * @return The HTML content.
     */
    public String getPageSource() {
        try {
            return tester.getPageSource();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Get the last data sent by the server.
     *
     * @return HTTP server response.
     */
    public String getServerResponse() {
        try {
            return tester.getServerResponse();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * @deprecated use {@link #getServerResponse()}
     * @return
     */
    public String getServeurResponse() {
        try {
            return tester.getServeurResponse();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Save the last downloaded page (or file) to the disk.
     *
     * @param f The file name.
     */
    public void saveAs(File f) {
        try {
            tester.saveAs(f);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Download the current page (or file) and compare it with the given file.
     *
     * @param expected Expected file URL.
     */
    public void assertDownloadedFileEquals(URL expected) {
        try {
            tester.assertDownloadedFileEquals(expected);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Dump html of current response to System.out - for debugging purposes.
     *
     * @param stream
     * @deprecated Use {@link WebTester#getPageSource()}
     */
    public void dumpHtml() {
        try {
            tester.dumpHtml();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Dump html of current response to a specified stream - for debugging purposes.
     *
     * @param stream
     * @deprecated Use {@link WebTester#getPageSource()}
     */
    public void dumpHtml(PrintStream stream) {
        try {
            tester.dumpHtml(stream);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Dump the table as the 2D array that is used for assertions - for debugging purposes.
     *
     * @param tableNameOrId
     * @param stream
     */
    public void dumpTable(String tableNameOrId) {
        try {
            tester.dumpTable(tableNameOrId);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Dump the table as the 2D array that is used for assertions - for debugging purposes.
     *
     * @param tableNameOrId
     * @param table
     * @param stream
     */
    public void dumpTable(String tableNameOrId, PrintStream stream) {
        try {
            tester.dumpTable(tableNameOrId, stream);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Enable or disable Javascript support
     */
    public void setScriptingEnabled(boolean value) {
        try {
            tester.setScriptingEnabled(value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the Testing Engine that you want to use for the tests based on the Testing Engine Key.
     *
     * @see TestingEngineRegistry
     * @param testingEngineKey The testingEngineKey to set.
     */
    public void setTestingEngineKey(String testingEngineKey) {
        try {
            tester.setTestingEngineKey(testingEngineKey);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Gets the Testing Engine Key that is used to find the proper testing engine class (HtmlUnitDialog /
     * SeleniumDialog) for the tests.
     *
     * @return Returns the testingEngineKey.
     */
    public String getTestingEngineKey() {
        try {
            return tester.getTestingEngineKey();
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the value of a form input element.
     *
     * @param formElementName name of form element.
     * @param value
     * @see #setTextField(String, String)
     * @deprecated use {@link #setTextField(String, String)} or other methods
     */
    public void setFormElement(String formElementName, String value) {
        try {
            tester.setFormElement(formElementName, value);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given alert box is expected.
     *
     * @param message Message in the alert.
     */
    public void setExpectedJavaScriptAlert(String message) {
        try {
            tester.setExpectedJavaScriptAlert(message);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given alert boxes are expected in the given order.
     *
     * @param messages Messages in the alerts.
     */
    public void setExpectedJavaScriptAlert(String[] messages) {
        try {
            tester.setExpectedJavaScriptAlert(messages);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given confirm boxe is expected.
     *
     * @param message Message in the confirm.
     * @param action Whether we should click on "OK" (true) or "Cancel" (false)
     */
    public void setExpectedJavaScriptConfirm(String message, boolean action) {
        try {
            tester.setExpectedJavaScriptConfirm(message, action);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given confirm boxes are expected in the given order.
     *
     * @param messages Messages in the confirms.
     * @param actions Whether we should click on "OK" (true) or "Cancel" (false)
     */
    public void setExpectedJavaScriptConfirm(String[] messages, boolean[] actions) {
        try {
            tester.setExpectedJavaScriptConfirm(messages, actions);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given prompt boxe is expected.
     *
     * @param message Message in the prompt.
     * @param input What we should put in the prompt (null if user press Cancel)
     */
    public void setExpectedJavaScriptPrompt(String message, String input) {
        try {
            tester.setExpectedJavaScriptPrompt(message, input);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Tell that the given prompt boxes are expected in the given order.
     *
     * @param messages Messages in the prompts.
     * @param inputs What we should put in the prompt (null if user press Cancel)
     */
    public void setExpectedJavaScriptPrompt(String[] messages, String[] inputs) {
        try {
            tester.setExpectedJavaScriptPrompt(messages, inputs);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert there is at least one image in the page with given src and (optional) alt attributes.
     * @param imageSrc Value of image src attribute.
     * @param imageAlt Value of image alt attribute. Ignored when null.
     */
    public void assertImagePresent(String imageSrc, String imageAlt) {
        try {
            tester.assertImagePresent(imageSrc, imageAlt);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Assert there is at least one image in the page with given partial src and (optional) partial alt attributes.
     * @param partialImageSrc
     * @param partialImageAlt
     */
    public void assertImagePresentPartial(String partialImageSrc, String partialImageAlt) {
        try {
            tester.assertImagePresentPartial(partialImageSrc, partialImageAlt);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * @see #assertImageValidAndStore(String, String, java.io.File)
     */
    public void assertImageValid(String imageSrc, String imageAlt) {
        try {
            tester.assertImageValid(imageSrc, imageAlt);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Asserts that the image with the given src and alt attribute values exist in the page and is an actual reachable
     * image, then saves it as png with the given file name.
     *
     * @param imageSrc as it appears in the html page, i.e. relative to the current page.
     */
    public void assertImageValidAndStore(String imageSrc, String imageAlt, File out) {
        try {
            tester.assertImageValidAndStore(imageSrc, imageAlt, out);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * @see #assertImageValidAndStore(String, String, java.io.File)
     */
    public Image getImage(String imageSrc, String imageAlt) {
        try {
            return tester.getImage(imageSrc, imageAlt);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    /**
     * Set the timeout for the request. A timeout of 0 means
     * an infinite timeout.
     * 
     * @param milli the milliseconds in which to timeout, or 0 for infinite
     * wait (the default).
     */
    public void setTimeout(int milli) {
        try {
            tester.setTimeout(milli);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

    
    public String searchUserAgent(String agent) {
        try {
            return tester.searchUserAgent(agent);
        } catch (org.junit.ComparisonFailure e) {
            throw new junit.framework.ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        } catch (java.lang.AssertionError e) {
            throw new junit.framework.AssertionFailedError(e.getMessage());
        }
    }

}
