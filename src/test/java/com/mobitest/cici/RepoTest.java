/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici;

import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

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

}
