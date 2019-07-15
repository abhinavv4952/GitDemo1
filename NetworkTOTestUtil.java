package com.cloud.agent.api.to;

import org.junit.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/*
   This is a utility class all the methods for testing TO class members data type using java reflection.
   This is added as part of VR backward compatibility feature
 */
public class NetworkTOTestUtil {

    void checkParamType(Class className, String memName, String memType, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking param "+memName + " param type"+ memType);
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertEquals(type.getTypeName(), memType);
    }

    void checkEnumParam(Class className, String memName, NetworkVRBackwardCompatTOTest.DummyEnum e, String enumType, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking the enum parameter");
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertTrue(((Class)type).isEnum());
        Class outer = ((Class) type).getEnclosingClass();
        //System.out.println(((Class) type).getEnclosingClass());
        Assert.assertEquals(((Class) type).getEnclosingClass().getName(), "com.cloud.network.vpc.NetworkACLItem");
    }

    void checkParamListString(Class className, String memNam, List<String> dummyList, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  List<String>");
        Field field = className.getDeclaredField(memNam);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type genericFieldType = field.getGenericType();

        ParameterizedType aType = (ParameterizedType) genericFieldType;
        Type rt = aType.getRawType();

        Assert.assertEquals(rt.getTypeName(), "java.util.List");

        Type[] fieldArgTypes = aType.getActualTypeArguments();
        for (Type fieldArgType : fieldArgTypes) {
            //Class fieldArgClass = (Class) fieldArgType;
            Assert.assertEquals(fieldArgType.getTypeName(), "java.lang.String");
            //System.out.println("fieldArgClass = " + fieldArgClass);
        }
    }

    void checkStringParam(Class className, String memName, String paramType, boolean isPrivate) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        System.out.println("Checking  String param");
        //Object aclto = cl.newInstance();
        //Class<?> aclToClass = cl;
        //Class<?> aclToClass = aclto.getClass();
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        System.out.println(type);
        System.out.println(type.getTypeName());
        Assert.assertEquals(type.getTypeName(), "java.lang.String");
    }

    void checkParamboolean(Class className, String memName, boolean dummyboolean, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  boolean param");
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        System.out.println(type);
        System.out.println(type.getTypeName());
        Assert.assertEquals(type.getTypeName(), "boolean");
    }



    void checkParamint(Class className, String memName, int dummyint, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  int param");
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertEquals(type.getTypeName(), "int");
    }

    void checkParamlong(Class className, String memName, long dummylong, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  long param");
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertEquals(type.getTypeName(), "long");
    }

    void checkParamInteger(Class className, String memName, Integer dummyint, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  Integer param");
        Field field = className.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertEquals(type.getTypeName(), "java.lang.Integer");
    }

    void checkParamLong(Class className, String memName, Long dummyLong, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  Long param");
        Field field = className.getDeclaredField(memName);

        if(isPrivate) {
            field.setAccessible(true);
        }
        Type type = field.getType();
        Assert.assertEquals(type.getTypeName(), "java.lang.Long");
    }

    void checkParamintArray(Class className, String memName, int[] dummyLong, boolean isPrivate) throws NoSuchFieldException {
        System.out.println("Checking  int array");
        Field field = className.getDeclaredField(memName);

        if(isPrivate) {
            field.setAccessible(true);
        }

        Type type = field.getGenericType();
        if (type instanceof Class && ((Class) type).isArray()) {
            Class componentType = ((Class) type).getComponentType();
            Assert.assertEquals(componentType.getTypeName(), "int");
        }

    }
}
