/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici.repo;

import com.mobitest.cici.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
@author:hotrock505@hotmail.com
创建：2018/10/16 11:10
*/
public interface AuthorRepositoryInterface extends CrudRepository<AuthorEntity, String> {
    /**
     * 按姓名的一部分查找
     * @param authorName
     * @return
     */
    public List<AuthorEntity> findAuthorEntitiesByAuthorNameContains(String authorName);
}
