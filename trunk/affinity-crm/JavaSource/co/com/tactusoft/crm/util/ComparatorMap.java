package co.com.tactusoft.crm.util;

import java.util.Comparator;
import java.util.Map;

public class ComparatorMap implements Comparator<Map.Entry<String,Integer>> {
    public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
        if (e1.getValue() < e2.getValue()){
            return 1;
        } else if (e1.getValue() == e2.getValue()) {
            return 0;
        } else {
            return -1;
        }
    }
}