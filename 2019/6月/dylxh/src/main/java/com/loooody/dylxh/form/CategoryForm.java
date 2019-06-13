package com.loooody.dylxh.form;

import lombok.Data;

/**
 * @ClassName: CategoryForm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 上午11:06
 * @Version 1.0
 **/

@Data
public class CategoryForm {

    private Integer categoryId;

    //类目名字
    private String categoryName;

    //类目类型
    private Integer categoryType;

}
