package com.bank.welcometochase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccessTool {

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccessTool{");
        sb.append("id=").append(id);
        sb.append(", toolName=").append(toolName);
        sb.append(", accessType='").append(accessType).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    private ToolName toolName;
    private String accessType;
    private StatusType status = StatusType.NOT_SUBMITTED;

    public AccessTool() {
    }

    public AccessTool(ToolName toolName, String accessType, StatusType status) {
        this.toolName = toolName;
        this.accessType = accessType;
        this.status = status;
    }

    public AccessTool(ToolName toolName, String accessType) {
        this.toolName = toolName;
        this.accessType = accessType;
    }

    public Long getId() {
        return id;
    }

    public ToolName getToolName() {
        return toolName;
    }

    public void setToolName(ToolName toolName) {
        this.toolName = toolName;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
