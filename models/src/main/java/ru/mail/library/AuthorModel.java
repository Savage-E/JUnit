package ru.mail.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Setter
@Getter
public class AuthorModel {
    private @NotNull String name;
}
