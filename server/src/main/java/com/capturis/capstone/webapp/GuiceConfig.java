package com.capturis.capstone.webapp;
import com.capturis.capstone.webapp.api.ExampleResource;
import com.google.inject.servlet.ServletModule;

public class GuiceConfig extends ServletModule {
    @Override
    protected void configureServlets() {

        bind(ExampleResource.class);
//        bind(SecondResource.class);

        filter("*").through(CORSFilter.class);
    }
}
