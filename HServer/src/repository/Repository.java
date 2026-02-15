/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Nikola
 * @param <T>
 * @param <K>
 */
public interface Repository<T, K> {
    List<T> getAll(T t) throws Exception;
    void add(T t) throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    T getById(K k) throws Exception;
}
