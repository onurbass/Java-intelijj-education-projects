package org.example.repository;

import org.example.utility.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public interface ICrud <T> {
    T add(T t);
    T search(Long id);

}
