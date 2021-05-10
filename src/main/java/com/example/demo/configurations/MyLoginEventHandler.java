package com.example.demo.configurations;

import com.example.demo.controllers.CatController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class MyLoginEventHandler  implements ApplicationListener {
    @Autowired
    CatController controller;

    public MyLoginEventHandler() {
    }
   /*
the event is coming at successful login update list of pairs cats*/
    public void onApplicationEvent(ApplicationEvent appEvent)
    {
        if (appEvent instanceof AuthenticationSuccessEvent)
        {
            try {
                controller.setPairList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
