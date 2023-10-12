package com.codefest.ejcraft.config;

import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class SpringAsyncConfig {
  @Value("${getJiraInfoExecutor.thread.CorePoolSize}")
  int corePoolSize;

  @Value("${getJiraInfoExecutor.thread.MaxPoolSize}")
  int maxPoolSize;

  @Value("${getJiraInfoExecutor.thread.QueueCapacity}")
  int queueCapacity;

  @Bean(name = "getJiraInfoExecutor")
  public Executor getJiraInfoExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setThreadNamePrefix("getJiraInfo");
    executor.initialize();

    return executor;
  }
}
