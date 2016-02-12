package com.elrond.controller;

import com.elrond.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ParametroControllerTest {

    @Autowired
    private ParametroController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {

    }

    @Test()
    public void contextLoads() throws Exception {

    }

}
