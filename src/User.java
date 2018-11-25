
@PackageOwner(getInfoClass = User.class)
public class User {

	public String name = "小熊啊";
	private Integer age = 22;
	public String description = "这是一个测试用例！";

	/**
	 * 1，注解参数为Class对象
	 * 
	 * @return
	 */
	@PackageOwner(getInfoClass = User.class)
	public String getString() {

		return "我是公有方法";
	}

	/**
	 * 2，注解参数为String默认的value()方法可以不用写参数名，即括号中不用写@PackageOwner( ? = ? )，直接将值填入括号即可
	 */
	@PackageOwner("value方法覆盖默认")
	public void demo_1() {
		System.out.println("demo_1执行中");
		System.out.println("...");
		System.out.println("demo_1执行完成");
	}

}
