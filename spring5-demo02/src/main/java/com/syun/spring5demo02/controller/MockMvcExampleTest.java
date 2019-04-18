package com.syun.spring5demo02.controller;

import com.syun.spring5demo02.listener.TimeExecutorHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @description: 单元测试编写对于 controller 的调用
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-14 12:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcExampleTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;


    @Test
        public void test() throws Exception {

        MvcResult result = mvc.perform(get("/custom/testEvent")).andReturn();
        TimeExecutorHolder timeExecutorHolder = (TimeExecutorHolder) wac.getBean("timeExecutorHolder");
        int controllerSec = timeExecutorHolder.getTestTime("testController");
        int eventSec = timeExecutorHolder.getTestTime("sampleCustomEventListener");

        System.out.println("controllerSec: " + controllerSec);
        System.out.println("eventSec: " + eventSec);


        assertEquals("Listener for SampleCustomEvent should take 5 seconds before treating the request but it took " + eventSec + " instead", 5, eventSec);
        assertEquals("Because listener took 5 seconds to response, controller should also take 5 seconds before generating the view, but it took " + controllerSec + " instead", 5, controllerSec);

    }


    @Test
    public void otherTest() {
        TimeExecutorHolder timeHolder = (TimeExecutorHolder) this.wac.getBean("timeExecutorHolder");
        timeHolder.addNewTime("sampleCustomEventListener", -34);
        try {
            MvcResult result = mvc.perform(get("/testOtherEvent")).andReturn();
            ModelAndView view = result.getModelAndView();
            String expectedView = "success";
//            assertTrue("View name from /testEvent should be '"+expectedView+"' but was '"+view.getViewName()+"'", view.getViewName().equals(expectedView));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer eventSecObject = timeHolder.getTestTime("sampleCustomEventListener");
//        assertTrue("SampleCustomEventListener shouldn't be trigerred on OtherEvent but it was", eventSecObject.intValue() == -34);
    }



}
