package com.wrp.study.se.collection.sort;

/**
 * @author wrp
 * @date 2023年11月01日 17:53
 * @description
 */
public class SearchResult implements Comparable<SearchResult> {
    int relativeRatio;
    long count;
    int recentOrders;

    /**
     * 如果排序规则改变，需要修改compareTo，违反了开闭原则.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(SearchResult o) {
        if(this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }

        if(this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }

    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }
}
