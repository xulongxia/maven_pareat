package com.jk.dao;

import com.jk.model.TreeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeDao {

    @Select("select * from t_tree where pid=#{i}")
    List<TreeModel> queryTree(int i);
}
