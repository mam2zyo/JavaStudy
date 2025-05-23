package io;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int age;
    double averageGrade;
    transient String temp;

    @Override
    public String toString() {
        return String.format("이름: %s, 나이: %d, 평균 학점: %.2f, 메모: %s",
                name, age, averageGrade, temp);
    }
}