package org.realworld.pages.web;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    int count = 0;


    public SelenideElement globalFeedTab = $(By.xpath("//a[contains(text(),'Global Feed')]"));

    public ElementsCollection listOfPopularTags = $$(By.xpath("//*[@class='tag-default tag-pill ng-binding ng-scope']"));

    public SelenideElement favoriteTagTab = $(By.xpath("//*[@class='nav-link active ng-binding']"));

    public ElementsCollection listOfTagsOnSelectedPage = $$(By.xpath("//*[@class='tag-default tag-pill tag-outline ng-binding ng-scope']"));


    public boolean searchTagsInList(String tagName) {
        return listOfTagsOnSelectedPage.stream().anyMatch(i -> i.text().equals(tagName));
    }

    public String getPageTitleText() {
        return Selenide.title();
    }

    public boolean isGlobalTabDisplayed() {
        return globalFeedTab.exists();
    }

    public SelenideElement getTagByIndex(int index) throws InterruptedException {
        Thread.sleep(2000);
        return listOfPopularTags.get(index).waitUntil(Condition.visible, 1000);
    }

    public String isFavoriteTabDisplayed() {
        long finishTime = System.currentTimeMillis() + 2000;
        while (favoriteTagTab.exists() && System.currentTimeMillis() < finishTime) {
            return favoriteTagTab.shouldBe(Condition.visible).text();
        }
        return null;
    }
}


