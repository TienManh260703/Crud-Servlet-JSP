package com.example.OnCuoi.controller;

import com.example.OnCuoi.entity.NhanVien;
import com.example.OnCuoi.repository.ChucVuRepository;
import com.example.OnCuoi.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/add",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            this.getAll(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        }else{
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        nhanVienRepository.delete(NhanVien.builder().id(id).build());
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nhanVien = nhanVienRepository.getOne(id);
        request.setAttribute("n", nhanVien);
        request.setAttribute("list", nhanVienRepository.getAll());
        request.setAttribute("listCV", chucVuRepository.getAll());
        request.getRequestDispatcher("/views/list.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", nhanVienRepository.getAll());
        request.setAttribute("listCV", chucVuRepository.getAll());
        request.getRequestDispatcher("/views/list.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.populate(nhanVien, request.getParameterMap());
        nhanVienRepository.create(nhanVien);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

//    private boolean check (HttpServletRequest request , HttpServletResponse){
//
//    }
}
