package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class selectAllServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service进行查询
        List<Brand> brands = service.selectAll();
        //转化JSON
        String jsonString = JSON.toJSONString(brands);
        //改变数据的编码
        response.setContentType("text/json;charset=utf-8");
        //写数据
        response.getWriter().write(jsonString);
        if (brands==null){
            response.getWriter().write("JDBC-SB");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
