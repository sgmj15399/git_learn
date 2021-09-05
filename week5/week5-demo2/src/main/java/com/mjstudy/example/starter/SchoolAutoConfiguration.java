package com.mjstudy.example.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author minjian
 */
@Configuration
@ConditionalOnClass(MySchool.class)
@EnableConfigurationProperties(SchoolProperties.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {

    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public MySchool mySchool() {
        List<Integer> studentIds = schoolProperties.getStudentIds();
        List<String> studentNames = schoolProperties.getStudentNames();
        List<Integer> classIds = schoolProperties.getMyClassIds();
        List<String> classNames = schoolProperties.getMyClassNames();

        List<Student> students = new ArrayList<>(studentIds.size());
        for (int i=0; i<studentIds.size(); i++) {
            students.add(new Student(studentIds.get(i), studentNames.get(i)));
        }

        List<MyClass> myClasses = new ArrayList<>();
        for (int i=0; i<classIds.size(); i++) {
            myClasses.add(new MyClass(classIds.get(i), classNames.get(i)));
        }


        System.out.println("studentIds:"+studentIds.toString());
        System.out.println("studentNames:"+studentNames.toString());
        System.out.println("classIds:"+classIds.toString());
        System.out.println("classNames:"+classNames.toString());

        return new MySchool(myClasses);
    }
}
