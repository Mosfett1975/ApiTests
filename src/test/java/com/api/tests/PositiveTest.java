package com.api.tests;

import com.api.dto.PostDTO;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("REST API Tests")
@Feature("Posts API")
@DisplayName("CRUD операции с эндпоинтом /post")
public class PositiveTest extends BaseTest {

    @Test
    @Story("Create")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание нового поста")
    @Description("Проверка создания нового поста с заданными параметрами")
    public void testCreatePost() {
        // Подготовка тестовых данных
        PostDTO newPost = PostDTO.builder()
                .userId(1)
                .title("New Post Title")
                .body("This is the body of the new post")
                .build();

        // Выполнение запроса на создание поста
        Response response = postService.createPost(newPost);

        // Проверка результата
        response.then()
                .statusCode(201)
                .body("id", not(nullValue()))
                .body("userId", equalTo(newPost.getUserId()))
                .body("title", equalTo(newPost.getTitle()))
                .body("body", equalTo(newPost.getBody()));
    }

    @Test
    @Story("Read")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Получение всех постов")
    @Description("Проверка получения списка всех постов")
    public void testGetAllPosts() {
        // Выполнение запроса на получение всех постов
        Response response = postService.getAllPosts();

        // Проверка результата
        response.then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Story("Read")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Получение поста по ID")
    @Description("Проверка получения поста по указанному ID")
    public void testGetPostById() {
        // ID существующего поста
        int postId = 1;

        // Выполнение запроса на получение поста по ID
        Response response = postService.getPostById(postId);

        // Базовые проверки
        response.then()
                .statusCode(200)
                .body("id", equalTo(postId))
                .body("userId", not(nullValue()))
                .body("title", not(emptyString()))
                .body("body", not(emptyString()));

        // Детальная проверка структуры JSON
        response.then()
                // Проверка наличия всех необходимых полей
                .body("$", hasKey("id"))
                .body("$", hasKey("userId"))
                .body("$", hasKey("title"))
                .body("$", hasKey("body"))
                // Проверка типов данных
                .body("id", instanceOf(Integer.class))
                .body("userId", instanceOf(Integer.class))
                .body("title", instanceOf(String.class))
                .body("body", instanceOf(String.class));
    }

    @Test
    @Story("Update")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Полное обновление поста")
    @Description("Проверка полного обновления поста по указанному ID")
    public void testUpdatePost() {
        // ID существующего поста
        int postId = 1;

        // Данные для обновления поста
        PostDTO updatedPost = PostDTO.builder()
                .userId(1)
                .title("Updated Post Title")
                .body("This post has been updated")
                .build();

        // Выполнение запроса на обновление поста
        Response response = postService.updatePost(postId, updatedPost);

        // Проверка результата
        response.then()
                .statusCode(200)
                .body("id", equalTo(postId))
                .body("userId", equalTo(updatedPost.getUserId()))
                .body("title", equalTo(updatedPost.getTitle()))
                .body("body", equalTo(updatedPost.getBody()));
    }

    @Test
    @Story("Update")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Частичное обновление поста")
    @Description("Проверка частичного обновления поста по указанному ID")
    public void testPatchPost() {
        // ID существующего поста
        int postId = 1;

        // Данные для частичного обновления поста (только заголовок)
        PostDTO patchedPost = PostDTO.builder()
                .title("Patched Post Title")
                .build();

        // Выполнение запроса на частичное обновление поста
        Response response = postService.patchPost(postId, patchedPost);

        // Проверка результата
        response.then()
                .statusCode(200)
                .body("id", equalTo(postId))
                .body("title", equalTo(patchedPost.getTitle()));
    }

    @Test
    @Story("Delete")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление поста")
    @Description("Проверка удаления поста по указанному ID")
    public void testDeletePost() {
        // ID существующего поста
        int postId = 1;

        // Выполнение запроса на удаление поста
        Response response = postService.deletePost(postId);

        // Проверка результата
        response.then()
                .statusCode(200);

        // Дополнительная проверка - попытка получить удаленный пост
        // Примечание: для JSON Placeholder API это не будет возвращать 404,
        // так как фактического удаления не происходит
    }
}