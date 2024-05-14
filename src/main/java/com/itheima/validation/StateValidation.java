package com.itheima.validation;

import com.itheima.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @projectName: big-event
 * @package: com.itheima.validation
 * @className: StateValidation
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/14 12:29
 * @version: 1.0
 */


public class StateValidation implements ConstraintValidator<State,String> {


    /**
     * 有效
     *
     * @param value 将来要校验的数据
     * @param context 约束验证器上下文
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if (value ==null){
            return false;
        }
        if (value.equals("已发布")||value.equals("草稿")){
            return true;
        }
        return false;
    }
}
