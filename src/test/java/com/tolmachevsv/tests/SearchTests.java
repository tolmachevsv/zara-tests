package com.tolmachevsv.tests;

import com.tolmachevsv.pages.MainPage;
import com.tolmachevsv.pages.SearchPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class SearchTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @ValueSource(strings = {
            "dress",
            "blazer"
    })
    @ParameterizedTest(name = "Search for {0} in the women's section")
    public void WomanItemsSearchTest(String womanItem) {
        mainPage.openPage();
        mainPage.clickSearchButton();
        searchPage.getSearchField().setValue(womanItem);
        searchPage.checkCorrectProductNameInResults(womanItem);
    }

    @ValueSource(strings = {
            "jacket",
            "jeans"
    })
    @ParameterizedTest(name = "Search for {0} in the man's section")
    public void MenItemsSearchTest(String manItem) {
        mainPage.openPage();
        mainPage.clickSearchButton();
        searchPage.chooseAMaleGender();
        searchPage.getSearchField().setValue(manItem);
        searchPage.checkCorrectProductNameInResults(manItem);
    }
}