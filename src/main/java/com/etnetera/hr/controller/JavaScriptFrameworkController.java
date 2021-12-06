package com.etnetera.hr.controller;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.serviceImpl.JSFServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST controller for accessing application logic.
 *
 * @author Etnetera
 */
@RestController
public class JavaScriptFrameworkController extends EtnRestController {

    private final JSFServiceImpl jsfService;

    @Autowired
    public JavaScriptFrameworkController(JSFServiceImpl jsfService) {
        this.jsfService = jsfService;
    }

    @GetMapping("/frameworks")
    public Iterable<JavaScriptFramework> frameworks() {
        return jsfService.findAll();
    }


    @PostMapping("/frameworks/add")
    public Boolean frameworksFrameworkAdd(@RequestBody JavaScriptFramework javaScriptFramework) {
        javaScriptFramework.setId(jsfService.count()+1);
        return jsfService.save(javaScriptFramework);
    }

    @GetMapping("/frameworks/{id}")
    public JavaScriptFramework frameworksDetail(@PathVariable(value = "id") long frameworkId) {
		return jsfService.getById(frameworkId);

    }


	@PostMapping("/frameworks/{id}/edit")
    public Boolean frameworksFrameworksUpdate(
            @PathVariable(value = "id") long frameworkId, @RequestBody JavaScriptFramework javaScriptFramework) {
        JavaScriptFramework framework = jsfService.getById(frameworkId);
        framework.setName(javaScriptFramework.getName());
        framework.setDeprecationDate(javaScriptFramework.getDeprecationDate());
        framework.setHypeLevel(javaScriptFramework.getHypeLevel());
        jsfService.save(framework);
        return true;
    }

    @PostMapping("/frameworks/{id}/remove")
    public Boolean frameworksFrameworksDelete(@PathVariable(value = "id") long frameworkId) {
        return jsfService.delete(frameworkId);
    }
}
