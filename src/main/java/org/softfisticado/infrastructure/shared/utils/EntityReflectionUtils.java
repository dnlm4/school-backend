package org.softfisticado.infrastructure.shared.utils;

import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityReflectionUtils<T> {
    private List<Object> attributeValues;
    private String getAttributeColumnNames(Field field) {
        if(field.isAnnotationPresent(JoinColumn.class)) {
            return field.getAnnotation(JoinColumn.class).name();
        }else if(field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        }else{
            return field.getName();
        }
    }
    private Object extractValue(Object value) throws NoSuchFieldException, IllegalAccessException {
        Field idField = value.getClass().getDeclaredField("id");
        idField.setAccessible(true);
        return idField.get(value);
    }
    private Object validationAttributeValue(Field field,T entity) {
        try {
            Object value = field.get(entity);
            if(field.isAnnotationPresent(JoinColumn.class)) {
                return this.extractValue(value);
            }else{
                return value;
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getAttributesData(Field[] fields,T entity) {
        attributeValues = new ArrayList<>();
        StringBuilder attributeName = new StringBuilder();
        StringBuilder stringPosValues = new StringBuilder();
        List<String> attributeData = new ArrayList<>();
        int posValue = 0;
        for (Field field : fields) {
            if(!field.isSynthetic() && field.getName().startsWith("$")) {
                break;
            }
            if(field.isAnnotationPresent(Id.class)){
                continue;
            }
            if (posValue>0){
                attributeName.append(',');
                stringPosValues.append(',');
            }
            posValue++;
            attributeName.append(this.getAttributeColumnNames(field));
            stringPosValues.append("$").append(posValue);
            field.setAccessible(true);
            this.attributeValues.add(this.validationAttributeValue(field,entity));
        }
        attributeData.add(attributeName.toString());
        attributeData.add(stringPosValues.toString());
        return attributeData;
    }
    public Tuple getAttributeValues(){
        Tuple valuesTuple = Tuple.tuple();
        for (Object attributeValue : (List<Object>) attributeValues) {
            valuesTuple.addValue(attributeValue);
        }
        return valuesTuple;
    }
}
