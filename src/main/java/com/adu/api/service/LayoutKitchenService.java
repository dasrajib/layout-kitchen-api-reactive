package com.adu.api.service;

import com.adu.api.model.LayoutKitchen;
import com.adu.api.repository.LayoutKitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LayoutKitchenService {

    private final LayoutKitchenRepository layoutkitchenRepository;

    public Flux<LayoutKitchen> getAllLayoutKitchen() {
        return layoutkitchenRepository.findAll();
    }

    public Mono<LayoutKitchen> getLayoutKitchenById(Long layoutkitchen_id) {
        return layoutkitchenRepository.findById(layoutkitchen_id);
    }

    public Mono<LayoutKitchen> createLayoutKitchen(LayoutKitchen layoutkitchen) {
        return layoutkitchenRepository.save(layoutkitchen);
    }

    public Mono<LayoutKitchen> updateLayoutKitchen(Long layoutkitchen_id, LayoutKitchen layoutkitchen) {
        return layoutkitchenRepository.findById(layoutkitchen_id)
                .flatMap(existingLayoutKitchen -> {
                    existingLayoutKitchen.setDescription(layoutkitchen.getDescription());
                    existingLayoutKitchen.setExt_description(layoutkitchen.getExt_description());
                    existingLayoutKitchen.setUpgrade(layoutkitchen.isUpgrade());
                    existingLayoutKitchen.setPrice(layoutkitchen.getPrice());

                    existingLayoutKitchen.setUpdated_at(LocalDateTime.now());
                
                    return layoutkitchenRepository.save(existingLayoutKitchen);
                });
    }

    public Mono<Void> deleteLayoutKitchen(Long layoutkitchen_id) {
        return layoutkitchenRepository.deleteById(layoutkitchen_id);
    }
}
