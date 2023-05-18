package com.demoutils.entity;

import lombok.Data;

/**
 * @author: SunHB
 * @createTime: 2023/05/10 上午9:11
 * @description:
 */
@Data
public class Student {
    /**
     * id 主键
     */
    private Integer Id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String classNmae;

    public Student(Integer id, String name, Integer age, String grade, String classNmae) {
        Id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.classNmae = classNmae;
    }

}
