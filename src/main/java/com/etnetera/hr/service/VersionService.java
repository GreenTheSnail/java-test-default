package com.etnetera.hr.service;


import com.etnetera.hr.data.Version;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VersionService {
    void save(Version version);

    List<Version> findAll();

    Version getById(Long id);

    List<Version> findByFrameworkId(Long id);

    void delete(Long id);

    Long count();
}
