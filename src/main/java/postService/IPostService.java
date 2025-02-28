package postService;

import pojo.Post;
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
    Response createPost(Post post);

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
    Response updatePost(int id, Post post);

    /**
     * Частичное обновление поста
     * @param id идентификатор поста
     * @param post объект с частичными данными для обновления
     * @return ответ API
     */
    Response patchPost(int id, Post post);

    /**
     * Удаление поста
     * @param id идентификатор поста
     * @return ответ API
     */
    Response deletePost(int id);
}