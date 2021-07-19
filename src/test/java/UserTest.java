import com.wyx.entity.*;
import com.wyx.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
public class UserTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = context.getBean("UserServiceImpl", UserService.class);
//        List<User> users = bean.queryAllUser();

    }
    @Test
    public void test02(){
        User user = new User("wen111","123");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean("UserServiceImpl", UserService.class);
        Boolean name = service.queryByName("wen121");
        System.out.println(name);
    }

    @Test
    public void test03(){
        ReaderBook book = new ReaderBook("wen111", "java", "12345");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ReBookService bean = context.getBean("ReBookServiceImpl", ReBookService.class);
        List<ReaderBook> a = bean.queryByBookNa("Mysql入门到地狱");
        System.out.println(a);
    }
    @Test
    public void test05(){
        BookList bookList = new BookList("Mysql入门到地狱", "小艺", "11111", "Mysql", "中文", "库存", 99);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bean = context.getBean("BookServiceImpl", BookService.class);
        List<BookList> lists = bean.queryByAuthor("小文");
        if(lists.size () ==0){
            System.out.println("nihao");
        }else {
            System.out.println(lists);
        }
    }
    @Test
    public void test04(){
        int a = 10;
        int b = 23;
        a = a^b; //a变成了密文
        b = a^b;
        a= a^b;
        System.out.println(a);
    }
}
