package com.example.Admin_Test.Dto;

import com.example.Admin_Test.Entity.Inventory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapper {

    @JsonProperty("package")
    private String _package;
    private int size;
    private List<Inventory> data;

    public ResponseWrapper(String _package,int size, List<Inventory> data) {
        this._package = _package;
        this.size = data.size();
        this.data = data;
    }

}
