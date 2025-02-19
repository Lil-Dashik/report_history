package Report;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServes {
    public String reportHistory(List<Report> reports, String request) {
        if (!request.startsWith("/report_history ")) {
            return "Invalid request. Use /report_history as first argument.";
        }
        String[] parts = request.split(" ");
        if (parts.length < 3) {
            return "Invalid format! Use: /report_history @username count";
        }

        String studentUserName = parts[1].replace("@", "");
        int count;

        try {
            count = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return "Invalid format! Count must be an integer";
        }

        return reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .sorted(Comparator.comparing(Report::getDate))
                .limit(count)
                .map(report -> String.format(
                        "%s\n%s\n%d\n%s\n-----------------",
                        report.getStudentUserName(),
                        report.getDate(),
                        report.getHours(),
                        report.getTitle()
                ))
                .collect(Collectors.joining("\n"));
    }
}
