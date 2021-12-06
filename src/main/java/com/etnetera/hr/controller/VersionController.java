package com.etnetera.hr.controller;

import com.etnetera.hr.data.Version;
import com.etnetera.hr.serviceImpl.JSFServiceImpl;
import com.etnetera.hr.serviceImpl.VersionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VersionController {

    private final VersionServiceImpl versionService;

    private final JSFServiceImpl jsfService;

    @Autowired
    public VersionController(VersionServiceImpl versionService, JSFServiceImpl jsfService) {
        this.versionService = versionService;
        this.jsfService = jsfService;
    }

    @GetMapping("/frameworks/{frameworkId}/versions")
    public Iterable<Version> versionsByFrameworkId(@PathVariable(value = "frameworkId") long frameworkId) {
        return versionService.findByFrameworkId(frameworkId);
    }

    @PostMapping("/frameworks/{frameworkId}/versions/add")
    public Boolean versionsVersionAdd(@PathVariable(value = "frameworkId") long frameworkId, @RequestParam String name){
        Version version = new Version();
        version.setId(versionService.count());
        version.setJavaScriptFramework(jsfService.getById(frameworkId));
        version.setName(name);
        versionService.save(version);
        return true;
    }

    @PostMapping("/versions/{id}/remove")
    public Boolean versionsVersionsDelete(@PathVariable(value = "id") long id) {
        versionService.delete(id);
        return true;
    }
}
