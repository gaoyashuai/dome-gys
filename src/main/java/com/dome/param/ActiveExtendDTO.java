package com.dome.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class ActiveExtendDTO {

    @NotBlank(message = "最小数量不可为空")
    private Long commodityMinNum;

    @NotBlank(message = "最大数量不可为空")
    private Long commodityMaxNum;

}