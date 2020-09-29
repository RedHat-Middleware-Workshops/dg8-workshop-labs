package com.redhat.com.rhdg.config;

import org.infinispan.commons.marshall.JavaSerializationMarshaller;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.spring.embedded.session.configuration.EnableInfinispanEmbeddedHttpSession;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.infinispan.spring.starter.embedded.InfinispanGlobalConfigurer;

import com.redhat.com.rhdg.CacheListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Add an Infinispan annotation here
@Configuration
public class EmbeddedCacheConfig {

  // TODO: Add cacheConfigurer method here


  // TODO: Add globalCustomizer method here

}