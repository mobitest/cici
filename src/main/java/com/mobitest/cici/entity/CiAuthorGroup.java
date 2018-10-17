/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici.entity;

/**
 * @author: hotrock505@hotmail.com
 * 创建: 2018/10/17 19:07
 */

/**
 * 按作者分组，对词作计数
 */
public interface CiAuthorGroup {
    AuthorEntity getAuthor();
    int getCiCount();
}
