package com.kimorebi.aspect.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimorebi.aspect.service.TestAspectAnnotation;
import com.kimorebi.entity.UserInfoEntity;
import com.kimorebi.service.UserInfoService;

@RestController
@RequestMapping("/aspect")
public class AspectController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/test")
    @TestAspectAnnotation
    public UserInfoEntity getInfo(String userId){
        UserInfoEntity userInfoEntity = userInfoService.getById(userId);
        System.out.println("userInfoEntity: " + userInfoEntity);
        return userInfoEntity;
    }
}
