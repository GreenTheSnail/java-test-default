//package com.etnetera.hr.controller;
//
//import com.etnetera.hr.data.JavaScriptFramework;
//import com.etnetera.hr.serviceImpl.JSFServiceImpl;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class JavaScriptFrameworkControllerTest {
//
//    @Autowired
//    private JavaScriptFrameworkController javaScriptFrameworkController;
//
//
//    @Test
//    void testFrameworks() {
//
//    }
//
//    @Test
//    void testFrameworksFrameworkAdd() {
//        JSFServiceImpl jsfService = Mockito.mock(JSFServiceImpl.class);
//        JavaScriptFramework react = new JavaScriptFramework(1L,"ReactJS", LocalDate.of(2019, 10, 10), 10, new ArrayList<>());
//        when(jsfService.save(react)).thenReturn(true);
//        boolean isFrameworkAdded = javaScriptFrameworkController.frameworksFrameworkAdd(react);
//        Mockito.verify(jsfService, Mockito.times(1)).save(any());
//        assertTrue(isFrameworkAdded);
//    }
//
//    @Test
//    void testFrameworksDetail() {
//        JSFServiceImpl jsfService = Mockito.mock(JSFServiceImpl.class);
//        JavaScriptFramework react = new JavaScriptFramework(1L,"ReactJS", LocalDate.of(2019, 10, 10), 10, new ArrayList<>());
//        when(jsfService.getById(anyLong())).thenReturn(react);
//        assertEquals(react.getName(), javaScriptFrameworkController.frameworksDetail(1L).getName());
//    }
//
//    @Test
//    void testFrameworksFrameworksUpdate() {
//        JSFServiceImpl jsfService = Mockito.mock(JSFServiceImpl.class);
//        JavaScriptFramework react = new JavaScriptFramework(10L,"ReactJS", LocalDate.of(2019, 10, 10), 10, new ArrayList<>());
//        JavaScriptFramework notReactJS = new JavaScriptFramework(10L, "NotReactJS", LocalDate.of(2019, 10, 10), 10, new ArrayList<>());
//        when(jsfService.getById(notReactJS.getId())).thenReturn(notReactJS);
//        when(jsfService.save(react)).thenReturn(true);
//        assertTrue(javaScriptFrameworkController.frameworksFrameworksUpdate(react.getId(), react));
//    }
//
//    @Test
//    void testFrameworksFrameworksDelete() {
//        JSFServiceImpl jsfService = Mockito.mock(JSFServiceImpl.class);
//        when(jsfService.delete(1L)).thenReturn(true);
//        boolean isFrameworkDeleted = javaScriptFrameworkController.frameworksFrameworksDelete(1L);
//        assertTrue(isFrameworkDeleted);
//    }
//}