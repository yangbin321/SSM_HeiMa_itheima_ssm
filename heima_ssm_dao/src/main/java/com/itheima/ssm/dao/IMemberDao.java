package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Yangbin
 * @create 2020-05-10 12:54
 * @Description
 */
public interface IMemberDao {

    //根据member的id查询member
    @Select("select * from member where id = #{id}")
    public Member findById(int id) throws Exception;
}
