package basic.knowledge.henry.jsonToObjectBean.param;

import java.util.Date;

public class Dates {
    Date startDate;
    Date endDate;

    public Dates() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
