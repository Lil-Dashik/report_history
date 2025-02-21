package Report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServes {
    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        List<Report> filteredReports = reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .toList();
        return filteredReports.stream()
                .sorted((Comparator.comparing(Report::getDate)))
                .skip(Math.max(0, filteredReports.size() - count))
                .map(report -> report.toString())
                .collect(Collectors.joining("-----------------\n"));
    }

    public List<Report> createReports() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(1L, "no_punkz", 2, LocalDate.of(2021, 9, 26),
                "Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата"));

        reports.add(new Report(4L, "no_punkz", 7, LocalDate.of(2021, 9, 23),
                " Теория по 6 модулю. Ответы на вопросы по 6 модулю, задачка по эко, report"));

        reports.add(new Report(5L, "no_punkz", 6, LocalDate.of(2021, 9, 22),
                "Теория по 6 модулю. Переделывала задачку по эко"));
        reports.add(new Report(6L, "no_punkz", 7, LocalDate.of(2025, 2, 14),
                "ответы на вопросы по 5 модулю, переделала задачки"));
        reports.add(new Report(7L, "no_punkz", 6, LocalDate.of(2025, 2, 12),
                "ответы на вопросы по 5 модулю, созвон с Анатолием, теория по джинерикам"));
        reports.add(new Report(3L, "no_punkz", 5, LocalDate.of(2021, 9, 27),
                "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"));
        reports.add(new Report(2L, "no_punkz", 1, LocalDate.of(2021, 9, 25),
                "Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени"));
        return reports;
    }
}
