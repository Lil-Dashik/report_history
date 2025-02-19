package Report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(1L, "no_punkz", 1, LocalDate.of(2021, 9, 25), "Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени"));
        reports.add(new Report(2L, "no_punkz", 2, LocalDate.of(2021, 9, 26), "Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата"));
        ReportServes report= new ReportServes();
        String reportHistory = report.reportHistory(reports, "/report_history @no_punkz 3");
        System.out.println(reportHistory);
    }
}
