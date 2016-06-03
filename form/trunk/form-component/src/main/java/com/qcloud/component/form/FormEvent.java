package com.qcloud.component.form;

public interface FormEvent {

    void doEvent(FormEventType type, EventContext context);

    String QC_EXECUTOR = "qc_executor";
    //
    enum FormEventType {
        FORMAT_BEFORE, SAVE_BEFORE, SAVE_AFTER, SUBMIT_BEFORE, SUBMIT_AFTER
    }
}
