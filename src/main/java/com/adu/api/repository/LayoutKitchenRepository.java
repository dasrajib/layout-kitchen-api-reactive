package com.adu.api.repository;

import com.adu.api.model.LayoutKitchen;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LayoutKitchenRepository extends ReactiveCrudRepository<LayoutKitchen, Long> {

    Flux<LayoutKitchen> findByDescription(String description);    
}
