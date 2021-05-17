package com.ljg.msacatalog.controller;

import com.ljg.msacatalog.dto.ResponseCatalog;
import com.ljg.msacatalog.entity.CatalogEntity;
import com.ljg.msacatalog.repository.CatalogRepository;
import com.ljg.msacatalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {
    private final Environment environment;
    private final CatalogService catalogService;
    private final CatalogRepository catalogRepository;

    @GetMapping("/health_check")
    public String status() {
        return String.format("Catalog Service PORT: %s", environment.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity getCatalogs() {
        Iterable<CatalogEntity> catalogs = catalogService.getAllCatalogs();

        List<ResponseCatalog> catalogList = new ArrayList<>();
        catalogs.forEach(catalog -> {
            catalogList.add(new ModelMapper().map(catalog, ResponseCatalog.class));
        });

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(catalogList);
    }
}
