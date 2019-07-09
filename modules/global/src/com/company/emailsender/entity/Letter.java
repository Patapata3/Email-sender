package com.company.emailsender.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|title")
@Table(name = "EMAILSENDER_LETTER")
@Entity(name = "emailsender_Letter")
public class Letter extends StandardEntity {
    private static final long serialVersionUID = -6169838557312148246L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @NotNull
    @Column(name = "CONTENT", nullable = false)
    protected String content;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "letter")
    protected List<Receiver> receivers;

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}