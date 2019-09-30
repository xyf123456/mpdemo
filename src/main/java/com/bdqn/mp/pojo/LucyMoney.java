package com.bdqn.mp.pojo;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @ClassName: com.bdqn.mp.pojo.LucyMoney
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/9/2 0002 下午 10:38
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@Data
public class LucyMoney {
    private Integer id;
    private BigDecimal money;

    private String producer;//发送方
    private String consumer;//接受方

}
