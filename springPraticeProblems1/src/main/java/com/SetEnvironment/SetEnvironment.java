package com.SetEnvironment;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetEnvironment {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(User.class)) {
            String msg = context.getBean("Msg");
            System.out.println(msg);
        } catch (BeansException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
