/*
 * Copyright (c) 2018.
 * Developed By Rock
 */

package com.mobitest.cici;


import javax.persistence.*;

/**
 * @author hotro
 */
@Entity
@Table(name = "ci")
public class CiEntity {

    @Id
    private long value;
    private String rhythmic;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private AuthorEntity author;
    private String content;


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }


    public String getRhythmic() {
        return rhythmic;
    }

    public void setRhythmic(String rhythmic) {
        this.rhythmic = rhythmic;
    }


    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
