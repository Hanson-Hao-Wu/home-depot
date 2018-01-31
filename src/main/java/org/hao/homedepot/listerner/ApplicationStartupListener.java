package org.hao.homedepot.listerner;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {


    @Value("${homeDepot.customerReview.curseWords}")
    String curseWords;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


    }

}
