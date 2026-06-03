package com.samsung.postprojectshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentStudentView {
    private Long assignId;
    private Long testId;
    private String testName;
    private String testDesc;
    private String className;
    private String teacherName;
    private Long teacherId;
    private boolean submitted;

    public AssignmentStudentView(Long assignId, Long testId, String testName, String testDesc,
                                  String className, String teacherName, Long teacherId, boolean submitted) {
        this.assignId = assignId;
        this.testId = testId;
        this.testName = testName;
        this.testDesc = testDesc;
        this.className = className;
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.submitted = submitted;
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

    @JsonProperty("teacher_name")
    public String getTeacherName() { return teacherName; }

    @JsonProperty("teacher_id")
    public Long getTeacherId() { return teacherId; }

    @JsonProperty("submitted")
    public boolean isSubmitted() { return submitted; }
}
