# cici
宋词展示的网站，练手的项目

## ci.db
- 全宋词数据库，从已有的开源项目下载
https://raw.githubusercontent.com/chinese-poetry/chinese-poetry/master/ci/ci.db
- 另建了author表：原库中，ciauthor表里面有重复的名字（大概17个）

## relative techs
- backend: springboot2.0.2(jpa/springMvc/thymeleaf)
- frontend: jquery3.x,bootstrap4.x
- test framework: junit5
- database: sqlite
- project managerment: maven 4
- IDE: idea intelliJ 2017

## todo
- a simple page to show a ci, with id

## finish
- connect to sqlite by JDBC
- ci entity, repository
- author entity, repository
- test the repository by junit


cloud editor