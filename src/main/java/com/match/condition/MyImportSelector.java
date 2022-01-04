package com.match.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * @author matchfu
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata AnnotationMetadata：当前标注@Import注解类的所有注解信息
     * @return 导入容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.match.bean.Blue", "com.match.bean.Yellow"};
    }
}
