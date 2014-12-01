package com.isep.javaeeproject.web.home;

import com.isep.javaeeproject.web.mapping.MappingResolver;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import com.isep.javaeeproject.web.utils.ControllerSimpleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest extends ControllerSimpleTest {

    @Test
    public void homeTest() throws Exception {
        this.mockMvc.perform(get(WebMapping.HOME))
                .andExpect(status().isOk())
                .andExpect(view().name(Views.HOME.getPath()))
                .andExpect(forwardedUrl(MappingResolver.getFromWebinf(Views.HOME.getPath())));
    }

}
