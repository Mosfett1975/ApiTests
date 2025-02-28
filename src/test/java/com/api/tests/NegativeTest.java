package com.api.tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("REST API Tests")
@Feature("Posts API негативные тесты")
@DisplayName("Негативные операции с /post")
public class NegativeTest extends BaseTest{


    @Test
    @DisplayName("Получение поста по несуществующему ID")
    @Story("Read - отсутствующий ID")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка получения поста по указанному несуществующему ID")
    public void testWithNonExistPostId() {

        int postId = -1;

        // Выполнение запроса на получение поста по ID
        Response response = postService.getPostById(postId);

        // Проверка статуса ответа
        response.then()
                .statusCode(404);
    }




}

