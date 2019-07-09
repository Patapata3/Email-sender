package com.company.emailsender.web.screens.letter;

import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.Letter;

@UiController("emailsender_Letter.edit")
@UiDescriptor("letter-edit.xml")
@EditedEntityContainer("letterDc")
@LoadDataBeforeShow
public class LetterEdit extends StandardEditor<Letter> {
}