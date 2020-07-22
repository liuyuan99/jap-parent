package com.liuyuan.jpasc.entity;

import lombok.Data;

@Data
public class UserVo extends User{
    int page=0;
    int pageSize=1;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
