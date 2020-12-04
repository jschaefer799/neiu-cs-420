package usmanf.models;

import java.util.*;


public class CustomDate {

    private int year;
    private int nacisCode;
    private String industryName;
    private int totalJobs;

    public CustomDate(String industryName, int totalJobs, int year, int nacisCode){
        this.year = year;
        this.nacisCode = nacisCode;
        this.industryName = industryName;
        this.totalJobs = totalJobs;

    }

    public int getYear(){
        return year;
    }

    public int getNacisCode(){
        return this.nacisCode;
    }

    public String getIndustryName(){
        return this.industryName;
    }

    public int getTotalJobs(){
        return this.totalJobs;
    }

    @Override
    public String toString(){
        return "CustomDate{" +
                "year=" + year +
                ", industry name='" + industryName + '\'' +
                ", NACIS code=" + nacisCode +
                ", total jobs=" + totalJobs +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof CustomDate))
            return false;
        CustomDate date = (CustomDate) o;
        return year == date.year &&
                nacisCode == date.nacisCode &&
                totalJobs == date.totalJobs &&
                Objects.equals(industryName, date.industryName);
    }

    @Override
    public int hashCode(){

        return Objects.hash(year,nacisCode,totalJobs,industryName);
    }







}
