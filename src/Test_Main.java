import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test_Main {

    public static void main(String []args) throws IllegalAccessException {

        //创建一个User类的实例
        User user=new User();

        //得到这个类的所有方法
        Method[] methods = user.getClass().getMethods();

        //遍历这个类的所有方法集合
        for (Method m  :methods ) {
            //得到这个方法上的某个指定注解类（PackageOwner）的一个实例
            PackageOwner packageOwner = m.getDeclaredAnnotation(PackageOwner.class);
//            PackageOwner packageOwner = m.getAnnotation(PackageOwner.class);

            if(packageOwner!=null){
                //通过这个注解类的实例的某个方法，得到这个方法的返回值
                //-----此处这个注解类的方法叫getInfo，返回一个Class对象
                Class infoClass = packageOwner.getInfoClass();

                System.out.println("类名：\t\t\t\t-------->"+infoClass.getName());

                //通过这个Class对象得到他的所有字段信息
                Field[] fields = infoClass.getFields();

                //遍历这个Class对象的所有字段
                for (Field f:fields ) {
                    //得到user这个对象上这个字段的值
                    Object o = f.get(user);
                    //如果是String，则将他输出
                    if(o instanceof String ){
                        System.out.println("该字段是String类型，值为："+o);
                    }
                    if(o instanceof Integer){
                        System.out.println("该字段是Integer类型，值为："+o);
                    }
                }
            }
        }
    }
}
