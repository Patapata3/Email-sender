package com.company.emailsender.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NamePattern("%s|email")
@Table(name = "EMAILSENDER_RECEIVER")
@Entity(name = "emailsender_Receiver")
public class Receiver extends StandardEntity {
    private static final long serialVersionUID = -1180083410013921157L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Email(message = "Email is not valid")
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LETTER_ID")
    protected Letter letter;

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}