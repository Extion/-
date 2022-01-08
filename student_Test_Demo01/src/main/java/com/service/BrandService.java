package com.service;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactoryUtily();
    //查询所有
    public List<Brand> selectAll(){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        List<Brand> list = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return list;
    }
    //修改数据
    public void selectUpdate(Brand brnad){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        mapper.selectUpdate(brnad);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除数据
    public void selectDelete(Integer id){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        mapper.selectDelete(id);
        sqlSession.commit();
        sqlSession.close();
    }

    //批量删除
    public void deleteById(int[] ids){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        mapper.deleteById(ids);
        sqlSession.commit();
        sqlSession.close();
    }
    //新增数据
    public void selectAdd(Brand brand){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        mapper.selectAdd(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    /*
    * @param currentPage 当前页码
    * @param pageSize 每页展示条数
     * */
    public PageBean<Brand> selectByPage(int currentPage, int pageSize){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算开始的索引
        int begin = (currentPage-1) * pageSize;
        //计算机拆线呢条目数
        int size = pageSize;
        //执行方法
        List<Brand> rows = mapper.selectByPage(begin, size);
        //查询总记录数
        int totalCount = mapper.selectTotalCount();
        //将算好的数据封装进对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();
        return pageBean;
    }
    /*
    分页条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * */
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand){
        //获取Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算开始的索引
        int begin = (currentPage-1) * pageSize;
        //计算机拆线呢条目数
        int size = pageSize;
        //获取品牌名称
        String brandName = brand.getBrandName();
        if (brandName != null & brandName.length() > 0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null & companyName.length() > 0){
            brand.setCompanyName("%"+companyName+"%");
        }
        //执行方法
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size,brand);
        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);
        //将算好的数据封装进对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();
        return pageBean;
    }
}
