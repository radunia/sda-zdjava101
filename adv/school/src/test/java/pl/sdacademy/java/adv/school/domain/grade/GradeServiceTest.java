package pl.sdacademy.java.adv.school.domain.grade;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sdacademy.java.adv.school.Main;
import pl.sdacademy.java.adv.school.domain.grade.parsers.csv.OpenCsvGradeParser;
import pl.sdacademy.java.adv.school.parsers.RecordsParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class GradeServiceTest {
    private static List<Grade> grades;
    private GradeService gradeService;

    public GradeServiceTest(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    // bez tego konstruktora wyżej przy próbie testów pokazywało, że gradeService jest null,
    // natomiast po dodaniu konstruktora równiez jest błąd tyylko inny

    @BeforeAll
    static void beforeAll() throws IOException {
        final RecordsParser<Grade> gradeRecordsParser = new OpenCsvGradeParser();
        try (InputStream gradeDataStream = Main.class.getResourceAsStream("/grades.csv")) {
            grades = gradeRecordsParser.parseData(gradeDataStream);
        }
    }
//48

    @Test
    void countMathGrades(){
        //WHEN
        long result1 = gradeService.countMathGrades();

        //THEN
        assertThat(result1).isEqualTo(48);
    }


}
