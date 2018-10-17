/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici;

import com.mobitest.cici.entity.AuthorEntity;
import com.mobitest.cici.entity.CiAuthorGroup;
import com.mobitest.cici.entity.CiEntity;
import com.mobitest.cici.entity.CiRhythmicGroup;
import com.mobitest.cici.repo.AuthorRepositoryInterface;
import com.mobitest.cici.repo.CiRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

//@ComponentScan(basePackages = "com.mobitest.cici")
//@ContextConfiguration()
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log
@DisplayName(value = "数据访问测试")
public class RepoTest {
    @Autowired
    CiRepository ciRepository;
    @Autowired
    AuthorRepositoryInterface authorRepository;

    @Tag(value = "entity")
    @DisplayName("找一首词")
    @ParameterizedTest
    @CsvSource({"秋,1","秋日,1","秋天来了,0"})
    public void findCi(String word, int count){

        List<CiEntity> ciEntityList = ciRepository.findCiEntityByContentContaining(word);
        long len = ciEntityList.size();
        for(CiEntity ci : ciEntityList){
            ci.getAuthor();
            String c = ci.getContent();
            assert c.contains(word);
            log.info(c);
        }
        log.info("total ci:"+len);
        if(len<count){
            fail("数目不对，期望至少"+ count + ",实际："+ len);
        }
//        assert len>0;
    }

    @Test
    @Tag(value = "entity")
    @DisplayName(value = "找人")
    public void shouldHasSomebody(){
        String author = "杜";
        List<AuthorEntity> authorEntities = authorRepository.findAuthorEntitiesByAuthorNameContains(author);
        assert authorEntities.size()>0;
        assert authorEntities.get(0).getAuthorName().contains(author);
    }

    @Test
    @DisplayName(value = "作者和作品数")
    public void shouldHasAuthor(){
        List<CiAuthorGroup> authorCiCounts = ciRepository.findAuthors();
        for(CiAuthorGroup c : authorCiCounts){
            log.info(c.getAuthor().getAuthorName() + ":"+ c.getCiCount());
        }
        assertTrue(authorCiCounts.size()>0);
    }

    @Test
    @DisplayName(value = "词牌和作品数")
    public void shouldHasRhythmic(){
        List<CiRhythmicGroup> rhythmicGroups = ciRepository.findRhymics();
        for(CiRhythmicGroup cr : rhythmicGroups){
            log.info(cr.getRhythmic() + ":"+cr.getCount());
        }
        log.info("total:"+rhythmicGroups.size());
        assert rhythmicGroups.size()>0;
    }

}
