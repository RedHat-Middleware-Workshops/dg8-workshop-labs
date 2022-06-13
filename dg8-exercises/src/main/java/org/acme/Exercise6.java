package org.acme;

import java.io.IOException;
import java.util.List;

import org.infinispan.Cache;
import org.infinispan.commons.api.CacheContainerAdmin;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.IndexStorage;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.query.Search;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;

import java.util.List;

public class Exercise6 {

    public static void main(String[] args) {

        /* UNCOMMENT When starting this exercise

      // Create cache manager
      try (EmbeddedCacheManager cacheManager = new DefaultCacheManager()) {

         // Create cache config
         ConfigurationBuilder builder = new ConfigurationBuilder();
         builder.indexing()
               .enable()
               .storage(IndexStorage.LOCAL_HEAP)
               .addIndexedEntity(Person.class);

         // Obtain the cache
         Cache<String, Person> cache = cacheManager.administration()
               .withFlags(CacheContainerAdmin.AdminFlag.VOLATILE)
               .getOrCreateCache("cache", builder.build());

         // Store some entries
         cache.put("person1", new Person("William", "Shakespeare"));
         cache.put("person2", new Person("William", "Wordsworth"));
         cache.put("person3", new Person("John", "Milton"));

        // TODO: Obtain a query factory for the cache
        

         // List the results
         matches.forEach(person -> System.out.printf("Match: %s%n", person));
         // Stop the cache manager and release all resources
         cacheManager.stop();


        System.exit(0);

        UNCOMMENT When starting this exercise */
    }

}
