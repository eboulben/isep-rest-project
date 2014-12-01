package com.isep.javaeeproject.web.mapping;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.File;

public class ViewsTest {

    @Test
    public void doJspPagesInViewsExistTest() {

        final String OS_PROPERTY = System.getProperty("user.dir");
        String pathToFile, errorMessage;
        File file;

        for (Views views : Views.values()) {
            pathToFile = new StringBuilder()
                    .append(OS_PROPERTY)
                    .append(MappingResolver.getFromSrc(views.getPath()))
                    .toString();
            file = new File(pathToFile);
            errorMessage = new StringBuilder()
                    .append("Error this jsp file has not been found\n")
                    .append(pathToFile)
                    .append("\nLook after declaration in the Views enum, value of ")
                    .append(views.name())
                    .toString();
            Assert.isTrue(file.exists(), errorMessage);
        }
    }
}