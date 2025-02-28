package postService;

import apiConfig.GetProperties;
import apiConfig.Endpoints;
import pojo.Post;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Реализация сервиса для работы с постами
 */
public class PostService implements IPostService {
    private final RequestSpecification requestSpec;

    public PostService() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(GetProperties.getBaseUrl())
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Override
    public Response createPost(Post post) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(post)
                .when()
                .post(Endpoints.POSTS);
    }

    @Override
    public Response getAllPosts() {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.POSTS);
    }

    @Override
    public Response getPostById(int id) {
        return RestAssured.given()
                .spec(requestSpec)
                .pathParam("id", id)
                .when()
                .get(Endpoints.POST_BY_ID);
    }

    @Override
    public Response updatePost(int id, Post post) {
        return RestAssured.given()
                .spec(requestSpec)
                .pathParam("id", id)
                .body(post)
                .when()
                .put(Endpoints.POST_BY_ID);
    }

    @Override
    public Response patchPost(int id, Post post) {
        return RestAssured.given()
                .spec(requestSpec)
                .pathParam("id", id)
                .body(post)
                .when()
                .patch(Endpoints.POST_BY_ID);
    }

    @Override
    public Response deletePost(int id) {
        return RestAssured.given()
                .spec(requestSpec)
                .pathParam("id", id)
                .when()
                .delete(Endpoints.POST_BY_ID);
    }
}