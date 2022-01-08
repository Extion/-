package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectByPageCondtiton")
public class selectByPageCondtiton extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //获取查询条件对象
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //转换位brand对象
        Brand brand = JSON.parseObject(readLine, Brand.class);
        //执行方法
        PageBean<Brand> pageBean = service.selectByPageAndCondition(currentPage, pageSize,brand);
        //转换JSON
        String toJSONString = JSON.toJSONString(pageBean);
        //写转换好的数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(toJSONString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
