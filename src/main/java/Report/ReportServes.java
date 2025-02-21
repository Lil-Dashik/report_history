package Report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServes {
    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        List<Report> filteredReports = reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .toList();
        if (filteredReports.isEmpty())
            return "No Reports found";
        return filteredReports.stream()
                .skip(Math.max(0, filteredReports.size() - count))
                .map(report -> report.toString())
                .collect(Collectors.joining("-----------------\n"));
    }

    public List<Report> createReports() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(1L, "no_punkz", 1, LocalDate.of(2021, 9, 25),
                "Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени"));

        reports.add(new Report(2L, "no_punkz", 2, LocalDate.of(2021, 9, 26),
                "Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата"));

        reports.add(new Report(3L, "no_punkz", 5, LocalDate.of(2021, 9, 27),
                "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"));

        reports.add(new Report(4L, "user_123", 3, LocalDate.of(2021, 9, 20),
                "Учился писать unit-тесты, было сложно, но интересно"));

        reports.add(new Report(5L, "user_123", 4, LocalDate.of(2021, 9, 21),
                "Сегодня работал над проектом, много времени ушло на рефакторинг"));
        return reports;
    }
}
