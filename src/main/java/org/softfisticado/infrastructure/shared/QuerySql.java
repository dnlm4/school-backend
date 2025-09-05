package org.softfisticado.infrastructure.shared;

import org.softfisticado.infrastructure.shared.utils.EntityReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class QuerySql<T> extends EntityReflectionUtils {

    public String buildQuery(T entity){
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO school.");
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String tableName = clazz.getSimpleName().toLowerCase();
        sqlQuery.append(tableName).append("(");
        List<String> attributesData = this.getAttributesData(fields, entity);
        sqlQuery.append(attributesData.getFirst()).append(") VALUES (").append(attributesData.get(1)).append(")  RETURNING id");
        return sqlQuery.toString();
    }
}
