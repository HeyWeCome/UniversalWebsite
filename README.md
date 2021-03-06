### 关于包名
- 首先src文件夹分成六个包
1. annotation: 用来存放自定义的注解
2. control：处理事件流
3. dao: 用来存放对数据库进行的操作：增删改查
4. entity：用来存放实体类
5. server：用来控制和服务端的连接
6. service：业务处理，调用dao层方法
7. utils: 工具类
8. logs: 记录每天的完成的功能日志

- WebRoot目录下即对前台的书写

---

#### Control层
- Controller层负责具体的业务模块流程的控制， 
- 在此层里面要调用Service层的接口来控制业务流程，
- 针对具体的业务流程，会有不同的控制器，我们具体的设计过程中可以将流程进行抽象归纳，设计出可以重复利用的子单元流程模块，这样不仅使程序结构变得清晰，也大大减少了代码量。
- 我这里主要存放的是servelet

---

#### Dao层
- DAO层：DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此， 
- DAO层的设计首先是设计DAO的接口，
- 然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，显得结构非常清晰，
- 仅对数据库进行操作
- GeneralDao: 通用的增删改查方法
- SpecificDao: 满足特殊需求的数据库操作方法

---

#### Entity层以及数据库的构思
1. 栏目(columns)
- id				栏目ID
- name      		栏目名称
- level				栏目的级别

2. 子栏目(sonColumns)
- id				栏目ID
- name      		栏目名称
- level				栏目的级别
- parentID			上级栏目的ID

3. 文章(article)
- id				文章的ID
- title     		文章的标题
- employeeID		文章的作者(关联到用户ID)
- columnID			栏目ID
- content			文章的内容
- createTime		创建日期
- whetherTop		是否置顶(0:不置顶 1:置顶)
- status			文章状态(0:未审核 1: 审核通过 2:审核不通过)

4. 角色(role)
- id				角色ID
- name				角色名称
- createTime		创建时间
- description		描述角色功能

5. 权限(permission) 仅用于记录角色表和模块的连接
- id				权限ID
- roleID			角色ID
- moduleID			模块的ID

6. 父模块(module)
- id				模块ID
- name				模块名称
- status			模块状态(0:禁用 1:启用)

7. 子模块(sonModule)
- id				模块ID
- name				模块名称
- status			模块状态(0:禁用 1:启用)
- parentModuleID	父类模块ID


8. 人员(employee)
- id				员工ID
- name				员工姓名
- sex				员工性别
- account 			员工账号
- passWord			员工密码
- roleID			角色ID


9. 留言(message)
- id				留言ID
- content			留言内容
- createTime		留言时间
- reply				回复内容
- employeeID		回复人员ID
- replyTime			回复时间			
- status			回复状态(0:未回复 1:已回复)
- courseID			所属课程的ID


10. 教育资源(sourceFile)
- id				教育资源ID
- articleID			与文章管理相关联
- path   			存放的路径
- name				教育资源的名称
---

11. 课程(course)
- id				课程ID
- name				课程名
- introduction		课程的简略描述
- principal			课程负责人

12. 课程栏目(courseColumns)
- id				课程栏目ID
- courseID			课程ID
- columnsID			栏目ID


#### Server层
- 与服务器端建立连接

---

#### Service层
- Service层：Service层主要负责业务模块的逻辑应用设计。 
- 首先设计接口，再设计其实现的类
- Service层的业务实现，具体要调用到已定义的DAO层的接口，
- 封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。
- 主要是为了降低耦合度,Dao层仅用于处理数据库，Service用来处理逻辑业务。便于后期维护。

--------
