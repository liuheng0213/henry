package basic.knowledge.henry.reflection.classAndItsInstances.getTrueClass;

import java.lang.reflect.ParameterizedType;

public class BaseCase<T> {
    public Class<T> getTrueClass(){
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];

        System.out.println(clazz);
        return clazz;
    }
}
