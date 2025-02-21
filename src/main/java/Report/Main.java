package Report;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReportServes report = new ReportServes();
        List<Report> reports = report.createReports();
        String reportHistory = report.reportHistory(reports, "no_punkz", 3);
        System.out.println(reportHistory);
    }
}
