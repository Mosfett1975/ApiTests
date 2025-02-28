package com.api.tests;

import postService.IPostService;
import postService.PostService;
import org.junit.jupiter.api.BeforeAll;

/**
 * Базовый тестовый класс с общими настройками
 */
public abstract class BaseTest {
    protected static IPostService postService;

    @BeforeAll
    public static void setUp() {
        postService = new PostService();
    }
}