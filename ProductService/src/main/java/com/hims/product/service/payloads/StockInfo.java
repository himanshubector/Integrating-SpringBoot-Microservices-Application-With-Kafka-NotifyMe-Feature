package com.hims.product.service.payloads;


import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TrueFalseConverter;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockInfo
{
    private int productId;

    @Convert(converter = TrueFalseConverter.class)
    private boolean isAvailable;


    //private StockStatus status;

}
