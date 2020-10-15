package usmanf;


import java.util.*;



public class Date {

    private int year;
    private int nacisCode;
    private String industryName;
    private int totalJobs;
    private int count = 0;
    private String [][] finalArray = new String[60][4];

    public Date(String industryName,int totalJobs, int year, int nacisCode){
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
        return "Date{" +
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
        if (!(o instanceof Date))
            return false;
        Date date = (Date) o;
        return year == date.year &&
                nacisCode == date.nacisCode &&
                totalJobs == date.totalJobs &&
                Objects.equals(industryName, date.industryName);
    }

    @Override
    public int hashCode(){

        return Objects.hash(year,nacisCode,totalJobs,industryName);
    }


    public static Map<String, List<Date>> getDateMap(List<Date> dates){
        Map<String, List<Date>> grouped = new HashMap<>();
        for (Date d: dates){
            if (d.getTotalJobs() <= 100000)
                addToMap("Less than 100,000 jobs", d, grouped);
            else if( d.getTotalJobs() <= 125000)
                addToMap("Less than 125,000 jobs", d, grouped);
            else if (d.getTotalJobs() <= 175000)
                addToMap("Less than 175,000", d, grouped);
            else if (d.getTotalJobs() <= 200000)
                addToMap("Less than 200,000 jobs", d, grouped);
            else if (d.getTotalJobs() > 200000)
                addToMap("More than 200,000 jobs", d, grouped);
        }
        return grouped;
    }

    private static void addToMap(String key, Date date, Map<String, List<Date>> map){
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>(Arrays.asList(date)));
        else
            map.get(key).add(date);
    }




}
