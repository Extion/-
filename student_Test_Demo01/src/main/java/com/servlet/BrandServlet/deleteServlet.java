package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取JSON数据
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //转换JSON
        Brand brandId = JSON.parseObject(readLine, Brand.class);
        System.out.println(brandId.getId());
        //执行方法
        service.selectDelete(brandId.getId());
        //响应
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
