这里面People是单表

Order和Customer是一对多

Account和Course 是多对多

总结一下Hibernate和Mybatis的区别之一吧，
我现在理解的一个区别是，我们在处理一对多，或者多对多表的时候，处理entity，

使用Mybatis只需要加一个类似于int cid 的字段，来映射外键，
然后查询的时候需要手动去写sql的left join语句查询

使用Hibernate则需要在在我们的entity实体类中中定义一个List<OrderItem>类型的属性，
这个属性可以映射到数据库中的一张订单项表，并通过外键关联到订单表，
然后查询的时候，我们使用面向对象的方式来操作表，不用去写sql，可能这也是大家所说hibernate的全自动，mybatis半自动吧。

还有一个坑就是：我们使用lombok的@Data时，会加get，set，tostring方法，
但是我们在hibernate多对多的entity实体类中，会互相加另一张表Set<Course> courses，
这样的话这张表也会被加到tostring中，如果我们想打印这个实体类的对象，
tostring使得它又会去调用另一个表的实体类的tostring，然后互相调用，最后爆栈，控制台打印的是反复调用查询的错误。


补上修改和删除的HQL
#### 9.修改hql

```
update Student set name = :newName where id = :idValue
```

其中，EntityName是要修改的实体类名，propertyName是要修改的属性名，newValue是新的属性值，condition是修改的条件。在条件中可以使用实体类的属性和关键字来构造查询条件

例子：

```
String hql = "update Student set name = :newName where id = :idValue";
Query query = session.createQuery(hql);
query.setParameter("newName", "Tom");
query.setParameter("idValue", 1);
int result = query.executeUpdate();
```

#### 10. 删除

```
delete from EntityName where condition
```

EntityName是要删除的实体类名，condition是删除的条件。在条件中可以使用实体类的属性和关键字来构造查询条件

```
String hql = "delete from Student where id = :idValue";
    Query query = session.createQuery(hql);
    query.setParameter("idValue", 1);
    int result = query.executeUpdate();
```

