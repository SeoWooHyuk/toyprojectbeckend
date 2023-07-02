package com.springboot.beckend.comment.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageParam {

    private Integer pageStart;
    private Integer pageEnd;

    public void setPageParam(Integer page, Integer itemCount) {
        page -= 1;
        pageStart = page * itemCount + 1;
        pageEnd = (page + 1) * itemCount;
    }
}
