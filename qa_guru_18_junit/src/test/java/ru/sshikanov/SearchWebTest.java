package ru.sshikanov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@DisplayName("Проверка количества результатов в поисковом запросе")
public class SearchWebTest {

    @ValueSource(strings = {
            "Корм для кошек", "Корм для собак"
    })

    @ParameterizedTest(name = "В поисковой выдаче должно отоброжаться 10 результатов по запросу {0}")
    void searchWebTest(String testData){
        Selenide.open("https://mm.ru/");
        $("[data-test-id='input__search']").setValue(testData).pressEnter();
        $$("[data-test-id=list__products]>div").shouldHave(sizeGreaterThanOrEqual(10));


    }
}
