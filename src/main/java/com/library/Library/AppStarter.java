package com.library.Library;

import com.library.Library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@PropertySource("classpath:custom.properties")
@Component

public class AppStarter implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {

    }

}
