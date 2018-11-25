import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test_Main {

	public static void main(String[] args) throws IllegalAccessException {

		// 创建一个User类的实例
		User user = new User();

		PackageOwner packageOwner = user.getClass().getAnnotation(PackageOwner.class);

		if (packageOwner != null) { // 说明user类上面存在PackageOwner注解
			// 得到@PackageOwner(getInfoClass = ?.class)注解中getInfoClass()返回的Class
			Class infoClass = packageOwner.getInfoClass();
			// 得到@PackageOwner("?")注解中value()返回的String
			String value = packageOwner.value();
			// 得到@PackageOwner(getInfoString = "?")注解中getInfoString返回的String
			String infoString = packageOwner.getInfoString();

			// 输出类的注解的两个String内容
			System.out.println("infoString:" + infoString + "\nvalue:" + value);
			System.out.println("--------------------------------------------------------------------");

			// 得到注解参数中的Class对象，我们可以通过反射查看这个Class对象的信息

			// 得到这个对象的所有字段
			/**
			 * 注意 getFields()得到的是修饰为public的字段，但不包括private的字段
			 * getDeclaredFields()得到的是包含private的所有字段
			 */
			Field[] publicFields = infoClass.getFields();
			System.out.println(infoClass.getName() + "--->该类的public字段个数为：" + publicFields.length);

			Field[] AllFields = infoClass.getDeclaredFields();
			System.out.println(infoClass.getName() + "--->该类的字段总个数为：" + AllFields.length);

			System.out.println("--------------------------------------------------------------------");
			for (Field f : AllFields) {

				if (f.isAccessible()) {
					// 得到user对象的这个field的值
					Object object = f.get(user);

					if (object instanceof String)
						System.out.println("是String类型：" + object);
					if (object instanceof Integer)
						System.out.println("是Integer类型：" + object);

				} else {
					System.out.println(f.getName() + "字段是私有的------------------------------------------------->");
					f.setAccessible(true);

					Object object = f.get(user);

					System.out.println("字段的值为====" + object);
				}

			}

		}

		// 得到这个类的所有方法
//		Method[] methods = user.getClass().getMethods();
//
//        
//        //遍历这个类的所有方法集合
//        for (Method m  :methods ) {
//            //得到这个方法上的某个指定注解类（PackageOwner）的一个实例
//            PackageOwner packageOwner = m.getDeclaredAnnotation(PackageOwner.class);
////            PackageOwner packageOwner = m.getAnnotation(PackageOwner.class);
//
//            if(packageOwner!=null){
//                //通过这个注解类的实例的某个方法，得到这个方法的返回值
//                //-----此处这个注解类的方法叫getInfo，返回一个Class对象
//                Class infoClass = packageOwner.getInfoClass();
//
//                System.out.println("类名：\t\t\t\t-------->"+infoClass.getName());
//
//                //通过这个Class对象得到他的所有字段信息
//                Field[] fields = infoClass.getFields();
//
//                //遍历这个Class对象的所有字段
//                for (Field f:fields ) {
//                    //得到user这个对象上这个字段的值
//                    Object o = f.get(user);
//                    //如果是String，则将他输出
//                    if(o instanceof String ){
//                        System.out.println("该字段是String类型，值为："+o);
//                    }
//                    if(o instanceof Integer){
//                        System.out.println("该字段是Integer类型，值为："+o);
//                    }
//                }
//            }
//        }
	}
}
