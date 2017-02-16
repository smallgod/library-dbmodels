/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
//@DynamicUpdate(value = true)
//@SelectBeforeUpdate(value = true)
@Table(name = "ad_author")
public class Author extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 7606418115873045512L;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String getUsername() {
        return "SmallGod";
    }
}
