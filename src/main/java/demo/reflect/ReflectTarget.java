package demo.reflect;

/**
 * @ClassName: ReflectTarget
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class ReflectTarget extends ReflectTargetOrigin{

    public String name;
    protected int index;
    char type;
    private String targetInfo;

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    //默认类型
    ReflectTarget(String str){
        System.out.println("构造方法 s= "+str);
    }

    public ReflectTarget(){
        System.out.println("调用了公有的无参构造方法");
    }

    public ReflectTarget(char name){
        System.out.println("调用了带有一个参数的构造方法，参数值为 "+name);
    }

    public ReflectTarget(String name, int index){
        System.out.println("调用了带有一个参数的构造方法，参数值为 "+name+"序号"+index);
    }
    //protect类型
    protected ReflectTarget(boolean n){
        System.out.println("受保护的构造方法 n"+n);
    }
    //private类型
    private ReflectTarget(int index){
        System.out.println("私有的构造方法 序号："+index);
    }

    public void show1(String s){
        System.out.println("调用了公有的,String参数的show1():s="+s);
    }

    protected void show2(){
        System.out.println("调用了受保护的，无参的show2()");
    }

    void show3(){
        System.out.println("调用了默认的，无参的show3()");
    }

    private String show4(int index){
        System.out.println("调用了私有的，并且有返回值的,int参数的show4() index= "+index);
        return "show4result";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //object.getClass();
        ReflectTarget reflectTarget = new ReflectTarget();
        Class<? extends ReflectTarget> reflectTargetClass1 = reflectTarget.getClass();
        System.out.println(reflectTargetClass1.getName());

        //Object.class()
        Class reflectTargetClass2 = ReflectTarget.class;
        System.out.println(reflectTargetClass2.getName());

        //forName()
        Class<?> reflectTargetClass3 = Class.forName("demo.reflect.ReflectTarget");
        System.out.println(reflectTargetClass3.getName());



    }


}
