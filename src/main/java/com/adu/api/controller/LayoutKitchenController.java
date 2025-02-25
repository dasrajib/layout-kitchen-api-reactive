package com.adu.api.controller;

import com.adu.api.model.LayoutKitchen;
import com.adu.api.service.LayoutKitchenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/layoutkitchen")
@RequiredArgsConstructor
@Tag(name = "layoutkitchen Management", description = "APIs for managing layoutkitchen")
public class LayoutKitchenController {

    private final LayoutKitchenService layoutkitchenService;

    @GetMapping
    @Operation(summary = "Get all layoutkitchen")
    public Flux<LayoutKitchen> getAllLayoutKitchen() {
        return layoutkitchenService.getAllLayoutKitchen();
    }

    @GetMapping("/{layoutkitchen_id}")
    @Operation(summary = "Get layoutkitchen by ID")
    public Mono<LayoutKitchen> getLayoutKitchenById(@PathVariable Long layoutkitchen_id) {
        return layoutkitchenService.getLayoutKitchenById(layoutkitchen_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new layoutkitchen")
    public Mono<LayoutKitchen> createLayoutKitchen(@RequestBody LayoutKitchen layoutkitchen) {
        return layoutkitchenService.createLayoutKitchen(layoutkitchen);
    }

    @PutMapping("/{layoutkitchen_id}")
    @Operation(summary = "Update an existing layoutkitchen")
    public Mono<LayoutKitchen> updateLayoutKitchen(@PathVariable Long layoutkitchen_id, @RequestBody LayoutKitchen layoutkitchen) {
        return layoutkitchenService.updateLayoutKitchen(layoutkitchen_id, layoutkitchen);
    }

    @DeleteMapping("/{layoutkitchen_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a layoutkitchen")
    public Mono<Void> deleteLayoutKitchen(@PathVariable Long layoutkitchen_id) {
        return layoutkitchenService.deleteLayoutKitchen(layoutkitchen_id);
    }
}
