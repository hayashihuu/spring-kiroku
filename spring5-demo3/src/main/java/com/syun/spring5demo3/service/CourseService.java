package com.syun.spring5demo3.service;

/*
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-11 10:30
 */
public interface CourseService {

    void submitCourse(Integer id);

    void submitCourseAsync(Integer id);

    void submitCourseAsync();
}
