package com.kimorebi.dao;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimorebi.entity.UserInfoEntity;

public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
	
	
	 /**
     * 查询大于该分数的学生
     * @CreateTime 2019/6/9 14:27
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfoEntity> selectUserInfoByGtFraction(
    		@Param("page") IPage<UserInfoEntity> page,
    		@Param("fraction")Long fraction);
}
