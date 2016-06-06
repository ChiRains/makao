package com.qcloud.component.form;
import java.util.List;
public interface ProcessActivityFormElementMappingExtend {
    List<ActivityElementMapping> listMapping(String processId, String activityName, Long formId);
    //
    static class ActivityElementMapping {
        private Long        elementId;
        private IDType      idType;
        private ControlType ControlType;

        public Long getElementId() {
            return elementId;
        }

        public void setElementId(Long elementId) {
            this.elementId = elementId;
        }

        public IDType getIdType() {
            return idType;
        }

        public void setIdType(IDType idType) {
            this.idType = idType;
        }

        public ControlType getControlType() {
            return ControlType;
        }

        public void setControlType(ControlType controlType) {
            ControlType = controlType;
        }
    }
    static enum IDType {
        ELEMENT, CHILDFORM
    }
    static enum ControlType {
        READ, WRITE
    }
}
