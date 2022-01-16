package pl.sdacademy.java.adv.school.domain.grade;

import java.util.List;

public class GradeListRepository implements GradeRepository{

    private List<Grade> grade;

    public GradeListRepository(List<Grade> grade) {
        this.grade = grade;
    }

    @Override
    public List<Grade> findAllGrades() {
        return grade;
    }
}
