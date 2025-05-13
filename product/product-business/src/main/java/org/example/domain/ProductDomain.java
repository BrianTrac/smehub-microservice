package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import vn.test.hub.core.domain.BaseDomain;

@Getter
@Setter
public class ProductDomain extends BaseDomain {
    private String type;
    private String name;
    private Double totalPrice;
    private String data;
}
