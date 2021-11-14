# FundamentalSpringBoots

# @RequestMapping
    @RequestMapping  là một trong những annoation sử dụng nhiều nhất trong Spring MVC.
    Annotation @RequestMapping được sử dụng để map request với class hoặc method xử lý request đó.
    @RequestMapping có thể được áp dụng với controller class hoặc method trong controller class.
    1.1 @RequestMapping với class:
    •	@Controller
    •	@RequestMapping("/index")
    •	public class BaseController {
    •	
    •	public String index() {
    •	return "index";
    •	}
    •	
    •	}
    •Class BaseController sẽ đóng vai trò như là 1 class Servlet xử lý URL “/index”
    1.2 @RequestMapping với method:
    •	@Controller
    •	public class HomeController {
    •	
    •	@RequestMapping("/method0")
    •	public String method0() {
    •	return "page0";
    •	}
    •	
    •	@RequestMapping("/method1")
    •	public String method1() {
    •	return "page1";
    •	}
    •	}
    •Class HomeController sẽ xử lý 2 URL là “/method1”, “/method2”.
    1.3 @RequestMapping với nhiều URI:
    •	@RequestMapping(value = { "/", "/home" })
    •	public String home() {
    •	return "home";
    •	}
    •Method home()Sẽ xử lý cả 2 URL “/” và “/home”
    1.4 @RequestMapping với HTTP Method:
    •	@RequestMapping(value="/test", method = RequestMethod.GET)
    •	public String doGet() {
    •	return "test1";
    •	}
    •	
    •	@RequestMapping(value="/test", method = RequestMethod.POST)
    •	public String doPost() {
    •	return "test2";
    •	}
    •Cùng là 1 URL “/test” nhưng request tới có method là GET sẽ được xử lý bởi method doGet() còn request có method là POST sẽ được xử lý bởi method doPost().
    Nếu không chỉ rõ HTTP method thì mặc định controller sẽ xử lý tất cả các HTTP method.
    1.5 @RequestMapping với Header:
    •	@RequestMapping(value = "/method0", headers = "name=kai")
    •	public String method0() {
    •	return "page0";
    •	}
    •	
    •	@RequestMapping(value = "/method1", headers = { "name=kai", "id=1" })
    •	public String method1() {
    •	return "page1";
    •	}
    •Khi chỉ rõ headers trong @RequestMapping thì nó sẽ chỉ xử lý những request có header chứa các tham số đã chỉ rõ
    •Ví dụ như method0() sẽ chỉ xử lý request có header chứa cặp key-value là name-kai
    •1.6 @RequestMapping với Produces và Consumes:
    •	@RequestMapping(value = "/method2", produces = { "application/json", "application/xml" }, consumes = "text/html")
    •	public String method2() {
    •	return "page2";
    •	}
    consumes: chỉ chấp nhận các request có content-type giống với giá trị khai báo bên trong consumes
    produces: kiểu dữ liệu trả về, cái này thường chỉ dùng với các REST-API.
    2.Code Ví dụ
    Thư viện sử dụng
    •	pom.xml
    •	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    •	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    •	<modelVersion>4.0.0</modelVersion>
    •	<groupId>stackjava.com</groupId>
    •	<artifactId>SpringAnnotation1</artifactId>
    •	<version>0.0.1-SNAPSHOT</version>
    •	<packaging>war</packaging>
    •	
    •	<properties>
    •	<spring.version>5.0.2.RELEASE</spring.version>
    •	</properties>
    •	<dependencies>
    •	<dependency>
    •	<groupId>org.springframework</groupId>
    •	<artifactId>spring-webmvc</artifactId>
    •	<version>${spring.version}</version>
    •	</dependency>
    •	</dependencies>
    •	</project>
    Controller:
    •	BaseController.java
    •	package stackjava.com.springmvchello.controller;
    •	
    •	import org.springframework.stereotype.Controller;
    •	import org.springframework.web.bind.annotation.RequestMapping;
    •	
    •	@Controller
    •	@RequestMapping("/index")
    •	public class BaseController {
    •	
    •	public String index() {
    •	return "index";
    •	}
    •	
    •	}
    •	HomeController.java
    •	package stackjava.com.springmvchello.controller;
    •	
    •	import org.springframework.stereotype.Controller;
    •	import org.springframework.web.bind.annotation.RequestMapping;
    •	import org.springframework.web.bind.annotation.RequestMethod;
    •	
    •	@Controller
    •	public class HomeController {
    •	
    •	@RequestMapping(value = { "/", "/home" })
    •	public String home() {
    •	return "home";
    •	}
    •	
    •	@RequestMapping(value = "/test", method = RequestMethod.GET)
    •	public String doGet() {
    •	return "test1";
    •	}
    •	
    •	@RequestMapping(value = "/test", method = RequestMethod.POST)
    •	public String doPost() {
    •	return "test2";
    •	}
    •	
    •	@RequestMapping(value = "/method0", headers = "name=kai")
    •	public String method0() {
    •	return "page0";
    •	}
    •	
    •	@RequestMapping(value = "/method1", headers = { "name=kai", "id=1" })
    •	public String method1() {
    •	return "page1";
    •	}
    •	
    •	@RequestMapping(value = "/method2", produces = { "application/json"}, consumes = "text/html")
    •	public String method2() {
    •	return "page2";
    •	}
    •	
    •	}
    Các file jsp:
    •	home.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>home.jsp</h2>
    •	<a href="home">/home</a> <br/>
    •	<a href="test">/test (GET)</a> <br/>
    •	<form method="post" action="test">
    •	<button type="submit">/test (POST)</button>
    •	</form>
    •	</body>
    •	</html>
    •	index.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>index.jsp</h2>
    •	</body>
    •	</html>
    •	test1.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>test1.jsp</h2>
    •	</body>
    •	</html>
    •	test2.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>test2.jsp</h2>
    •	</body>
    •	</html>
    •	page0.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>page0.jsp</h2>
    •	</body>
    •	</html>
    •	page1.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>page1.jsp</h2>
    •	</body>
    •	</html>
    •	page2.jsp
    •	<html>
    •	<head>
    •	<title>Spring MVC Annotation</title>
    •	</head>
    •	
    •	<body>
    •	<h2>page2.jsp</h2>
    •	</body>
    •	</html>
    Demo:


# @RestController
Khác với @Controller là sẽ trả về một template.
@RestController trả về dữ liệu dưới dạng JSON.
@RestController
@RequestMapping("/api/v1")
public class RestApiController{

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoList;
    }
}
Các đối tượng trả về dưới dạng Object sẽ được Spring Boot chuyển thành JSON.
Các đối tượng trả về rất đa dạng, bạn có thể trả về List, Map, v.v.. Spring Boot sẽ convert hết chúng thành JSON, mặc định sẽ dùng Jackson converter để làm điều đó.
Nếu bạn muốn API tùy biến được kiểu dữ liệu trả về, bạn có thể trả về đối tượng ResponseEntity của Spring cung cấp. Đây là đối tượng cha của mọi response và sẽ wrapper các object trả về. Cái này bạn xem tiếp phần dưới sẽ rõ.
# @RequestBody
Vì bây giờ chúng ta xây dựng API, nên các thông tin từ phía Client gửi lên Server sẽ nằm trong Body, và cũng dưới dạng JSON luôn.
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }

}
Tất nhiên là Spring Boot sẽ làm giúp chúng ta các phần nặng nhọc, nó chuyển chuỗi JSON trong request thành một Object Java. bạn chỉ cần cho nó biết cần chuyển JSON thành Object nào bằng Annotation @RequestBody
# @PathVariable
RESTful API là một tiêu chuẩn dùng trong việc thết kế các thiết kế API cho các ứng dụng web để quản lý các resource.
Và với cách thống nhất này, thì sẽ có một phần thông tin quan trọng sẽ nằm ngay trong chính URL của api.
Ví dụ:
1.	URL tạo To-do: https://loda.me/todo. Tương ứng với HTTP method là POST
2.	URL lấy thông tin To-do số 12: https://loda.me/todo/12. Tương ứng với HTTP method là GET
3.	URL sửa thông tin To-do số 12: https://loda.me/todo/12. Tương ứng với HTTP method là PUT
4.	URL xoá To-do số 12: https://loda.me/todo/12. Tương ứng với HTTP method là DELETE
Ngoài thông tin trong Body của request, thì cái chúng ta cần chính là cái con số 12 nằm trong URL. Phải lấy được con số đó thì mới biết được đối tượng To-do cần thao tác là gì.
@PathVariable tham chiến.
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId){
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }
}
# Demo
Chúng ta sẽ demo một server Rest API đơn giản với Spring Boot. Các API sẽ phục vụ việc thao tác với đối tượng To-do.
Giống bài #13 nhưng lần này là API chứ không phải website.
# Cài đặt
pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.5.RELEASE</version>
        <relativePath /> <!-- lookup parent from repository -->
    </parent>
    <groupId>me.loda.spring</groupId>
    <artifactId>spring-boot-learning</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-boot-learning</name>
    <description>Everything about Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>

        <!--spring mvc, rest-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        </plugins>
    </build>

</project>
Cấu trúc thư mục:
 
# Tạo model
Sử dụng Lombok cho tiện nha các bạn.
Todo.java
import lombok.Data;

@Data
public class Todo {
    private String title;
    private String detail;
}
# Tạo RestController
Phần này rất dễ, thay @Controller thành RestController thôi :)) đùa đấy, bạn xem code ở dưới nhẻ.
Vì tôi chỉ muốn Demo cách tạo API cho các bạn, nên chúng ta tạm bỏ qua Database nhé ;)
Bạn để ý 2 đoạn @RequestMapping và @PostConstruct nhé!
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 * 
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList = new CopyOnWriteArrayList<>();


    // bạn còn nhớ @PostConstruct dùng để làm gì chứ?
    // nếu không nhớ, hãy coi lại bài viết Spring Boot #3 nhé
    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
        todoList.add(null);
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoList;
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId){
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }


    /*
    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    thành đối tượng Todo
     */
    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId,
                         @RequestBody Todo todo){
        todoList.set(todoId, todo);
        // Trả về đối tượng sau khi đã edit
        return todo;    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId){
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }
}
# Chạy thử
App.java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
Server sẽ on trên port 8080.
Bây giờ chỉ cần Test thôi!
# Tạo ra một đối tượng To-do
POST http://localhost:8080/api/v1/todo
 
# Xem danh sách To-do
GET http://localhost:8080/api/v1/todo
 
# Sửa To-do
PUT http://localhost:8080/api/v1/todo/1
 
# Lấy thông tin To-do
GET http://localhost:8080/api/v1/todo/1
 
# Xóa To-do
DELETE http://localhost:8080/api/v1/todo/1

# Exception Handling @ExceptionHandler + @RestControllerAdvice / @ControllerAdvice + @ResponseStatus
Trong Giới thiệu trước chúng ta đã biết cách làm một Rest Api Server với Spring Boot.

 
Trong bài viết này, chúng ta sẽ tìm hiểu cách xử lý Exception trong Spring Boot
# @RestControllerAdvice & @ControllerAdvice + @ExceptionHandler
@RestControllerAdvice là một Annotation gắn trên Class. Có tác dụng xen vào quá trình xử lý của các @RestController. Tương tự với @ControllerAdvice
@RestControllerAdvice thường được kết hợp với @ExceptionHandler để cắt ngang quá trình xử lý của Controller, và xử lý các ngoại lệ xảy ra.
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage TodoException(Exception ex,  WebRequest request) {
        return new ErrorMessage(10100, "Đối tượng không tồn tại");
    }
}
Hiểu đơn giản là Controller đang hoạt động bình thường, chẳng may có một Exception được ném ra, thì thay vì báo lỗi hệ thống, thì nó sẽ được thằng @RestControllerAdvice và @ExceptionHandler đón lấy và xử lý. Sau đó trả về cho người dùng thông tin hữu ích hơn.
# @ResponseStatus
@ResponseStatus là một cách định nghĩa Http Status trả về cho người dùng.
Nếu bạn không muốn sử dụng ResponseEntity thì có thể dùng @ResponseStatus đánh dấu trên Object trả về.
# Demo
# Cài đặt
pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.5.RELEASE</version>
        <relativePath /> <!-- lookup parent from repository -->
    </parent>
    <groupId>me.loda.spring</groupId>
    <artifactId>spring-boot-learning</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-boot-learning</name>
    <description>Everything about Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>

        <!--spring mvc, rest-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        </plugins>
    </build>

</project>
Cấu trúc thư mục:
 
# Tạo model
Sử dụng Lombok cho tiện nha các bạn.
Todo.java
@Data
@AllArgsConstructor
public class Todo {
    private String title;
    private String detail;
}
Tạo ra class ErrorMessage để chứa thông tin trả về cho Client.
ErrorMessage.java
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
}
# Tạo Controller
RestApiController.java
/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 * <p>
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList;

    // bạn còn nhớ @PostConstruct dùng để làm gì chứ?
    // nếu không nhớ, hãy coi lại bài viết Spring Boot #3 nhé
    @PostConstruct
    public void init() {
        todoList = IntStream.range(0, 10)
                 .mapToObj(i -> new Todo("title-" + i, "detail-" + i))
                 .collect(Collectors.toList());
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }
}
# Tạo Exception Handler
ApiExceptionHandler.java
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(10000, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage TodoException(Exception ex, WebRequest request) {
        return new ErrorMessage(10100, "Đối tượng không tồn tại");
    }
}
# Chạy thử
App.java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
Gửi request tới địa chỉ:
GET http://localhost:8080/api/v1/todo/11
Ở đây, đối tượng 11 không tồn tại trong danh sách, chúng ta sẽ trả về lỗi cho phía Client.
 
# Ảnh minh họa:
## Success:
![success](https://user-images.githubusercontent.com/65969192/132095993-806429ac-a410-4b94-bf31-a1fc065ae982.png)

# Hướng dẫn sử dụng cơ bản, khai quát keyCloak với spring (Mình cũng đang học và luyện tập, nên có gì sai xót mong các bạn bỏ qua):
    - Đầu tiên bạn hãy lên trang web của keycloak vài tải bản keycloak-server về theo đường dẫn https://www.keycloak.org/downloads
    - Đối với máy chạy win: Tải về và giải nén, sau đó vô thu mục giải nén theo đường dẫn ../keycloak/bin và bật cmd lên rồi nhập câu lệnh: standalone.bat -Djboss.http.port=8180
        để start server kecloak, sau đó bạn vô trình duyệt web nhập: localhost:8180/auth, rồi tạo tài khoản admin rồi bắt đầu khám phá
 
# Kết
Đây là một bài viết trong Series làm chủ Spring Boot, từ zero to hero

