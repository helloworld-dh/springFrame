#手写spring#

##泛型## 
    E Element:在集合中使用 T-Type：java类 K-Key: 键 V：Value N：Number

    1.泛型类的类型约束只在编译的时候有效，泛型信息在编译之后会被擦除，
    例如list<Stirng>，<string>会在编译之后消失

    能否在泛型里面使用具备继承关系的类
        使用通配符?，但是会使泛型的类型检查失去意义
        给泛型加入上边界 ? extends E
        给泛型加入下边界 ? super E

    2.泛型接口：具体类实现泛型接口，泛型类实现泛型接口

    3.泛型方法
        既能用在泛型类，泛型接口，也能用在普通类或者接口中
        泛型方法中的泛型标识符是独立于泛型类存在的
        泛型方法什么可以是静态的？
            泛型方法声明处所定义的泛型的类型参数，会在调用方法时同步确定对应的具体类型，因此能够在不
            创建任何实例的情况下通过类型.方法名的方式来调用方法，符合静态方法的设计初衷

##工厂模式##

    简单工厂模式(demo/pattern/factory)
        定义一个工厂类,根据传入的参数的值不同返回不同的实例
        被创建的实例具有共同的父类或者接口
        
        工厂方法模式(demo/pattern/factory)
            定义一个用于创建对象的接口，让子类决定实例化哪一个类
            对类的实例化延迟到其子类
        
        抽象工厂(demo/pattern/factory)
            提供一个创建一系列相关或者相互依赖对象的接口,对工厂模式进行了抽象，即对工厂进行抽象
            抽象工厂模式侧重的是同一产品族
            工厂方法模式更侧重于同一产品等级
            每个抽象产品派生多个具体产品类，每个抽象工厂派生多个具体工厂类，每个具体工厂负责一系列具体产品的实例创建
        
##反射 (demo/reflect)##

    允许程序在运行时来进行自我检查并且对内部的成员进行操作
    反射主要是指程序可以访问，检测和修改它本身状态或行为的一种能力，并能根据自身行为的状态和结果，调整或修改应用锁描述行为的状态和相关的语义
    反射可以在运行时判断任意一个对象所属的类，在运行时获取类的对象，在运行时访问java对象的属性，方法，构造方法等
    java.lang.reflect类库里面主要的类
        field:类中的成员变量
        Method:类中的方法
        Constructor：表示类的构造方法
        Array：该类提供了动态创建数组和访问数组元素的静态方法
    Class对象
        每个类都有唯一一个与之相对应的Class对象(编译类产生,加载.class文件生成内存中的Class对象)
        Class是类的一种，只有一个私有的构造函数，只有JVM能够创建Class类的实例
        JVM中只有唯一一个和类相对应的Class对象来描述其类型信息
    获取Class对象的三种方式
        Object：object.getClass()
        任何数据类型(包括基本数据类型)都有一个静态的的class属性
        通过Class类的静态方法：forName(String className)**
        在运行期间，一个类只有一个与之相对应的Class对象产生
    主要用法
        如何获取类的构造方法并使用
        如何获取类的成员变量并使用
        如何获取类的成员方法并使用
    通过Class对象可以获取某个类中的构造方法
    获取构造方法：
        1.批量的方法
            public Constructor[] getConstructors()：所有公有的构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(私有，受保护，默认，公有)
        2.获取单个的方法并调用
            public Constructor getConstructor(Class... parameterTypes):获取单个的公有的构造方法
            public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或者公有的
            调用构造方法：
            Constructor---> newInstance(Object... initargs)
    获取成员变量并调用：
        1.批量
            Field[] getFields()：获取所有的公有字段(可获取到父类的字段)
            Field[] getDeclaredFields()：获取所有字段(私有，公有，保护，默认)(不能获取父类的字段)
        2.单个
            public Field getField(String fieldName):获取某个公有的字段(可获取到父类的字段)
            public Field getDeclaredField(String fieldName)：获取某个字段(可以是私有)(不能获取父类的字段)
        设置字段的值：
            Field-->public void set(Object obj,Object value)
                obj:要设置的字段所在的对象
                value:要为字段设置的值
    获取成员方法并调用：
        1.批量
            public Method[] getMethods():获取所有公有方法(包含父类的方法，Object类)
            public Method[] getDeclaredMethods()：获取所有的成员方法，包括私有的(不包括继承的)
        2.获取单个的
            public Method getMethod(String name, Class<?>...parameterTypes):
                    参数：
                        name:方法名
                        Class：形参的Class类型对象
            public Method getDeclaredMethod(String name, Class<?>...parameterTypes)
        调用方法：
            Method--> public Object invoke(Object obj, Object... args):
                    参数说明：
                        obj:要调用的方法
                        args:调用方法时所传递的实参
            