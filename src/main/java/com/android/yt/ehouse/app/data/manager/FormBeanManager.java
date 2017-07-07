package com.android.yt.ehouse.app.data.manager;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.android.yt.ehouse.app.component.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by feng on 2017/7/7.
 */

public class FormBeanManager<T> {

    private T t;
    private final ArrayList<Field> descriptionFields;

    public FormBeanManager(T t) {
        this.t = t;
        Field[] allFields = t.getClass().getDeclaredFields();
        descriptionFields = new ArrayList<>();
        if (allFields != null && allFields.length > 0) {
            for (Field field : allFields) {
                Annotation[] annotations = field.getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    for (Annotation annotation : annotations) {
                        if (annotation instanceof Description) {
                            descriptionFields.add(field);
                            break;
                        }
                    }
                }
            }
            Collections.sort(descriptionFields, new Comparator<Field>() {
                @Override
                public int compare(Field o1, Field o2) {
                    return ((Integer) o1.getAnnotation(Description.class).index()).compareTo(o2.getAnnotation(Description.class).index());
                }
            });
        }
    }

    @SuppressLint("WrongConstant")
    public String isEmptyField() {
        try {
            for (Field field : descriptionFields) {
                if (field.getModifiers() == Modifier.PRIVATE) {
                    field.setAccessible(true);
                }
                Object o = field.get(t);
                if (o == null || TextUtils.isEmpty(o.toString())) {
                    return field.getAnnotation(Description.class).description();
                }
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }
}
