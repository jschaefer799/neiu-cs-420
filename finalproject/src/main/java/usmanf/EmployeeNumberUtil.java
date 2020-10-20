package usmanf;

import java.util.*;

public class EmployeeNumberUtil {

    private EmployeeNumberUtil(){

    }

    public static Map<EmployeeNumber, List<Date>> getDateMap(List<Date> dates){
        Map<EmployeeNumber, List<Date>> grouped = new HashMap<>();
        for (Date d: dates){
            for (EmployeeNumber populationCategory: EmployeeNumber.values()){
                if (d.getTotalJobs() >= populationCategory.getMin() && d.getTotalJobs() <= populationCategory.getMax()){
                    addToMap(populationCategory, d, grouped);
                }
            }
        }
        return grouped;
    }

    private static void addToMap(EmployeeNumber key, Date date, Map<EmployeeNumber, List<Date>> map){
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>(Arrays.asList(date)));
        else
            map.get(key).add(date);
    }
}
