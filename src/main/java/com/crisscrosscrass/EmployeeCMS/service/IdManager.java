package com.crisscrosscrass.EmployeeCMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IdManager {
    public static AtomicInteger nextId = new AtomicInteger();
    public static List<Integer> unusedIds = new ArrayList<>();

    public static int getId(){
        if (unusedIds.size() == 0){
            return nextId.incrementAndGet();
        }else{
            int usedId = unusedIds.get(0);
            unusedIds.remove(0);
            return usedId;
        }
    }
    public static void saveId(int id){
        unusedIds.add(id);
    }
}
