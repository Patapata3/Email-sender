package com.company.emailsender.web.screens.receiver;

import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.Receiver;

@UiController("emailsender_Receiver.edit")
@UiDescriptor("receiver-edit.xml")
@EditedEntityContainer("receiverDc")
@LoadDataBeforeShow
public class ReceiverEdit extends StandardEditor<Receiver> {
}