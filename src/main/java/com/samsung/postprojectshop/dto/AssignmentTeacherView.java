package com.samsung.postprojectshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentTeacherView {
    private Long assignId;
    private Long testId;
    private String testName;
    private String testDesc;
    private String className;
    private Long classId;
    private int submittedCount;
    private int totalCount;

    public AssignmentTeacherView(Long assignId, Long testId, String testName, String testDesc,
                                  String className, Long classId, int submittedCount, int totalCount) {
        this.assignId = assignId;
        this.testId = testId;
        this.testName = testName;
        this.testDesc = testDesc;
        this.className = className;
        this.classId = classId;
        this.submittedCount = submittedCount;
        this.totalCount = totalCount;
    }

    @JsonProperty("assign_id")
    public Long getAssignId() { return assignId; }

    @JsonProperty("test_id")
    public Long getTestId() { return testId; }

    @JsonProperty("test_name")
    public String getTestName() { return testName; }

    @JsonProperty("test_desc")
    public String getTestDesc() { return testDesc; }

    @JsonProperty("class_name")
    public String getClassName() { return className; }

    @JsonProperty("class_id")
    public Long getClassId() { return classId; }

    @JsonProperty("submitted_count")
    public int getSubmittedCount() { return submittedCount; }

    @JsonProperty("total_count")
    public int getTotalCount() { return totalCount; }
}
