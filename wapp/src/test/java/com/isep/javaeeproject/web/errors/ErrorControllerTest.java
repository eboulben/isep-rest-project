package com.isep.javaeeproject.web.errors;

import com.isep.javaeeproject.web.mapping.ErrorMapping;
import com.isep.javaeeproject.web.mapping.MappingResolver;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.utils.ControllerSimpleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ErrorControllerTest extends ControllerSimpleTest {

    @Test
    public void error404ResolverTest() throws Exception {
        this.mockMvc.perform(get(ErrorMapping.URL + ErrorMapping.WEBXML_404))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(ErrorMapping.REDIRECT_PAGE_404))
                .andExpect(redirectedUrl(ErrorMapping.URL + ErrorMapping.PAGE_404));
    }

    @Test
    public void page404Test() throws Exception {
        this.mockMvc.perform(get(ErrorMapping.URL + ErrorMapping.PAGE_404))
                .andExpect(status().isOk())
                .andExpect(view().name(Views.ERROR_404.getPath()))
                .andExpect(forwardedUrl(MappingResolver.getFromWebinf(Views.ERROR_404.getPath())));
    }

    @Test
    public void randomPageTest() throws Exception {
        this.mockMvc.perform(get("/totallyRandomUrlToTest"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }
}