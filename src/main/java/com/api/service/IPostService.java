package com.api.service;

import com.api.dto.PostDTO;
import io.restassured.response.Response;

/**
 * Интерфейс для сервиса постов
 */
public interface IPostService {
    /**
     * Создание нового поста
     * @param post объект с данными поста
     * @return ответ API
     */
    Response createPost(PostDTO post);

    /**
     * Получение всех постов
     * @return ответ API
     */
    Response getAllPosts();

    /**
     * Получение поста по ID
     * @param id идентификатор поста
     * @return ответ API
     */
    Response getPostById(int id);

    /**
     * Полное обновление поста
     * @param id идентификатор поста
     * @param post объект с обновленными данными
     * @return ответ API
     */
    Response updatePost(int id, PostDTO post);

    /**
     * Частичное обновление поста
     * @param id идентификатор поста
     * @param post объект с частичными данными для обновления
     * @return ответ API
     */
    Response patchPost(int id, PostDTO post);

    /**
     * Удаление поста
     * @param id идентификатор поста
     * @return ответ API
     */
    Response deletePost(int id);
}