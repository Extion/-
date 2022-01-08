package com.servlet.BrandServlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//被废弃了
@WebServlet("/selectByPageServlet")
public class selectByPageServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //这些方法
        PageBean<Brand> pageBean = service.selectByPage(currentPage, pageSize);
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
