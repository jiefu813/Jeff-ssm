package com.jeff.common.entity;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-30 22:49
 */
public class Datagrid {

    // 当前页显示的数据
    private List<?> rows;
    // 表中总个数
    private long total;

    public Datagrid(List<?> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
