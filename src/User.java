
public class User {

    private String name="小熊啊";
    public Integer age=22;
    public String description="这是一个测试用例！";


    @PackageOwner(getInfoClass = User.class)
    public String getString(){

        return "我是公有方法";
    }


    @PackageOwner("value方法覆盖默认")
    public void demo_1(){
        System.out.println("demo_1执行中");
        System.out.println("...");
        System.out.println("demo_1执行完成");
    }

}
