package com.phani.services.rest.restfulservices.clientDTO;

import java.util.List;

public class CategoryListDTO {

    private List<CategoryDTO> data;

    public List<CategoryDTO> getData() {
        return data;
    }

    public void setData(List<CategoryDTO> data) {
        this.data = data;
    }
}
