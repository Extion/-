package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteByIdsServlet")
public class deleteByIdsServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取数据
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //转化为数组
        int[] ids = JSON.parseObject(readLine, int[].class);
        if (ids.equals(null)){
            //判断数组为空
            response.getWriter().write("NULL");
        }
        //调用方法
        service.deleteById(ids);
        //响应
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
