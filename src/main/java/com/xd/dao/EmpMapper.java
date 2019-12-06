package com.xd.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.xd.bean.Emp;

/**
@author wc
@create 2019-12-04-17:41
*/
public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> selectByAll(Emp emp);


}