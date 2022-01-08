package com.servlet.UserServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.pojo.UserTest;
import com.service.ServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/regtionServlet")
public class regtionServlet extends HttpServlet {
    ServiceImp service = new ServiceImp();
    User user = new User();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码
        String checkCode = request.getParameter("checkCode");
        //读取数据
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
//        System.out.println(readLine);
        //转化
        UserTest usertest = JSON.parseObject(readLine, UserTest.class);
        //处理数据
        user.setUsername(usertest.getUsername());
        user.setPassword(usertest.getPassword());
        //取出验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");
//        System.out.println("取出的验证码："+checkCodeGen);
//        System.out.println("取出对象的验证码："+usertest.getCheckCode());
        //判断验证码
        if (!checkCodeGen.equals(usertest.getCheckCode())){
            //验证码不正确
            response.getWriter().write("CAPTCHA error");
            return;
        }
        //验证码正确
        //执行方法
        boolean flag = service.register(user);
//        System.out.println("方法执行"+flag);
        if (flag){
            //成功添加
            request.getRequestDispatcher("/html/index.html").forward(request,response);
        }else {
            //不存在
            response.getWriter().write("failure");
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
