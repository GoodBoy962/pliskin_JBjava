package com.pliskin.util;

import java.util.Map;

/**
 * Created by aleksandrpliskin on 24.10.15.
 */
public class MathOperations<T> {

    public T getMax(Map<T, Long> map) {
        long resVal = 0;
        T resName = null;
        for (T name : map.keySet()) {
            if (map.get(name) > resVal) {
                resVal = map.get(name);
                resName = name;
            }
        }
        return resName;
    }

}
