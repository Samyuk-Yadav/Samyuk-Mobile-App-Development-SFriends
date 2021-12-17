package uk.ac.tees.mad.w9519946;

public class ModelClass {

    String cases, deaths, todaycases, todaydeaths, totalrecovered, active, recovered, country;

    public ModelClass(String cases, String deaths, String todaycases, String todaydeaths, String totalrecovered, String active, String recovered, String country) {
        this.cases = cases;
        this.deaths = deaths;
        this.todaycases = todaycases;
        this.todaydeaths = todaydeaths;
        this.totalrecovered = totalrecovered;
        this.active = active;
        this.recovered = recovered;
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodaycases() {
        return todaycases;
    }

    public void setTodaycases(String todaycases) {
        this.todaycases = todaycases;
    }

    public String getTodaydeaths() {
        return todaydeaths;
    }

    public void setTodaydeaths(String todaydeaths) {
        this.todaydeaths = todaydeaths;
    }

    public String getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(String totalrecovered) {
        this.totalrecovered = totalrecovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
