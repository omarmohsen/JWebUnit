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

/**
 * Utility class for JUnit 4 tests which provides web application navigation and 
 * JUnit assertions. This class uses and is generated from {@link net.sourceforge.jwebunit.junit.WebTester}.
 * 
 * @author JavaCC
 */
public class JWebUnit {
    private static InheritableThreadLocal<WebTester> tester = new InheritableThreadLocal<WebTester>() {
        @Override
        protected WebTester childValue(WebTester parentValue) {
            //Create a new web tester for each child thread
            WebTester webTester = new WebTester();
            //But initialize it with parent TestContext
            webTester.setTestContext(parentValue.getTestContext());
            return webTester;
        }
    };

    private JWebUnit() {
        //This class should not be instanciated, but instead used statically
    }

    /**
     * Get internal WebTester.
     */
    public static WebTester getTester() {
        if (tester.get() == null) {
            tester.set(new WebTester());
        }
        return tester.get();
    }

    /**
     * Set a custom WebTester (for example your own subclass).
     */
    public static void setCustomTester(WebTester tester) {
        JWebUnit.tester.set(tester);
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
    public static ITestingEngine getDialog() {
        return getTester().getDialog();
    }

    /**
     * Set the base url for the test context.
     * 
     * @param url Base url value - A trailing "/" is appended if not provided.
     */
    public static void setBaseUrl(String url) {
        getTester().setBaseUrl(url);
    }

    /**
     * Set the base url for the test context.
     * 
     * @param url Base url value - A trailing "/" is appended if not provided.
     */
    public static void setBaseUrl(URL url) {
        getTester().setBaseUrl(url);
    }

    /**
     * UserAgentTest
     * 
     * 
     */
    public static void setUrlandAgent(String url, String agent) {
        getTester().setUrlandAgent(url, agent);
    }

    /**
     * Protected version of deprecated getDialog(). Not deprecated for internal use.
     *
     * @return IJWebUnitDialog instance.
     */
    public static ITestingEngine getTestingEngine() {
        return getTester().getTestingEngine();
    }

    /**
     * Close the current conversation.
     */
    public static void closeBrowser() {
        getTester().closeBrowser();
    }

    /**
     * Close the current window.
     */
    public static void closeWindow() {
        getTester().closeWindow();
    }

    /**
     * Set the testing engine.
     *
     * @param aIJWebUnitDialog Testing engine.
     */
    public static void setDialog(ITestingEngine aIJWebUnitDialog) {
        getTester().setDialog(aIJWebUnitDialog);
    }

    /**
     * Provide access to test testContext.
     *
     * @return TestContext
     */
    public static TestContext getTestContext() {
        return getTester().getTestContext();
    }

    /**
     * Allows setting an external test testContext class that might be extended from TestContext. Example:
     * setTestContext(new CompanyATestContext());
     *
     * CompanyATestContext extends TestContext.
     *
     * @param aTestContext
     */
    public static void setTestContext(TestContext aTestContext) {
        getTester().setTestContext(aTestContext);
    }

    /**
     * Begin conversation at a URL absolute or relative to base URL. Use
     * {@link TestContext#setBaseUrl(String) getTestContext().setBaseUrl(String)} to define base URL. Absolute URL
     * should start with "http://", "https://" or "www.".
     *
     * @param url absolute or relative URL (relative to base URL).
     * @throws TestingEngineResponseException If something bad happend (404)
     */
    public static void beginAt(String aRelativeURL)throws TestingEngineResponseException {
        getTester().beginAt(aRelativeURL);
    }

    /**
     * Return the value of a web resource based on its key. This translates to a property file lookup with the locale
     * based on the current TestContext.
     *
     * @param key name of the web resource.
     * @return value of the web resource, encoded according to TestContext.
     */
    public static String getMessage(String key) {
        return getTester().getMessage(key);
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
    public static String getMessage(String key, Object[] args) {
        return getTester().getMessage(key, args);
    }

    /**
     * Assert that the page response has a particular code.
     * 
     * @param status the expected status code 
     */
    public static void assertResponseCode(int status) {
        getTester().assertResponseCode(status);
    }

    /**
     * Assert that the page response has a particular code between lower and higher
     * (<code>lower <= status <= higher</code>).
     * 
     * @param lower the lower bound for the expected status code 
     * @param higher the upper bound for the expected status code 
     */
    public static void assertResponseCodeBetween(int lower, int higher) {
        getTester().assertResponseCodeBetween(lower, higher);
    }

    /**
	 * Should the tester ignore failing status codes (300+)? Otherwise,
	 * failing status codes will throw an exception.
	 * 
	 * @param ignore
	 */
    public static void setIgnoreFailingStatusCodes(boolean ignore) {
        getTester().setIgnoreFailingStatusCodes(ignore);
    }

    /**
     * Assert a header is present.
     * 
     * @param name The header to find
     */
    public static void assertHeaderPresent(String name) {
        getTester().assertHeaderPresent(name);
    }

    /**
     * Assert a header is NOT present.
     * 
     * @param name The header to find
     */
    public static void assertHeaderNotPresent(String name) {
        getTester().assertHeaderNotPresent(name);
    }

    /**
     * Assert a header is equal to a particular value.
     * 
     * @param name Header to find
     * @param value Value to compare against
     */
    public static void assertHeaderEquals(String name, String value) {
        getTester().assertHeaderEquals(name, value);
    }

    /**
     * Assert a header matches a particular pattern.
     * 
     * @param name Header to find
     * @param regexp Pattern to compare against
     */
    public static void assertHeaderMatches(String name, String regexp) {
        getTester().assertHeaderMatches(name, regexp);
    }

    /**
     * Get a particular header value.
     * 
     * @param name Header to find
     * @return The found header value, or null
     */
    public static String getHeader(String name) {
        return getTester().getHeader(name);
    }

    /**
     * Get all response headers.
     * 
     * @return A map of response headers
     * @deprecated This method do not deal with several headers with same name. Use {@link #getResponseHeaders()} instead.
     */
    @Deprecated
    public static Map<String,String> getAllHeaders() {
        return getTester().getAllHeaders();
    }

    /**
     * Return all HTTP headers that are in last response. It is possible to have several headers with same name.
     * 
     * @return A list of {@link HttpHeader} elements.
     */
    public static List<HttpHeader> getResponseHeaders() {
        return getTester().getResponseHeaders();
    }

    /**
     * Assert title of current html page in conversation matches an expected
     * value.
     *
     * @param title
     *            expected title value
     */
    public static void assertTitleEquals(String title) {
        getTester().assertTitleEquals(title);
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
    public static void assertTitleNotSame(String title) {
        getTester().assertTitleNotSame(title);
    }

    /**
     * Assert title of current html page in conversation is not
     * equal to another value.
     *
     * @param title
     *            unexpected title value
     */
    public static void assertTitleNotEquals(String title) {
        getTester().assertTitleNotEquals(title);
    }

    /**
     * Assert title of current html page in conversation matches an expected regexp.
     *
     * @param regexp expected title regexp
     */
    public static void assertTitleMatch(String regexp) {
        getTester().assertTitleMatch(regexp);
    }

    /**
     * Assert title of current html page matches the value of a specified web
     * resource.
     *
     * @param titleKey
     *            web resource key for title
     */
    public static void assertTitleEqualsKey(String titleKey) {
        getTester().assertTitleEqualsKey(titleKey);
    }

    /**
     * Assert title of current page matches formatted message resource
     *
     * @param titleKey
     * @param args
     */
    public static void assertTitleEqualsKey(String titleKey, Object[] args) {
        getTester().assertTitleEqualsKey(titleKey, args);
    }

    /**
     * Assert that a web resource's value is present.
     *
     * @param key
     *            web resource name
     */
    public static void assertKeyPresent(String key) {
        getTester().assertKeyPresent(key);
    }

    /**
     * Assert that a web resource's value (with formatting) is present
     *
     * @param key
     * @param args
     */
    public static void assertKeyPresent(String key, Object[] args) {
        getTester().assertKeyPresent(key, args);
    }

    /**
     * Assert that supplied text is present.
     *
     * @param text
     */
    public static void assertTextPresent(String text) {
        getTester().assertTextPresent(text);
    }

    /**
     * Assert that supplied regexp is matched in the text of a page.
     *
     * @param regexp
     */
    public static void assertMatch(String regexp) {
        getTester().assertMatch(regexp);
    }

    /**
     * Assert a given string matches a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public static void assertMatch(String regexp, String text) {
        getTester().assertMatch(regexp, text);
    }

    /**
     * Assert a given string does not match a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public static void assertNotMatch(String regexp, String text) {
        getTester().assertNotMatch(regexp, text);
    }

    /**
     * Assert a given string matches a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public static void assertMatch(String message, String regexp, String text) {
        getTester().assertMatch(message, regexp, text);
    }

    /**
     * Assert a given string does not match a given regular expression.
     * 
     * @param regexp
     * @param text
     */
    public static void assertNotMatch(String message, String regexp, String text) {
        getTester().assertNotMatch(message, regexp, text);
    }

    /**
     * Assert that a web resource's value is not present.
     *
     * @param key web resource name
     */
    public static void assertKeyNotPresent(String key) {
        getTester().assertKeyNotPresent(key);
    }

    /**
     * Assert that a web resource's formatted value is not present.
     *
     * @param key
     *            web resource name
     */
    public static void assertKeyNotPresent(String key, Object[] args) {
        getTester().assertKeyNotPresent(key, args);
    }

    /**
     * Assert that supplied text is not present.
     *
     * @param text
     */
    public static void assertTextNotPresent(String text) {
        getTester().assertTextNotPresent(text);
    }

    /**
     * Assert that supplied regexp is not present.
     *
     * @param regexp
     */
    public static void assertNoMatch(String regexp) {
        getTester().assertNoMatch(regexp);
    }

    /**
     *
     * @param tableSummaryNameOrId
     * @return Object that represent a html table in a way independent from plugin.
     */
    public static Table getTable(String tableSummaryNameOrId) {
        return getTester().getTable(tableSummaryNameOrId);
    }

    /**
     * Assert that a table with a given summary or id value is present.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     */
    public static void assertTablePresent(String tableSummaryNameOrId) {
        getTester().assertTablePresent(tableSummaryNameOrId);
    }

    /**
     * Assert that a table with a given summary or id value is not present.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     */
    public static void assertTableNotPresent(String tableSummaryNameOrId) {
        getTester().assertTableNotPresent(tableSummaryNameOrId);
    }

    /**
     * Assert that the value of a given web resource is present in a specific table.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param key web resource name
     */
    public static void assertKeyInTable(String tableSummaryOrId, String key) {
        getTester().assertKeyInTable(tableSummaryOrId, key);
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
    public static void assertKeyInTable(String tableSummaryOrId, String key, Object[] args) {
        getTester().assertKeyInTable(tableSummaryOrId, key, args);
    }

    /**
     * Assert that supplied text is present in a specific table.
     *
     * @param tableSummaryNameOrId
     *            summary, name or id attribute value of table
     * @param text
     */
    public static void assertTextInTable(String tableSummaryNameOrId, String text) {
        getTester().assertTextInTable(tableSummaryNameOrId, text);
    }

    /**
     * Assert that supplied regexp is matched in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param regexp
     */
    public static void assertMatchInTable(String tableSummaryNameOrId, String regexp) {
        getTester().assertMatchInTable(tableSummaryNameOrId, regexp);
    }

    /**
     * Assert that the values of a set of web resources are all present in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param keys Array of web resource names.
     */
    public static void assertKeysInTable(String tableSummaryOrId, String[] keys) {
        getTester().assertKeysInTable(tableSummaryOrId, keys);
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
    public static void assertKeysInTable(String tableSummaryOrId, String[] keys, Object[][] args) {
        getTester().assertKeysInTable(tableSummaryOrId, keys, args);
    }

    /**
     * Assert that a set of text values are all present in a specific table.
     *
     * @param tableSummaryOrId
     *            summary, name or id attribute value of table
     * @param text
     *            Array of expected text values.
     */
    public static void assertTextInTable(String tableSummaryOrId, String[] text) {
        getTester().assertTextInTable(tableSummaryOrId, text);
    }

    /**
     * Assert that a set of regexp values are all matched in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param text Array of expected regexps to match.
     */
    public static void assertMatchInTable(String tableSummaryOrId, String[] regexp) {
        getTester().assertMatchInTable(tableSummaryOrId, regexp);
    }

    /**
     * Assert that the value of a given web resource is not present in a specific table.
     *
     * @param tableSummaryOrId summary, name or id attribute value of table
     * @param key web resource name
     */
    public static void assertKeyNotInTable(String tableSummaryOrId, String key) {
        getTester().assertKeyNotInTable(tableSummaryOrId, key);
    }

    /**
     * Assert that supplied text is not present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text
     */
    public static void assertTextNotInTable(String tableSummaryNameOrId, String text) {
        getTester().assertTextNotInTable(tableSummaryNameOrId, text);
    }

    /**
     * Assert that none of a set of text values are present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text Array of text values
     */
    public static void assertTextNotInTable(String tableSummaryNameOrId, String[] text) {
        getTester().assertTextNotInTable(tableSummaryNameOrId, text);
    }

    /**
     * Assert that supplied regexp is not present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text
     */
    public static void assertNoMatchInTable(String tableSummaryNameOrId, String regexp) {
        getTester().assertNoMatchInTable(tableSummaryNameOrId, regexp);
    }

    /**
     * Assert that none of a set of regexp values are present in a specific table.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param text Array of text values
     */
    public static void assertNoMatchInTable(String tableSummaryNameOrId, String[] regexp) {
        getTester().assertNoMatchInTable(tableSummaryNameOrId, regexp);
    }

    /**
     * Assert that a specific table matches an ExpectedTable.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedTable represents expected values (colspan supported).
     */
    public static void assertTableEquals(String tableSummaryNameOrId, Table expectedTable) {
        getTester().assertTableEquals(tableSummaryNameOrId, expectedTable);
    }

    /**
     * Assert that a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedCellValues double dimensional array of expected values
     */
    public static void assertTableEquals(String tableSummaryNameOrId, String[][] expectedCellValues) {
        getTester().assertTableEquals(tableSummaryNameOrId, expectedCellValues);
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected values (colspan and rowspan supported).
     */
    public static void assertTableRowsEqual(String tableSummaryNameOrId, int startRow, Table expectedTable) {
        getTester().assertTableRowsEqual(tableSummaryNameOrId, startRow, expectedTable);
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied text values.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected values (colspan and rowspan supported).
     */
    public static void assertTableRowsEqual(String tableSummaryNameOrId, int startRow, String[][] expectedTable) {
        getTester().assertTableRowsEqual(tableSummaryNameOrId, startRow, expectedTable);
    }

    /**
     * Assert that the number of rows for a specific table equals expected value.
     *
     * @param tableSummaryNameOrId summary, name or id attribute value of table
     * @param expectedRowCount expected row count.
     */
    public static void assertTableRowCountEquals(String tableSummaryNameOrId, int expectedRowCount) {
        getTester().assertTableRowCountEquals(tableSummaryNameOrId, expectedRowCount);
    }

    /**
     * Assert that a specific table matches an ExpectedTable.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param expectedTable represents expected regexps (colspan supported).
     */
    public static void assertTableMatch(String tableSummaryOrId, Table expectedTable) {
        getTester().assertTableMatch(tableSummaryOrId, expectedTable);
    }

    /**
     * Assert that a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param expectedCellValues double dimensional array of expected regexps
     */
    public static void assertTableMatch(String tableSummaryOrId, String[][] expectedCellValues) {
        getTester().assertTableMatch(tableSummaryOrId, expectedCellValues);
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected regexps (colspan and rowspan supported).
     */
    public static void assertTableRowsMatch(String tableSummaryOrId, int startRow, Table expectedTable) {
        getTester().assertTableRowsMatch(tableSummaryOrId, startRow, expectedTable);
    }

    /**
     * Assert that a range of rows for a specific table matches a matrix of supplied regexps.
     *
     * @param tableSummaryOrId summary or id attribute value of table
     * @param startRow index of start row for comparison
     * @param expectedTable represents expected regexps (colspan and rowspan not supported).
     */
    public static void assertTableRowsMatch(String tableSummaryOrId, int startRow, String[][] expectedTable) {
        getTester().assertTableRowsMatch(tableSummaryOrId, startRow, expectedTable);
    }

    /**
     * Assert that a form input element with a given name is present.
     *
     * @param formElementName
     */
    public static void assertFormElementPresent(String formElementName) {
        getTester().assertFormElementPresent(formElementName);
    }

    /**
     * Assert that a form input element with a given name is not present.
     *
     * @param formElementName
     */
    public static void assertFormElementNotPresent(String formElementName) {
        getTester().assertFormElementNotPresent(formElementName);
    }

    /**
     * Assert that a form checkbox with a given name is present.
     *
     * @param checkboxName checkbox name.
     */
    public static void assertCheckboxPresent(String checkboxName) {
        getTester().assertCheckboxPresent(checkboxName);
    }

    /**
     * Assert that a given checkbox is present.
     *
     * @param checkboxName checkbox name attribut.
     * @param checkboxValue checkbox value attribut.
     */
    public static void assertCheckboxPresent(String checkboxName, String checkboxValue) {
        getTester().assertCheckboxPresent(checkboxName, checkboxValue);
    }

    /**
     * Assert that a form checkbox with a given name is not present.
     *
     * @param checkboxName checkbox name.
     */
    public static void assertCheckboxNotPresent(String checkboxName) {
        getTester().assertCheckboxNotPresent(checkboxName);
    }

    /**
     * Assert that a given checkbox is not present.
     *
     * @param checkboxName checkbox name.
     * @param checkboxValue checkbox value attribut.
     */
    public static void assertCheckboxNotPresent(String checkboxName, String checkboxValue) {
        getTester().assertCheckboxNotPresent(checkboxName, checkboxValue);
    }

    /**
     * Assert that there is a form present.
     *
     */
    public static void assertFormPresent() {
        getTester().assertFormPresent();
    }

    /**
     * Assert that there is a form with the specified name or id present.
     *
     * @param nameOrID
     */
    public static void assertFormPresent(String nameOrID) {
        getTester().assertFormPresent(nameOrID);
    }

    /**
     * Assert that there is not a form present.
     *
     */
    public static void assertFormNotPresent() {
        getTester().assertFormNotPresent();
    }

    /**
     * Assert that there is not a form with the specified name or id present.
     *
     * @param nameOrID
     */
    public static void assertFormNotPresent(String nameOrID) {
        getTester().assertFormNotPresent(nameOrID);
    }

    /**
     * Assert that a specific form element has an expected value. Can be used to check hidden input.
     *
     * @param formElementName
     * @param expectedValue
     * @see #assertTextFieldEquals(String, String)
     * @deprecated use an explicit testing method, e.g. {@link #assertTextFieldEquals(String, String)}
     */
    public static void assertFormElementEquals(String formElementName, String expectedValue) {
        getTester().assertFormElementEquals(formElementName, expectedValue);
    }

    /**
     * Assert that a specific form element matches an expected regexp.
     *
     * @param formElementName
     * @param regexp
     */
    public static void assertFormElementMatch(String formElementName, String regexp) {
        getTester().assertFormElementMatch(formElementName, regexp);
    }

    /**
     * Assert that a form element had no value / is empty.
     *
     * @param formElementName
     * @see #setTextField(String, String)
     * @see #setHiddenField(String, String)
     * @deprecated use an explicit testing method, e.g. {@link #setTextField(String, String)} or {@link #setHiddenField(String, String)} 
     */
    public static void assertFormElementEmpty(String formElementName) {
        getTester().assertFormElementEmpty(formElementName);
    }

    /**
     * Assert that an input text element with name <code>formElementName</code> has the <code>expectedValue</code>
     * value.
     *
     * @param formElementName the value of the name attribute of the element
     * @param expectedValue the expected value of the given input element
     */
    public static void assertTextFieldEquals(String formElementName, String expectedValue) {
        getTester().assertTextFieldEquals(formElementName, expectedValue);
    }

    /**
     * Assert that an input hidden element with name <code>formElementName</code> has the <code>expectedValue</code>
     * value.
     *
     * @param formElementName the value of the name attribute of the element
     * @param expectedValue the expected value of the given input element
     */
    public static void assertHiddenFieldPresent(String formElementName, String expectedValue) {
        getTester().assertHiddenFieldPresent(formElementName, expectedValue);
    }

    /**
     * Assert that a specific checkbox is selected.
     *
     * @param checkBoxName
     */
    public static void assertCheckboxSelected(String checkBoxName) {
        getTester().assertCheckboxSelected(checkBoxName);
    }

    /**
     * Assert that a specific checkbox is selected.
     *
     * @param checkBoxName
     * @param checkBoxValue
     */
    public static void assertCheckboxSelected(String checkBoxName, String checkBoxValue) {
        getTester().assertCheckboxSelected(checkBoxName, checkBoxValue);
    }

    /**
     * Assert that a specific checkbox is not selected.
     *
     * @param checkBoxName
     */
    public static void assertCheckboxNotSelected(String checkBoxName) {
        getTester().assertCheckboxNotSelected(checkBoxName);
    }

    /**
     * Assert that a specific checkbox is not selected.
     *
     * @param checkBoxName
     * @param checkBoxValue
     */
    public static void assertCheckboxNotSelected(String checkBoxName, String checkBoxValue) {
        getTester().assertCheckboxNotSelected(checkBoxName, checkBoxValue);
    }

    /**
     * Assert that a specific option is present in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for.
     */
    public static void assertRadioOptionPresent(String name, String radioOption) {
        getTester().assertRadioOptionPresent(name, radioOption);
    }

    /**
     * Assert that a specific option is not present in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for.
     */
    public static void assertRadioOptionNotPresent(String name, String radioOption) {
        getTester().assertRadioOptionNotPresent(name, radioOption);
    }

    /**
     * Assert that a specific option is selected in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for selection.
     */
    public static void assertRadioOptionSelected(String name, String radioOption) {
        getTester().assertRadioOptionSelected(name, radioOption);
    }

    /**
     * Assert that a specific option is not selected in a radio group.
     *
     * @param name radio group name.
     * @param radioOption option to test for selection.
     */
    public static void assertRadioOptionNotSelected(String name, String radioOption) {
        getTester().assertRadioOptionNotSelected(name, radioOption);
    }

    /**
     * Assert that given options are present in a select box (by label).
     *
     * @param selectName name of the select element.
     * @param optionLabels option labels.
     */
    public static void assertSelectOptionsPresent(String selectName, String[] optionLabels) {
        getTester().assertSelectOptionsPresent(selectName, optionLabels);
    }

    /**
     * Assert that a specific option is present in a select box (by label).
     *
     * @param selectName name of the select element.
     * @param optionLabel option label.
     */
    public static void assertSelectOptionPresent(String selectName, String optionLabel) {
        getTester().assertSelectOptionPresent(selectName, optionLabel);
    }

    /**
     * Assert that given options are present in the Nth select box (by label).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionLabels option labels.
     */
    public static void assertSelectOptionsPresent(String selectName, int index, String[] optionLabels) {
        getTester().assertSelectOptionsPresent(selectName, index, optionLabels);
    }

    /**
     * Assert that a specific option is present in the Nth select box (by label).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionLabel option label.
     */
    public static void assertSelectOptionPresent(String selectName, int index, String optionLabel) {
        getTester().assertSelectOptionPresent(selectName, index, optionLabel);
    }

    /**
     * Assert that given options are present in a select box (by value).
     *
     * @param selectName name of the select element.
     * @param optionValues option labels.
     */
    public static void assertSelectOptionValuesPresent(String selectName, String[] optionValues) {
        getTester().assertSelectOptionValuesPresent(selectName, optionValues);
    }

    /**
     * Assert that a specific option is present in a select box (by value).
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public static void assertSelectOptionValuePresent(String selectName, String optionValue) {
        getTester().assertSelectOptionValuePresent(selectName, optionValue);
    }

    /**
     * Assert that given options are present in the Nth select box (by value).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionValues option labels.
     */
    public static void assertSelectOptionValuesPresent(String selectName, int index, String[] optionValues) {
        getTester().assertSelectOptionValuesPresent(selectName, index, optionValues);
    }

    /**
     * Assert that a specific option is present in the Nth select box (by value).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param optionValue option value.
     */
    public static void assertSelectOptionValuePresent(String selectName, int index, String optionValue) {
        getTester().assertSelectOptionValuePresent(selectName, index, optionValue);
    }

    /**
     * Assert that a specific option value is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public static void assertSelectOptionValueNotPresent(String selectName, String optionValue) {
        getTester().assertSelectOptionValueNotPresent(selectName, optionValue);
    }

    /**
     * Assert that a specific option is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param expectedOption option label.
     */
    public static void assertSelectOptionNotPresent(String selectName, String optionLabel) {
        getTester().assertSelectOptionNotPresent(selectName, optionLabel);
    }

    /**
     * Assert that a specific option value is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param optionValue option value.
     */
    public static void assertSelectOptionValueNotPresent(String selectName, int index, String optionValue) {
        getTester().assertSelectOptionValueNotPresent(selectName, index, optionValue);
    }

    /**
     * Assert that a specific option is not present in a select box.
     *
     * @param selectName name of the select element.
     * @param expectedOption option label.
     */
    public static void assertSelectOptionNotPresent(String selectName, int index, String optionLabel) {
        getTester().assertSelectOptionNotPresent(selectName, index, optionLabel);
    }

    /**
     * Assert that the display values of a select element's options match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedOptions expected labels for the select box.
     */
    public static void assertSelectOptionsEqual(String selectName, String[] expectedOptions) {
        getTester().assertSelectOptionsEqual(selectName, expectedOptions);
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
    public static void assertSelectOptionsEqual(String selectName, int index, String[] expectedOptions) {
        getTester().assertSelectOptionsEqual(selectName, index, expectedOptions);
    }

    /**
     * Assert that the display values of a select element's options do not match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedOptions expected display values for the select box.
     */
    public static void assertSelectOptionsNotEqual(String selectName, String[] expectedOptions) {
        getTester().assertSelectOptionsNotEqual(selectName, expectedOptions);
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
    public static void assertSelectOptionsNotEqual(String selectName, int index, String[] expectedOptions) {
        getTester().assertSelectOptionsNotEqual(selectName, index, expectedOptions);
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
    public static void assertSelectOptionValuesEqual(String selectName, int index, String[] expectedValues) {
        getTester().assertSelectOptionValuesEqual(selectName, index, expectedValues);
    }

    /**
     * Assert that the values of a select element's options match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param expectedValues expected values for the select box.
     */
    public static void assertSelectOptionValuesEqual(String selectName, String[] expectedValues) {
        getTester().assertSelectOptionValuesEqual(selectName, expectedValues);
    }

    /**
     * Assert that the values of a select element's options do not match a given array of strings.
     *
     * @param selectName name of the select element.
     * @param optionValues expected values for the select box.
     */
    public static void assertSelectOptionValuesNotEqual(String selectName, String[] optionValues) {
        getTester().assertSelectOptionValuesNotEqual(selectName, optionValues);
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
    public static void assertSelectOptionValuesNotEqual(String selectName, int index, String[] optionValues) {
        getTester().assertSelectOptionValuesNotEqual(selectName, index, optionValues);
    }

    /**
     * Assert that the currently selected display label(s) of a select box matches given label(s).
     *
     * @param selectName name of the select element.
     * @param labels expected display label(s) of the selected option.
     */
    public static void assertSelectedOptionsEqual(String selectName, String[] labels) {
        getTester().assertSelectedOptionsEqual(selectName, labels);
    }

    /**
     * Assert that the currently selected display label(s) of a select box matches given label(s).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param labels expected display label(s) of the selected option.
     */
    public static void assertSelectedOptionsEqual(String selectName, int index, String[] labels) {
        getTester().assertSelectedOptionsEqual(selectName, index, labels);
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided value.
     * @param selectName name of the select element
     * @param optionLabel expected value of the option label
     */
    public static void assertSelectedOptionEquals(String selectName, String optionLabel) {
        getTester().assertSelectedOptionEquals(selectName, optionLabel);
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided value in the Nth select element with the specified name.
     * @param selectName name of the select element
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param optionLabel expected value of the option label
     */
    public static void assertSelectedOptionEquals(String selectName, int index, String option) {
        getTester().assertSelectedOptionEquals(selectName, index, option);
    }

    /**
     * Assert that the currently selected value(s) of a select box matches given value(s).
     *
     * @param selectName name of the select element.
     * @param values expected value(s) of the selected option.
     */
    public static void assertSelectedOptionValuesEqual(String selectName, String[] values) {
        getTester().assertSelectedOptionValuesEqual(selectName, values);
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
    public static void assertSelectedOptionValuesEqual(String selectName, int index, String[] values) {
        getTester().assertSelectedOptionValuesEqual(selectName, index, values);
    }

    /**
     * Assert that the currently selected value of a select box matches given value.
     *
     * @param selectName name of the select element.
     * @param value expected value of the selected option.
     */
    public static void assertSelectedOptionValueEquals(String selectName, String value) {
        getTester().assertSelectedOptionValueEquals(selectName, value);
    }

    /**
     * Assert that the currently selected value of a select box matches given value.
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param value expected value of the selected option.
     */
    public static void assertSelectedOptionValueEquals(String selectName, int index, String value) {
        getTester().assertSelectedOptionValueEquals(selectName, index, value);
    }

    /**
     * Assert that the currently selected display value(s) of a select box matches a given value(s).
     *
     * @param selectName name of the select element.
     * @param regexps expected display value of the selected option.
     */
    public static void assertSelectedOptionsMatch(String selectName, String[] regexps) {
        getTester().assertSelectedOptionsMatch(selectName, regexps);
    }

    /**
     * Assert that the currently selected display value(s) of a select box matches a given value(s).
     *
     * @param selectName name of the select element.
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param regexps expected display value of the selected option.
     */
    public static void assertSelectedOptionsMatch(String selectName, int index, String[] regexps) {
        getTester().assertSelectedOptionsMatch(selectName, index, regexps);
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided regular expression value.
     * @param selectName name of the select element
     * @param regexp the regular expression to match
     */
    public static void assertSelectedOptionMatches(String selectName, String regexp) {
        getTester().assertSelectedOptionMatches(selectName, regexp);
    }

    /**
     * Assert that the label of the current selected option matches
     * the provided regular expression in the Nth select element with the specified name.
     * @param selectName name of the select element
     * @param index the 0-based index used when more than one select element
     * with the same name is expected.
     * @param regexp the regular expression to match
     */
    public static void assertSelectedOptionMatches(String selectName, int index, String regexp) {
        getTester().assertSelectedOptionMatches(selectName, index, regexp);
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
    public static void assertSubmitButtonPresent() {
        getTester().assertSubmitButtonPresent();
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
    public static void assertSubmitButtonPresent(String buttonName) {
        getTester().assertSubmitButtonPresent(buttonName);
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
    public static void assertSubmitButtonNotPresent() {
        getTester().assertSubmitButtonNotPresent();
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
    public static void assertSubmitButtonNotPresent(String buttonName) {
        getTester().assertSubmitButtonNotPresent(buttonName);
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
    public static void assertSubmitButtonPresent(String buttonName, String buttonValue) {
        getTester().assertSubmitButtonPresent(buttonName, buttonValue);
    }

    /**
     * Assert that a reset button is present. <br/> A reset button can be the following HTML elements:
     * <ul>
     * <li>reset input
     * <li>reset button
     * </ul>
     *
     */
    public static void assertResetButtonPresent() {
        getTester().assertResetButtonPresent();
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
    public static void assertResetButtonPresent(String buttonName) {
        getTester().assertResetButtonPresent(buttonName);
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
    public static void assertResetButtonNotPresent() {
        getTester().assertResetButtonNotPresent();
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
    public static void assertResetButtonNotPresent(String buttonName) {
        getTester().assertResetButtonNotPresent(buttonName);
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
    public static void assertButtonPresent(String buttonId) {
        getTester().assertButtonPresent(buttonId);
    }

    /**
     * Assert that a button with a given text is present in the current window.
     *
     * @param text Text representation of button content.
     */
    public static void assertButtonPresentWithText(String text) {
        getTester().assertButtonPresentWithText(text);
    }

    /**
     * Assert that a button with a given text is not present in the current window.
     *
     * @param text Text representation of button content.
     */
    public static void assertButtonNotPresentWithText(String text) {
        getTester().assertButtonNotPresentWithText(text);
    }

    /**
     * Assert that a button with a given id is not present in the current window.
     *
     * @param buttonId
     */
    public static void assertButtonNotPresent(String buttonId) {
        getTester().assertButtonNotPresent(buttonId);
    }

    /**
     * Assert that a link with a given id is present in the response.
     *
     * @param linkId
     */
    public static void assertLinkPresent(String linkId) {
        getTester().assertLinkPresent(linkId);
    }

    /**
     * Assert that no link with the given id is present in the response.
     *
     * @param linkId
     */
    public static void assertLinkNotPresent(String linkId) {
        getTester().assertLinkNotPresent(linkId);
    }

    /**
     * Assert that a link containing the supplied text is present.
     *
     * @param linkText
     */
    public static void assertLinkPresentWithText(String linkText) {
        getTester().assertLinkPresentWithText(linkText);
    }

    /**
     * Assert that no link containing the supplied text is present.
     *
     * @param linkText
     */
    public static void assertLinkNotPresentWithText(String linkText) {
        getTester().assertLinkNotPresentWithText(linkText);
    }

    /**
     * Assert that a link containing the supplied text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void assertLinkPresentWithText(String linkText, int index) {
        getTester().assertLinkPresentWithText(linkText, index);
    }

    /**
     * Assert that no link containing the supplied text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void assertLinkNotPresentWithText(String linkText, int index) {
        getTester().assertLinkNotPresentWithText(linkText, index);
    }

    /**
     * Assert that a link containing the Exact text is present.
     *
     * @param linkText
     */
    public static void assertLinkPresentWithExactText(String linkText) {
        getTester().assertLinkPresentWithExactText(linkText);
    }

    /**
     * Assert that no link containing the Exact text is present.
     *
     * @param linkText
     */
    public static void assertLinkNotPresentWithExactText(String linkText) {
        getTester().assertLinkNotPresentWithExactText(linkText);
    }

    /**
     * Assert that a link containing the Exact text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void assertLinkPresentWithExactText(String linkText, int index) {
        getTester().assertLinkPresentWithExactText(linkText, index);
    }

    /**
     * Assert that no link containing the Exact text is present.
     *
     * @param linkText
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void assertLinkNotPresentWithExactText(String linkText, int index) {
        getTester().assertLinkNotPresentWithExactText(linkText, index);
    }

    /**
     * Assert that a link containing a specified image is present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public static void assertLinkPresentWithImage(String imageFileName) {
        getTester().assertLinkPresentWithImage(imageFileName);
    }

    /**
     * Assert that a link containing a specified image is present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public static void assertLinkPresentWithImage(String imageFileName, int index) {
        getTester().assertLinkPresentWithImage(imageFileName, index);
    }

    /**
     * Assert that a link containing a specified image is not present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public static void assertLinkNotPresentWithImage(String imageFileName) {
        getTester().assertLinkNotPresentWithImage(imageFileName);
    }

    /**
     * Assert that a link containing a specified image is not present.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public static void assertLinkNotPresentWithImage(String imageFileName, int index) {
        getTester().assertLinkNotPresentWithImage(imageFileName, index);
    }

    /**
     * Assert that an element with a given id is present.
     *
     * @param anID element id to test for.
     */
    public static void assertElementPresent(String anID) {
        getTester().assertElementPresent(anID);
    }

    /**
     * Assert that an element with a given id is not present.
     *
     * @param anID element id to test for.
     */
    public static void assertElementNotPresent(String anID) {
        getTester().assertElementNotPresent(anID);
    }

    /**
     * Assert that an element with a given xpath is present.
     *
     * @param xpath element xpath to test for.
     */
    public static void assertElementPresentByXPath(String xpath) {
        getTester().assertElementPresentByXPath(xpath);
    }

    /**
     * Assert that an element with a given xpath is not present.
     *
     * @param xpath element xpath to test for.
     */
    public static void assertElementNotPresentByXPath(String xpath) {
        getTester().assertElementNotPresentByXPath(xpath);
    }

    /**
     * Get all the comments in a document, as a list of strings.
     */
    public static List<String> getComments() {
        return getTester().getComments();
    }

    /**
     * Assert that a comment is present.
     * 
     * @param comment
     */
    public static void assertCommentPresent(String comment) {
        getTester().assertCommentPresent(comment);
    }

    /**
     * Assert that a comment is not present.
     * 
     * @param comment
     */
    public static void assertCommentNotPresent(String comment) {
        getTester().assertCommentNotPresent(comment);
    }

    /**
     * Assert that a given element contains specific text.
     *
     * @param elementID id of element to be inspected.
     * @param text to check for.
     */
    public static void assertTextInElement(String elementID, String text) {
        getTester().assertTextInElement(elementID, text);
    }

    
    public static void assertTextNotInElement(String elementID, String text) {
        getTester().assertTextNotInElement(elementID, text);
    }

    /**
     * Assert that a given element matches a specific regexp.
     *
     * @param elementID id of element to be inspected.
     * @param regexp to match.
     */
    public static void assertMatchInElement(String elementID, String regexp) {
        getTester().assertMatchInElement(elementID, regexp);
    }

    /**
     * Assert that a given element does not match a specific regexp.
     *
     * @param elementID id of element to be inspected.
     * @param regexp to match.
     */
    public static void assertNoMatchInElement(String elementID, String regexp) {
        getTester().assertNoMatchInElement(elementID, regexp);
    }

    /**
     * Assert that a window with the given name is open.
     *
     * @param windowName
     */
    public static void assertWindowPresent(String windowName) {
        getTester().assertWindowPresent(windowName);
    }

    /**
     * Assert that a window with the given ID is open.
     *
     * @param windowID Javascript window ID.
     */
    public static void assertWindowPresent(int windowID) {
        getTester().assertWindowPresent(windowID);
    }

    /**
     * Assert that at least one window with the given title is open.
     *
     * @param title
     */
    public static void assertWindowPresentWithTitle(String title) {
        getTester().assertWindowPresentWithTitle(title);
    }

    /**
     * Assert that the number of opened windows equals given value.
     *
     * @param windowCount Window count
     */
    public static void assertWindowCountEquals(int windowCount) {
        getTester().assertWindowCountEquals(windowCount);
    }

    /**
     * Assert that a frame with the given name or ID is present.
     *
     * @param frameNameOrId Name or ID of the frame. ID is checked first.
     */
    public static void assertFramePresent(String frameNameOrId) {
        getTester().assertFramePresent(frameNameOrId);
    }

    /**
     * Checks to see if a cookie is present in the response.
     *
     * @param cookieName The cookie name
     */
    public static void assertCookiePresent(String cookieName) {
        getTester().assertCookiePresent(cookieName);
    }

    /**
     * Check to see if a cookie has the given value.
     *
     * @param cookieName The cookie name
     * @param expectedValue The cookie value
     */
    public static void assertCookieValueEquals(String cookieName, String expectedValue) {
        getTester().assertCookieValueEquals(cookieName, expectedValue);
    }

    /**
     * Check to see if a cookie value match the given regexp.
     *
     * @param cookieName The cookie name
     * @param regexp The regexp
     */
    public static void assertCookieValueMatch(String cookieName, String regexp) {
        getTester().assertCookieValueMatch(cookieName, regexp);
    }

    /**
     * @deprecated Use {@link WebTester#getElementAttributeByXPath(String, String)}
     */
    public static String getFormElementValue(String formElementName) {
        return getTester().getFormElementValue(formElementName);
    }

    /**
     * Begin interaction with a specified form. If form interaction methods are called without explicitly calling this
     * method first, JWebUnit will attempt to determine itself which form is being manipulated.
     *
     * It is not necessary to call this method if their is only one form on the current page.
     *
     * @param index 0-based index of the form to work with.
     */
    public static void setWorkingForm(int index) {
        getTester().setWorkingForm(index);
    }

    /**
     * Begin interaction with a specified form. If form interaction methods are called without explicitly calling this
     * method first, JWebUnit will attempt to determine itself which form is being manipulated.
     *
     * It is not necessary to call this method if their is only one form on the current page.
     *
     * @param nameOrId name or id of the form to work with.
     */
    public static void setWorkingForm(String nameOrId) {
        getTester().setWorkingForm(nameOrId);
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
    public static void setWorkingForm(String nameOrId, int index) {
        getTester().setWorkingForm(nameOrId, index);
    }

    /**
     * Set the value of a text or password input field.
     *
     * @param inputName name of form element.
     * @param value value to set.
     */
    public static void setTextField(String inputName, String value) {
        getTester().setTextField(inputName, value);
    }

    /**
     * Set the value of an hidden input field.
     *
     * @param inputName name of form element.
     * @param value value to set.
     */
    public static void setHiddenField(String inputName, String value) {
        getTester().setHiddenField(inputName, value);
    }

    /**
     * Select a specified checkbox. If the checkbox is already checked then the checkbox will stay checked.
     *
     * @param checkBoxName name of checkbox to be selected.
     */
    public static void checkCheckbox(String checkBoxName) {
        getTester().checkCheckbox(checkBoxName);
    }

    /**
     * Select a specified checkbox. If the checkbox is already checked then the checkbox will stay checked.
     *
     * @param checkBoxName name of checkbox to be selected.
     * @param value value of checkbox to be selected.
     */
    public static void checkCheckbox(String checkBoxName, String value) {
        getTester().checkCheckbox(checkBoxName, value);
    }

    /**
     * Deselect a specified checkbox. If the checkbox is already unchecked then the checkbox will stay unchecked.
     *
     * @param checkBoxName name of checkbox to be deselected.
     */
    public static void uncheckCheckbox(String checkBoxName) {
        getTester().uncheckCheckbox(checkBoxName);
    }

    /**
     * Deselect a specified checkbox. If the checkbox is already unchecked then the checkbox will stay unchecked.
     *
     * @param checkBoxName name of checkbox to be deselected.
     * @param value value of checkbox to be deselected.
     */
    public static void uncheckCheckbox(String checkBoxName, String value) {
        getTester().uncheckCheckbox(checkBoxName, value);
    }

    /**
     * Select options with given display labels in a select element.
     *
     * @param selectName name of select element.
     * @param labels labels of options to be selected.
     */
    public static void selectOptions(String selectName, String[] labels) {
        getTester().selectOptions(selectName, labels);
    }

    /**
     * Select an option with a given display label in a select element.
     *
     * @param selectName name of select element.
     * @param label label of option to be selected.
     */
    public static void selectOption(String selectName, String label) {
        getTester().selectOption(selectName, label);
    }

    /**
     * Select an option with a given display label in Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param label label of option to be selected.
     */
    public static void selectOption(String selectName, int index, String label) {
        getTester().selectOption(selectName, index, label);
    }

    /**
     * Select options with given display labels in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param labels labels of options to be selected.
     */
    public static void selectOptions(String selectName, int index, String[] labels) {
        getTester().selectOptions(selectName, index, labels);
    }

    /**
     * Select options with given values in a select element.
     *
     * @param selectName name of select element.
     * @param values values of options to be selected.
     */
    public static void selectOptionsByValues(String selectName, String[] values) {
        getTester().selectOptionsByValues(selectName, values);
    }

    /**
     * Select an option with a given value in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param values values of options to be selected.
     */
    public static void selectOptionByValue(String selectName, String value) {
        getTester().selectOptionByValue(selectName, value);
    }

    /**
     * Select options with given values in the Nth select element.
     *
     * @param selectName name of select element.
     * @param index the 0-based index of the select element when multiple
     * select elements are expected.
     * @param values values of options to be selected.
     */
    public static void selectOptionsByValues(String selectName, int index, String[] values) {
        getTester().selectOptionsByValues(selectName, index, values);
    }

    /**
     * Select an option with a given value in a select element.
     *
     * @param selectName name of select element.
     * @param values values of options to be selected.
     */
    public static void selectOptionByValue(String selectName, int index, String value) {
        getTester().selectOptionByValue(selectName, index, value);
    }

    /**
     * Submit form - default submit button will be used (unnamed submit button, or named button if there is only one on
     * the form.
     */
    public static void submit() {
        getTester().submit();
    }

    /**
     * Submit form by pressing named button.
     *
     * @param buttonName Submit button name attribut value.
     */
    public static void submit(String buttonName) {
        getTester().submit(buttonName);
    }

    /**
     * Submit the form by pressing the named button with the given value (label). Useful if you have more than one
     * submit button with same name.
     *
     * @param buttonName Submit button name attribut value.
     * @param buttonValue Submit button value attribut value.
     */
    public static void submit(String buttonName, String buttonValue) {
        getTester().submit(buttonName, buttonValue);
    }

    /**
     * Reset the current form using the default reset button. See {@link #getForm}for an explanation of how the current
     * form is established.
     */
    public static void reset() {
        getTester().reset();
    }

    /**
     * Navigate by selection of a link containing given text.
     *
     * @param linkText Text in the link.
     */
    public static void clickLinkWithText(String linkText) {
        getTester().clickLinkWithText(linkText);
    }

    /**
     * Navigate by selecting Nth link containing given text.
     *
     * @param linkText Text in the link.
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void clickLinkWithText(String linkText, int index) {
        getTester().clickLinkWithText(linkText, index);
    }

    /**
     * Navigate by selection of a link with the exact given text.
     *
     * @param linkText Text of the link.
     */
    public static void clickLinkWithExactText(String linkText) {
        getTester().clickLinkWithExactText(linkText);
    }

    /**
     * Navigate by selecting Nth link with the exact given text.
     *
     * @param linkText Text of the link.
     * @param index The 0-based index, when more than one link with the same text is expected.
     */
    public static void clickLinkWithExactText(String linkText, int index) {
        getTester().clickLinkWithExactText(linkText, index);
    }

    /**
     * Click the button with the given id.
     *
     * @param buttonId Button ID attribut value.
     */
    public static void clickButton(String buttonId) {
        getTester().clickButton(buttonId);
    }

    /**
     * Clicks a button with <code>text</code> of the value attribute.
     *
     * @param buttonValueText The text of the button (contents of the value attribute).
     */
    public static void clickButtonWithText(String buttonValueText) {
        getTester().clickButtonWithText(buttonValueText);
    }

    /**
     * Navigate by selection of a link with a given image.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     */
    public static void clickLinkWithImage(String imageFileName) {
        getTester().clickLinkWithImage(imageFileName);
    }

    /**
     * Navigate by selection of a link with a given image.
     *
     * @param imageFileName A suffix of the image's filename; for example, to match <tt>"images/my_icon.png"</tt>,
     *            you could just pass in <tt>"my_icon.png"</tt>.
     * @param index The 0-based index, when more than one link with the same image is expected.
     */
    public static void clickLinkWithImage(String imageFileName, int index) {
        getTester().clickLinkWithImage(imageFileName, index);
    }

    /**
     * Navigate by selection of a link with given id.
     *
     * @param linkId id of link
     */
    public static void clickLink(String linkId) {
        getTester().clickLink(linkId);
    }

    /**
     * Clicks a radio option. Asserts that the radio option exists first. *
     *
     * @param radioGroup name of the radio group.
     * @param radioOption value of the option to check for.
     */
    public static void clickRadioOption(String radioGroup, String radioOption) {
        getTester().clickRadioOption(radioGroup, radioOption);
    }

    /**
     * Click element with given xpath.
     *
     * @param xpath xpath of the element.
     */
    public static void clickElementByXPath(String xpath) {
        getTester().clickElementByXPath(xpath);
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
    public static String getElementAttributeByXPath(String xpath, String attribute) {
        return getTester().getElementAttributeByXPath(xpath, attribute);
    }

    /**
     * @deprecated Use {@link #getElementAttributeByXPath(String, String)} 
     */
    public static String getElementAttributByXPath(String xpath, String attribute) {
        return getTester().getElementAttributByXPath(xpath, attribute);
    }

    /**
     * Get text of the given element.
     *
     * @param xpath xpath of the element.
     */
    public static String getElementTextByXPath(String xpath) {
        return getTester().getElementTextByXPath(xpath);
    }

    /**
     * Get an element for a particular xpath.
     *
     * @param xpath XPath to search
     * @return the requested element
	 * @throws AssertionError if the element xpath is not found
     */
    public static IElement getElementByXPath(String xpath) {
        return getTester().getElementByXPath(xpath);
    }

    /**
     * Get an element for a particular ID.
     *
     * @param id element ID to find
     * @return the requested element
	 * @throws AssertionError if the element is not found
     */
    public static IElement getElementById(String id) {
        return getTester().getElementById(id);
    }

    /**
     * Get elements for a particular xpath.
     *
     * @param xpath XPath to search
     * @return the requested elements found
     */
    public static List<IElement> getElementsByXPath(String xpath) {
        return getTester().getElementsByXPath(xpath);
    }

    /**
     * Assert a label for a given ID exists.
     */
    public static void assertLabelPresent(String id) {
        getTester().assertLabelPresent(id);
    }

    /**
     * Assert a label exists.
     */
    public static void assertLabelMatches(String regexp) {
        getTester().assertLabelMatches(regexp);
    }

    /**
     * Get all the fields of type <code>input</code>, <code>textarea</code> or <code>select</code>
     * that are referenced or contained in a particular label.
     * 
     * @param label The label to consider
     * @return A list of all fields contained or referenced in this label
     */
    public static List<IElement> getFieldsForLabel(IElement label) {
        return getTester().getFieldsForLabel(label);
    }

    /**
     * Get the current value of a given labelled field. 
     * 
     * @param identifier the HTML ID for the given labelled field
     * @param label the label found for the given HTML ID
     * @return the value found in a field for the given label/ID, or 
     * 		<code>null</code> if none was found
     */
    public static String getLabeledFieldValue(String identifier, IElement label) {
        return getTester().getLabeledFieldValue(identifier, label);
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
    public static void assertLabeledFieldEquals(String id, String fieldText) {
        getTester().assertLabeledFieldEquals(id, fieldText);
    }

    
    public static void setLabeledFormElementField(String id, String value) {
        getTester().setLabeledFormElementField(id, value);
    }

    /**
     * Make a given window active.
     *
     * @param windowName Name of the window.
     */
    public static void gotoWindow(String windowName) {
        getTester().gotoWindow(windowName);
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
    public static void gotoWindow(int windowID) {
        getTester().gotoWindow(windowID);
    }

    /**
     * Make the root window active. Used to reset the effect of {@link ITestingEngine#gotoFrame(String)}.
     */
    public static void gotoRootWindow() {
        getTester().gotoRootWindow();
    }

    /**
     * Make first window with the given title active.
     *
     * @param title Title of the window.
     */
    public static void gotoWindowByTitle(String title) {
        getTester().gotoWindowByTitle(title);
    }

    /**
     * Make the given frame active.
     *
     * @param frameNameOrId Name or ID of the frame. ID is checked first.
     */
    public static void gotoFrame(String frameNameOrId) {
        getTester().gotoFrame(frameNameOrId);
    }

    /**
     * Go to the given page like if user has typed the URL manually in the browser. Use
     * {@link TestContext#setBaseUrl(String) getTestContext().setBaseUrl(String)} to define base URL. Absolute URL
     * should start with "http://", "https://" or "www.".
     *
     * @param url absolute or relative URL (relative to base URL).
     * @throws TestingEngineResponseException If something bad happend (404)
     */
    public static void gotoPage(String url)throws TestingEngineResponseException {
        getTester().gotoPage(url);
    }

    /**
     * Print all the cookies to stdout.
     *
     */
    public static void dumpCookies() {
        getTester().dumpCookies();
    }

    /**
     * Get the source of the HTML page (like in a real browser), or HTTP body for a non HTML content.
     *
     * @return The HTML content.
     */
    public static String getPageSource() {
        return getTester().getPageSource();
    }

    /**
     * Get the last data sent by the server.
     *
     * @return HTTP server response.
     */
    public static String getServerResponse() {
        return getTester().getServerResponse();
    }

    /**
     * @deprecated use {@link #getServerResponse()}
     * @return
     */
    public static String getServeurResponse() {
        return getTester().getServeurResponse();
    }

    /**
     * Save the last downloaded page (or file) to the disk.
     *
     * @param f The file name.
     */
    public static void saveAs(File f) {
        getTester().saveAs(f);
    }

    /**
     * Download the current page (or file) and compare it with the given file.
     *
     * @param expected Expected file URL.
     */
    public static void assertDownloadedFileEquals(URL expected) {
        getTester().assertDownloadedFileEquals(expected);
    }

    /**
     * Dump html of current response to System.out - for debugging purposes.
     *
     * @param stream
     * @deprecated Use {@link WebTester#getPageSource()}
     */
    public static void dumpHtml() {
        getTester().dumpHtml();
    }

    /**
     * Dump html of current response to a specified stream - for debugging purposes.
     *
     * @param stream
     * @deprecated Use {@link WebTester#getPageSource()}
     */
    public static void dumpHtml(PrintStream stream) {
        getTester().dumpHtml(stream);
    }

    /**
     * Dump the table as the 2D array that is used for assertions - for debugging purposes.
     *
     * @param tableNameOrId
     * @param stream
     */
    public static void dumpTable(String tableNameOrId) {
        getTester().dumpTable(tableNameOrId);
    }

    /**
     * Dump the table as the 2D array that is used for assertions - for debugging purposes.
     *
     * @param tableNameOrId
     * @param table
     * @param stream
     */
    public static void dumpTable(String tableNameOrId, PrintStream stream) {
        getTester().dumpTable(tableNameOrId, stream);
    }

    /**
     * Enable or disable Javascript support
     */
    public static void setScriptingEnabled(boolean value) {
        getTester().setScriptingEnabled(value);
    }

    /**
     * Set the Testing Engine that you want to use for the tests based on the Testing Engine Key.
     *
     * @see TestingEngineRegistry
     * @param testingEngineKey The testingEngineKey to set.
     */
    public static void setTestingEngineKey(String testingEngineKey) {
        getTester().setTestingEngineKey(testingEngineKey);
    }

    /**
     * Gets the Testing Engine Key that is used to find the proper testing engine class (HtmlUnitDialog /
     * SeleniumDialog) for the tests.
     *
     * @return Returns the testingEngineKey.
     */
    public static String getTestingEngineKey() {
        return getTester().getTestingEngineKey();
    }

    /**
     * Set the value of a form input element.
     *
     * @param formElementName name of form element.
     * @param value
     * @see #setTextField(String, String)
     * @deprecated use {@link #setTextField(String, String)} or other methods
     */
    public static void setFormElement(String formElementName, String value) {
        getTester().setFormElement(formElementName, value);
    }

    /**
     * Tell that the given alert box is expected.
     *
     * @param message Message in the alert.
     */
    public static void setExpectedJavaScriptAlert(String message) {
        getTester().setExpectedJavaScriptAlert(message);
    }

    /**
     * Tell that the given alert boxes are expected in the given order.
     *
     * @param messages Messages in the alerts.
     */
    public static void setExpectedJavaScriptAlert(String[] messages) {
        getTester().setExpectedJavaScriptAlert(messages);
    }

    /**
     * Tell that the given confirm boxe is expected.
     *
     * @param message Message in the confirm.
     * @param action Whether we should click on "OK" (true) or "Cancel" (false)
     */
    public static void setExpectedJavaScriptConfirm(String message, boolean action) {
        getTester().setExpectedJavaScriptConfirm(message, action);
    }

    /**
     * Tell that the given confirm boxes are expected in the given order.
     *
     * @param messages Messages in the confirms.
     * @param actions Whether we should click on "OK" (true) or "Cancel" (false)
     */
    public static void setExpectedJavaScriptConfirm(String[] messages, boolean[] actions) {
        getTester().setExpectedJavaScriptConfirm(messages, actions);
    }

    /**
     * Tell that the given prompt boxe is expected.
     *
     * @param message Message in the prompt.
     * @param input What we should put in the prompt (null if user press Cancel)
     */
    public static void setExpectedJavaScriptPrompt(String message, String input) {
        getTester().setExpectedJavaScriptPrompt(message, input);
    }

    /**
     * Tell that the given prompt boxes are expected in the given order.
     *
     * @param messages Messages in the prompts.
     * @param inputs What we should put in the prompt (null if user press Cancel)
     */
    public static void setExpectedJavaScriptPrompt(String[] messages, String[] inputs) {
        getTester().setExpectedJavaScriptPrompt(messages, inputs);
    }

    /**
     * Assert there is at least one image in the page with given src and (optional) alt attributes.
     * @param imageSrc Value of image src attribute.
     * @param imageAlt Value of image alt attribute. Ignored when null.
     */
    public static void assertImagePresent(String imageSrc, String imageAlt) {
        getTester().assertImagePresent(imageSrc, imageAlt);
    }

    /**
     * Assert there is at least one image in the page with given partial src and (optional) partial alt attributes.
     * @param partialImageSrc
     * @param partialImageAlt
     */
    public static void assertImagePresentPartial(String partialImageSrc, String partialImageAlt) {
        getTester().assertImagePresentPartial(partialImageSrc, partialImageAlt);
    }

    /**
     * @see #assertImageValidAndStore(String, String, java.io.File)
     */
    public static void assertImageValid(String imageSrc, String imageAlt) {
        getTester().assertImageValid(imageSrc, imageAlt);
    }

    /**
     * Asserts that the image with the given src and alt attribute values exist in the page and is an actual reachable
     * image, then saves it as png with the given file name.
     *
     * @param imageSrc as it appears in the html page, i.e. relative to the current page.
     */
    public static void assertImageValidAndStore(String imageSrc, String imageAlt, File out) {
        getTester().assertImageValidAndStore(imageSrc, imageAlt, out);
    }

    /**
     * @see #assertImageValidAndStore(String, String, java.io.File)
     */
    public static Image getImage(String imageSrc, String imageAlt) {
        return getTester().getImage(imageSrc, imageAlt);
    }

    /**
     * Set the timeout for the request. A timeout of 0 means
     * an infinite timeout.
     * 
     * @param milli the milliseconds in which to timeout, or 0 for infinite
     * wait (the default).
     */
    public static void setTimeout(int milli) {
        getTester().setTimeout(milli);
    }

    
    public static String searchUserAgent(String agent) {
        return getTester().searchUserAgent(agent);
    }

}
