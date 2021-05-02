package com.lgt.clubmanagement.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    /**
     * 将List中相同的元素合并（即只保留相同元素中的一个）
     * @param list 需要被合并的List
     * @return 合并后的List
     */
    public static List joinList(List list){
        List list2 = new ArrayList();

        for(int i=0; i<list.size();i++){
            Object obj = list.get(i);
            //如果当前元素不在list2中，则添加
            if(list2.indexOf(obj) == -1){
                list2.add(0,obj);
            }
        }

        //上面的结果元素顺序会与之前的相反，如果需要翻转顺序，加上下面的代码
        Collections.reverse(list2);//倒序list

        return list2;
    }

}
