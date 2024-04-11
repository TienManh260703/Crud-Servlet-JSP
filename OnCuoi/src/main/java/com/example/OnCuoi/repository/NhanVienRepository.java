package com.example.OnCuoi.repository;

import com.example.OnCuoi.config.HibernateConfig;
import com.example.OnCuoi.entity.NhanVien;
import com.example.OnCuoi.response.NhanVienResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NhanVienRepository {
    public List<NhanVienResponse> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        String hsql = "select new com.example.OnCuoi.response.NhanVienResponse(n.id, n.ma, n.ten, n.ngaySinh, n.diaChi, n.matKhau, n.trangThai,  c.id, c.ma, c.ten) from " +
                "NhanVien  n , ChucVu  c where  n.idCV = c.id";
        List<NhanVienResponse> result = session.createQuery(hsql).getResultList();
        session.close();
        return result;
    }

    public void create(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NhanVien getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        NhanVien nhanVien = (NhanVien) session.createQuery("from  NhanVien where id=:id").setParameter("id",id).getSingleResult();
        session.close();
        return nhanVien;
    }
}
