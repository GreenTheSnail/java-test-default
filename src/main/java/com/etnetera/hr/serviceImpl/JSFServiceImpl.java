package com.etnetera.hr.serviceImpl;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.Version;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.etnetera.hr.repository.VersionRepository;
import com.etnetera.hr.service.JSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class JSFServiceImpl implements JSFService {

    private final JavaScriptFrameworkRepository repository;

    @Autowired
    public JSFServiceImpl(JavaScriptFrameworkRepository repository) {
        this.repository = repository;
    }
    @Override
    public boolean save(JavaScriptFramework javaScriptFramework) {
        repository.save(javaScriptFramework);
        return true;
    }

    @Override
    public List<JavaScriptFramework> findAll() {
        List<JavaScriptFramework> res = new ArrayList<>();
        repository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public JavaScriptFramework getById(Long id) {
        Optional<JavaScriptFramework> byId = repository.findById(id);
        if(byId.isEmpty()){
            return null;
        }
        return byId.get();
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
