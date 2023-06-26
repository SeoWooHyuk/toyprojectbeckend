package com.springboot.beckend.bulletinboard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardRequest {
    
    private String id;  
    private String title;
    private String content;
    private String files;  
      
}
