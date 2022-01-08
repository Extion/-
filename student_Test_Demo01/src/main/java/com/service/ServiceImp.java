package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ServiceImp{
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactoryUtily();
    public User login(String username, String password) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行方法
        User user = mapper.login(username, password);
        sqlSession.close();
        return user;
    }

//    @Override
//    public boolean selectUsername(String username) {
//        //获取sqlSession对象
//        SqlSession sqlSession = factory.openSession();
//        //获取mapper
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //执行方法
//        boolean flag = mapper.selectUsername(username);
//        if (!flag){
//            //不存在
//            mapper.selectAdd(username);
//        }
//        return flag;
//    }
//
//    @Override
//    public void selectAdd(User user) {
//        //获取sqlSession对象
//        SqlSession sqlSession = factory.openSession();
//        //获取mapper
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //执行方法
//        mapper.selectAdd(user);
//        sqlSession.commit();
//        sqlSession.close();
//    }


    //注册
    public boolean register(User user){
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //判断用户名是否存在
        User register = mapper.register(user.getUsername());

        //判断
        if (register==null){
            //用户名不存在
            mapper.selectAdd(user);
            //提交事务
            sqlSession.commit();
        }
        sqlSession.close();
        return register==null;
    }
}




