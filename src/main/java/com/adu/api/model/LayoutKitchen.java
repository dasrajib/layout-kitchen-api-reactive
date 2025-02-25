package com.adu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("layout_kitchen")
public class LayoutKitchen  {

    @Id
    private Long layout_kitchen_id;
    private String description;
    private String ext_description;
    private boolean upgrade;
    private float price;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
