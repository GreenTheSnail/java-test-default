package com.etnetera.hr.repository;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.Version;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */
public interface VersionRepository extends CrudRepository<Version, Long> {
    List<Version> findVersionsByJavaScriptFrameworkId(Long id);
}
