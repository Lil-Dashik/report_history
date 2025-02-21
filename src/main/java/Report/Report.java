package Report;

import java.time.LocalDate;

public class Report {

    private final Long id;

    private final String studentUserName;

    private final Integer hours;

    private final LocalDate date;

    private final String title;

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n%s\n%d\n%s\n",
                getStudentUserName(),
                getDate(),
                getHours(),
                getTitle());
    }

}
