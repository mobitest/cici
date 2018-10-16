/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author: hotro
 *
 */
public interface CiRepository extends Repository<CiEntity, Long > {
    List<CiEntity> findCiEntityByContentContaining(String word);
}
