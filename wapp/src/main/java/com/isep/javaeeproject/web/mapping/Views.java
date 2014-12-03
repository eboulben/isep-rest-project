package com.isep.javaeeproject.web.mapping;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

public enum Views {

    HOME("home"), ERROR_404("errors/404"), USER("user/user");

    @NotNull
    private final String path;

    Views(@NotNull String path) {
        this.path = Preconditions.checkNotNull(path);
    }

    @NotNull
    public String getPath() {
        return this.path;
    }

}
