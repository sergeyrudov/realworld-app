package org.realworld.tests.web;

import org.junit.jupiter.api.*;
import org.realworld.pages.web.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;


@Tag("web")
public class FilterTagTest {

  @BeforeEach
  void openStartPage(){
    open(System.getProperty("selenide.baseUrl"));
  }

  @Test
  void checkFilteringByTag() throws InterruptedException {

    // check that tab selected 'Global Feed' tap is displayed
    assertFalse(new MainPage().getPageTitleText().isEmpty(), "Title is empty");

    // check that global tab is displayed
    assertTrue(new MainPage().isGlobalTabDisplayed(), "Global tab is absent");

    // click on #10 from list favorite tags
    new MainPage().getTagByIndex(10).click();

    // save tag name
    String tagName = new MainPage().getTagByIndex(10).text();

    // check that appears tab with selected tag
    assertFalse(new MainPage().isFavoriteTabDisplayed().isEmpty(), "Article is not selected");

    // check that selected tag from main page is equals to tag on target page
    assertTrue(new MainPage().searchTagsInList(tagName), "Tag is not find");
  }
}
