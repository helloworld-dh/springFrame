package org.simpleframework.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ClassUtil
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL="file";

    /**
     *  获取包下类的集合
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName){
         //获取到类的加载器，获取项目发布的实际路
        ClassLoader classLoader = getClassLoader();
        //通过类加载器获取到加载的资源信息
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if(url==null){
            log.warn("unable to retrieve anything from package: " +packageName);
            return null;
        }
        // 依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if(url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet = new HashSet<Class<?>>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet,packageDirectory,packageName);
        }
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件(包括子package里的class文件)
     * @param emptyClassSet  装载目标类的集合
     * @param fileSource  文件或者目录
     * @param packageName  包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        if(!fileSource.isDirectory()){
            return;
        }
        //如果是文件夹，则调用其listFiles方法获取文件夹下的文件或文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file.isDirectory()){
                    return true;
                }else{
                    //获取文件的绝对值路径
                    String absolutePath = file.getAbsolutePath();
                    if(absolutePath.endsWith(".class")){
                        //若是class文件，则直接加载
                        addToClassSet(absolutePath);
                    }
                }
                return false;
            }
            //根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
            private void addToClassSet(String absoluteFilePath) {
                //从class文件的绝对路径中提取出包含package的类名
                //如D:/Project/Codes/springFrame/target/classes/com/it/entity/dto/MainPageInfoDTO.class
                //需要弄成com.it.entity.dto.MainPageInfoDTO
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0,className.lastIndexOf("."));
                //通过反射机制获取对应的Class对象并加入到classSet里
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);

            }
        });

        if(files!=null){
            for (File file : files) {
                //递归调用
                extractClassFile(emptyClassSet,file,packageName);
            }
        }
    }

    /**
     * 获取class对象
     * @param className class全名=package+类名
     * @return
     */
    public static Class<?> loadClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:",e);
            throw new RuntimeException();
        }
    }

    /**
     * 获取classLoader
     * @return
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        extractPackageClass("com.it.entity");
    }

}
