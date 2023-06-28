package com.springboot.beckend.bulletinboard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBullinboardResponse {
    
    private Integer deletecheck;

    public DeleteBullinboardResponse(Integer deletecheck) {
        this.deletecheck = deletecheck;
    }

    
}
