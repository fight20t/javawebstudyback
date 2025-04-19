package com.itheima.controller;


import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@RestController
//public class UserController {
//    @RequestMapping("/list")
//    public String list() {
//        //1.加载并读取文件
//        //InputStream的getClass().getClassLoader()方法可以获取当前类的类加载器，类加载器可以用来加载类和资源文件
//        //getResourceAsStream()方法可以获取指定路径的资源文件的输入流
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        //IoUtil是Hutool工具类库中的一个工具类，提供了很多常用的IO操作方法
//        //readLines()方法可以读取输入流中的所有行，并将每一行作为一个字符串存储在List中
//        //readLines中的第一个参数是输入流，第二个参数是字符集，第三个参数是存储读取到的字符串的List
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        //2.解析数据，封装成对象-->对象
//        //stream()方法可以将List转换为Stream流，map()方法可以对每个元素进行处理，最后使用toList()方法将结果转换为List
//        //map()方法中的lambda表达式可以将每一行字符串转换为User对象
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//            return new User(id, username, password, name, age, updateTime);
//        }).toList();
//
//
//        //3.响应数据
//        //将List转换为JSON字符串
//        return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
//
//
//    }
//
//}
@RestController
public class UserController {
    @Autowired
    private UserService UserService = new UserServiceImpl();

    //这一句的语法结构是： private 类名 变量名 = new 类名();
    //类名和变量名是可以自定义的，new后面是类的构造方法，new后面是类的实例化对象
    //这句话的意思是：创建一个UserServiceImpl类的实例，并将其赋值给名为UserService的变量
    @RequestMapping("/list")
    public String list() {
        //1.调用service层的数据
        List<User> userList = UserService.findAll();

        /*
        1. List<User>
List 是 Java 集合框架中的一个接口，表示一个有序的元素集合。它允许存储重复的元素，并可以通过索引访问每个元素。
<User> 是泛型，表示这个 List 中只能存储 User 类型的对象。使用泛型可以保证类型安全，避免向列表中添加其他类型的对象。
2. userList
这是变量名，用于存储 findAll() 方法返回的 List<User> 对象。
变量名 userList 是开发者自定义的，目的是让代码更具可读性，表示这个变量存储的是用户列表。
3. UserService.findAll()
UserService 是 UserServiceImpl 类的一个实例，UserServiceImpl 实现了 UserService 接口。
findAll() 是 UserService 接口中定义的方法，由 UserServiceImpl 实现。它的作用是从数据源（例如数据库或文件）中获取所有用户数据，并返回一个 List<User>。
为什么调用 findAll() 方法？
findAll() 方法被调用是为了从服务层获取所有用户数据。服务层的作用是处理业务逻辑，并与数据访问层交互，确保控制层（如 UserController）与数据访问层解耦。
总结
这行代码的作用是通过服务层调用 findAll() 方法，获取所有用户数据，并将其存储到变量 userList 中。userList 是一个 List，其中的每个元素都是 User 类型的对象。
         */


        //3.响应数据
        //将List转换为JSON字符串
        return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));


    }

}



