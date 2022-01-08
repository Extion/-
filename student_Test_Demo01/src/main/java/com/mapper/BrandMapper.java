package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("selectAllResultMap")
    List<Brand> selectAll();

    //修改数据
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status=#{status} where id = #{id}")
    void selectUpdate(Brand brand);

    //删除数据
    @Delete("delete from tb_brand where id = #{id}")
    void selectDelete(Integer id);

    //批量删除
    void deleteById(@Param("ids") int[] ids);

    //新增数据
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void selectAdd(Brand brand);

    //分页查询
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("selectAllResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);
    //查询总记录数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    //分页条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);
    //根据条件查询总记录数
    int selectTotalCountByCondition(Brand brand);
}
