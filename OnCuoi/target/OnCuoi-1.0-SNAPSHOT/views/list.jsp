<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhnt
  Date: 4/11/2024
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Quản lý nhân viên</h1>
    <form action="/nhan-vien/add" method="post" onsubmit="return confirm('Bạn muốn thêm ??')">
        <div class="row">
            <div class="col-sm-6">
                Mã : <input  class="form-control"type="text" name="ma" value="${n.ma}"> <br>
            </div>
            <div class="col-sm-6">
                Tên : <input  class="form-control"type="text" name="ten" value="${n.ten}"> <br>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                Ngày Sinh : <input  class="form-control"type="text" name="ngaySinh" value="${n.ngaySinh}"> <br>
            </div>
            <div class="col-sm-6">
                Địa chỉ : <input  class="form-control"type="text" name="diaChi" value="${n.diaChi}"> <br>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                Mật khẩu : <input  class="form-control" type="password" name="matKhau" value="${n.matKhau}"><br>
            </div>

            <div class="col-sm-6">
                Trạng thái
                <div class="form-check">
                    <input class="form-check-input" type="radio" ${n.trangThai == 1?  "checked" : ""}  name="trangThai" value="1" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                       Hoạt động
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" ${n.trangThai == 1?  "" : "checked"} name="trangThai" value="0" id="flexCheckChecked" >
                    <label class="form-check-label" for="flexCheckChecked">
                       Ngưng hoạt động
                    </label>
            </div>
        </div>
        </div>
        <select name="idCV" class="form-control">
            <c:forEach var="c" items="${listCV}">
                <option value="${c.id}" ${c.id == n.idCV ?"selected": ""} >${c.ma}</option>
            </c:forEach>
        </select>
        <div class="mt-5" style="display: flex; justify-content: center">
            <button  class="btn btn-success" type="submit"> add</button>
        </div>

    </form>
    <table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Ngay sinh</th>
        <th scope="col">Dia chi</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Trang thái</th>
        <th scope="col">Mã Công viên</th>
        <th scope="col">Tên công việc</th>
        <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="n" items="${list}" varStatus="i">
        <tr onclick="return location.href='/nhan-vien/detail?id=${n.id}'">
            <th scope="row">${i.index + 1}</th>
            <td>${n.ma}</td>
            <td>${n.ten}</td>
            <td>${n.ngaySinh}</td>
            <td>${n.diaChi}</td>
            <td>${n.matKhau}</td>
            <td>${n.trangThai ==1 ? "  Hoạt động" : " Ngưng hoạt động"}</td>
            <td>${n.maCV}</td>
            <td>${n.tenCV}</td>
            <td>
                <a class="btn btn-danger" href="/nhan-vien/delete?id=${n.id}" onclick="return confirm('Bạn muốn xóa ??')">
                    <button class="btn btn-danger">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>



</body>
</html>
