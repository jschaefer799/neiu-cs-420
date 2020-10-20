package usmanf;

import java.util.Comparator;

public class EmployeeNumberComparator  implements Comparator<EmployeeNumber> {
    @Override
    public int compare (EmployeeNumber o1, EmployeeNumber o2){
        if (o1.getMin() < o2.getMin())
            return -1;
        else if (o1.getMin() > o2.getMin())
            return 1;
        else
            return 0;
    }
}
