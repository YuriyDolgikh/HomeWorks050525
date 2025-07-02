package javaBasicCourse.lesson16.task1.student;

import java.util.Arrays;

public class Group {
    private String groupName;
    private Student[] studentsForGroup;

    public Group(String groupName, Student[] studentsForGroup) {
        this.groupName = groupName;
        this.studentsForGroup = studentsForGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudentsForGroup() {
        return studentsForGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", studentsForGroup=" + Arrays.toString(studentsForGroup) +
                '}';
    }
}
