/**
 * @author João Paulo
 */

package main.java.br.com.luishep.DAO.generics;

import main.java.Annotation.TypeKey;
import main.java.br.com.luishep.domain.IPersister;
import main.java.br.com.luishep.exceptions.TypeKeyNotFound;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericsDAO<T extends IPersister, E extends Serializable> implements IGenericsDAO{
    private SingletonMap singletonMap;

    public abstract Class<T> getTypeClass();

    public abstract  void updateData(IPersister entity, IPersister entityRegistered);

    public GenericsDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public E getKey(T entity) throws TypeKeyNotFound {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field: fields) {
            if (field.isAnnotationPresent(TypeKey.class)) {
                TypeKey typeKey = field.getAnnotation(TypeKey.class);
                String nameMethod = typeKey.value();
                try {
                    Method method = entity.getClass().getMethod(nameMethod);
                    Long value = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new TypeKeyNotFound("Chave principal do objeto " + entity.getClass() + " não encontrada!", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto" + entity.getClass() + " não encontrada";
            System.out.println("*** ERRO ***" + msg);
            throw new TypeKeyNotFound(msg);
        }
        return null;
    }

    private Map<E, T> getMap() {
        Map<E, T> mapInternal = (Map<E, T>) this.singletonMap.getMap().get(getTypeClass());
        if (mapInternal == null) {
            mapInternal = new HashMap<>();
            this.singletonMap.getMap().put(getTypeClass(), mapInternal);
        }
        return mapInternal;
    }

    @Override
    public Boolean registerClient(IPersister entity) throws TypeKeyNotFound {
        Map<E, T> mapInternal = getMap();
        E key = getKey((T) entity);
        if (mapInternal.containsKey(key)) {
            return false;
        }

        mapInternal.put(key, (T) entity);
        return true;
    }

    @Override
    public void deleteClient(Serializable value) {
        Map<E, T> mapInternal = getMap();
        T objectRegistered = mapInternal.get(value);
        if (objectRegistered != null) {
            mapInternal.remove(value, objectRegistered);
        }
    }

    @Override
    public void editClient(IPersister entity) throws TypeKeyNotFound {
        Map<E, T> mapInternal = getMap();
        E key = getKey((T) entity);
        T objectRegistered = mapInternal.get(key);
        if (objectRegistered != null) {
            updateData((T) entity, objectRegistered);
        }
    }

    @Override
    public T research(Long cpf) {
        Map<E, T> mapInternal = getMap();
        return mapInternal.get(cpf);
    }

    @Override
    public Collection researchAll() {
        Map<E, T> mapInternal = getMap();
        return mapInternal.values();
    }
}
