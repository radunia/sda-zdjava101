package pl.sdacademy.java.adv.school.domain.grade;

public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public long countMathGrades(){
        return gradeRepository.findAllGrades()
                .stream().filter(b -> b.getSchoolSubjectCode().equals("MAT"))
                .count();

    }
}
