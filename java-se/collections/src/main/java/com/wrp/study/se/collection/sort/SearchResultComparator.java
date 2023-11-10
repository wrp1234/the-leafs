package com.wrp.study.se.collection.sort;

import java.util.Comparator;

/**
 * @author wrp
 * @date 2023年11月01日 17:58
 * @description
 */
public class SearchResultComparator implements Comparator<SearchResult> {
    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        if(o1.relativeRatio != o2.relativeRatio) {
            return o1.relativeRatio > o2.relativeRatio ? 1 : -1;
        }
        // 增加recentOrders
        if(o1.recentOrders != o2.recentOrders) {
            return o1.recentOrders > o2.recentOrders ? 1 : -1;
        }

        if(o1.count != o2.count) {
            return o1.count > o2.count ? 1 : -1;
        }
        return 0;
    }
}
