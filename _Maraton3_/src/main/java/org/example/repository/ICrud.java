package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T>  {
    T save(T t);

    T findById(Long id);
}
