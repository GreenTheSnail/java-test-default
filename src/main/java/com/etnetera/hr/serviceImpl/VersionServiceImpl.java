package com.etnetera.hr.serviceImpl;

import com.etnetera.hr.data.Version;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.etnetera.hr.repository.VersionRepository;
import com.etnetera.hr.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class VersionServiceImpl implements VersionService {

    private final VersionRepository repository;

    @Autowired
    public VersionServiceImpl(VersionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Version version) {
        repository.save(version);
    }

    @Override
    public List<Version> findAll() {
        List<Version> res = new ArrayList<>();
        repository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public Version getById(Long id) {
        Optional<Version> byId = repository.findById(id);
        if(byId.isEmpty()){
            return null;
        }
        return byId.get();
    }

    @Override
    public List<Version> findByFrameworkId(Long id) {
            return new ArrayList<>(repository.findVersionsByJavaScriptFrameworkId(id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
