package com.ljg.msacatalog.service;

import com.ljg.msacatalog.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

}
