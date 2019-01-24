package com.emscrm;

import java.time.Duration;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.emscrm.QbdConstants.*;

/**
 * @author JShepherd
 */
public abstract class QueueByDateReport {

    private final String[] GROUP_NAMES;
    private final String[] EMAIL_GROUP_NAMES;
    protected int excelDataSheetIndex;
    protected String weeklyReportFilename;
    private LocalDate date;
    private String accountName;
    private String groupName;
    private int interactionsAnswered;
    private Duration averageTalkTime;
    private Duration totalTalkTime;
    private Duration avgAcw;
    private Duration totalAcw;
    private int interactionsAbandoned;
    private Duration averageAbandonDelay;
    private double percentAbandoned;
    private Duration maxWait;
    private Duration averageSpeedOfAnswer;
    private double serviceLevel;

    public QueueByDateReport(String[] groupOne, String[] groupTwo) {
        GROUP_NAMES = groupOne;
        EMAIL_GROUP_NAMES = groupTwo;
        excelDataSheetIndex = 0;

        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_QueueByDateReport.xlsx";
    }

    String formatCsvRow(String row) {
        System.out.println("Starting string is : " + row);
        StringJoiner joiner = new StringJoiner(",");
        String[] reportCategories = row.split("\t");

        Double percentAban = Double.valueOf(reportCategories[PERCENT_ABAN]) / 100; //move decimal 2 places to accommodate Excel
        Double serviceLevel = Double.valueOf(reportCategories[SVC_LVL]) / 100;

        joiner.add(reportCategories[ACCOUNT_NAME]);
        joiner.add(reportCategories[GROUP_NAME]);
        joiner.add(reportCategories[INTERACTIONS_ANSWERED]);
        joiner.add(reportCategories[AVG_TALK_TIME]);
        joiner.add(reportCategories[TOTAL_TALK_TIME]);
        joiner.add(reportCategories[AVG_ACW]);
        joiner.add(reportCategories[TOTAL_ACW]);
        joiner.add(reportCategories[INTERACTIONS_ABANDONED]);
        joiner.add(reportCategories[AVG_ABAND_DELAY]);
        joiner.add(percentAban.toString());
        joiner.add(reportCategories[MAX_WAIT]);
        joiner.add(reportCategories[ASA]);
        joiner.add(serviceLevel.toString());

        System.out.println("Ending string: " + joiner.toString());
        return joiner.toString();
    }

    boolean groupNameMatch(String name) {
        boolean isMatched = false;

        for (String item : GROUP_NAMES) {
            if (item.equalsIgnoreCase(name)) {
                isMatched = true;
                break;
            }
        }

        for (String item : EMAIL_GROUP_NAMES) {
            if (item.equalsIgnoreCase(name)) {
                isMatched = true;
                break;
            }
        }
        return isMatched;
    }

    LocalDate getDate() {
        return date;
    }

    void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Duration getAverageTalkTime() {
        return averageTalkTime;
    }

    public void setAverageTalkTime(Duration averageTalkTime) {
        this.averageTalkTime = averageTalkTime;
    }

    public Duration getTotalTalkTime() {
        return totalTalkTime;
    }

    public void setTotalTalkTime(Duration totalTalkTime) {
        this.totalTalkTime = totalTalkTime;
    }

    public Duration getAvgAcw() {
        return avgAcw;
    }

    public void setAvgAcw(Duration avgAcw) {
        this.avgAcw = avgAcw;
    }

    public Duration getTotalAcw() {
        return totalAcw;
    }

    public void setTotalAcw(Duration totalAcw) {
        this.totalAcw = totalAcw;
    }

    public int getInteractionsAnswered() {
        return interactionsAnswered;
    }

    public void setInteractionsAnswered(int interactionsAnswered) {
        this.interactionsAnswered = interactionsAnswered;
    }

    public int getInteractionsAbandoned() {
        return interactionsAbandoned;
    }

    public void setInteractionsAbandoned(int interactionsAbandoned) {
        this.interactionsAbandoned = interactionsAbandoned;
    }

    public Duration getAverageAbandonDelay() {
        return averageAbandonDelay;
    }

    public void setAverageAbandonDelay(Duration averageAbandonDelay) {
        this.averageAbandonDelay = averageAbandonDelay;
    }

    public double getPercentAbandoned() {
        return percentAbandoned;
    }

    public void setPercentAbandoned(double percentAbandoned) {
        this.percentAbandoned = percentAbandoned;
    }

    public Duration getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Duration maxWait) {
        this.maxWait = maxWait;
    }

    public Duration getAverageSpeedOfAnswer() {
        return averageSpeedOfAnswer;
    }

    public void setAverageSpeedOfAnswer(Duration averageSpeedOfAnswer) {
        this.averageSpeedOfAnswer = averageSpeedOfAnswer;
    }

    public double getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(double serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String[] getGroupNames() {
        String[] groupNames = GROUP_NAMES.clone();
        return groupNames;
    }

    public String[] getEmailGroupNames() {
        String[] emailGroupNames = EMAIL_GROUP_NAMES.clone();
        return emailGroupNames;
    }

    public String getGroupNameE(int index) {
        return GROUP_NAMES[index];
    }

    public String getEmailGroupNameE(int index) {
        return EMAIL_GROUP_NAMES[index];
    }

    public String getExcelFilename() {
        return weeklyReportFilename;
    }
}
