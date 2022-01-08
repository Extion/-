package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectAddServlet")
public class selectAddServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Do_selectAddServlet...");
        //获取数据
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //转化JSON
        Brand object = JSON.parseObject(readLine, Brand.class);
        //执行方法
        service.selectAdd(object);
        //响应
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
