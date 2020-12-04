package usmanf.models;

import java.util.*;

public class TotalJobsUtil {

    private TotalJobsUtil(){}

    public static Map<TotalJobs, List<CustomDate>> getDateMap(List<CustomDate> dates){
        Map<TotalJobs, List<CustomDate>> grouped = new HashMap<>();
        dates.forEach(d -> placeValuesInDatesCategories(grouped, d));
        return grouped;
    }

    private static void placeValuesInDatesCategories (Map<TotalJobs, List<CustomDate>> grouped, CustomDate d){
        Arrays.asList(TotalJobs.values()).forEach(populationCategory ->{
            if (d.getTotalJobs() >= populationCategory.getMin() && d.getTotalJobs() <= populationCategory.getMax())
                addToMap(populationCategory, d, grouped);
        });
    }

    private static void addToMap(TotalJobs key, CustomDate date, Map<TotalJobs, List<CustomDate>> map){
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>(Arrays.asList(date)));
        else
            map.get(key).add(date);
    }
}
