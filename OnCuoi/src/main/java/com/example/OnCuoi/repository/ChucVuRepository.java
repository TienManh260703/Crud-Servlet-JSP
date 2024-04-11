package com.example.OnCuoi.repository;

import com.example.OnCuoi.config.HibernateConfig;
import com.example.OnCuoi.entity.ChucVu;
import org.hibernate.Session;

import java.util.List;

public class ChucVuRepository {

    public List<ChucVu> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<ChucVu> result = session.createQuery("from  ChucVu ").getResultList();
        session.close();
        return result;
    }
}
