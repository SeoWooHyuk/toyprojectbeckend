package com.springboot.beckend.bulletinboard.dto.response;

import com.springboot.beckend.bulletinboard.domain.Bulletinboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardResponse {
    
    private Bulletinboard bulletinboard;

    public BulletinboardResponse(Bulletinboard bulletinboard) {

        this.bulletinboard = bulletinboard;
         System.out.println(bulletinboard.getSeq());
    }

}
