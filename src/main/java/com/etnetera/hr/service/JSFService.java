package com.etnetera.hr.service;

import com.etnetera.hr.data.JavaScriptFramework;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JSFService {

    boolean save(JavaScriptFramework javaScriptFramework);

    List<JavaScriptFramework> findAll();

    JavaScriptFramework getById(Long id);

    boolean delete(Long id);

    Long count();
}
