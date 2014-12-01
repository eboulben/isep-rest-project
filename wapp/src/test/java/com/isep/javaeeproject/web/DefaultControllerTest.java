package com.isep.javaeeproject.web;

import com.isep.javaeeproject.web.mapping.WebMapping;
import com.isep.javaeeproject.web.utils.ControllerSimpleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultControllerTest extends ControllerSimpleTest {

    @Test
    public void defaultHandlerTest() throws Exception {
        this.mockMvc.perform(get(WebMapping.DEFAULT))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(WebMapping.REDIRECT_HOME))
                .andExpect(redirectedUrl(WebMapping.HOME));
    }

}