/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici.repo;

import com.mobitest.cici.entity.CiAuthorGroup;
import com.mobitest.cici.entity.CiEntity;
import com.mobitest.cici.entity.CiRhythmicGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @date :2018.10.17
 */
public interface CiRepository extends Repository<CiEntity, Long> {
    List<CiEntity> findCiEntityByContentContaining(String word);

    @Query("select c.author as author, count(c.content) as ciCount from CiEntity c group by c.author")
    List<CiAuthorGroup> findAuthors();

    @Query("select rhythmic as rhythmic,count(content) as count from CiEntity group by rhythmic order by count(content) desc ")
    List<CiRhythmicGroup> findRhymics();
}
