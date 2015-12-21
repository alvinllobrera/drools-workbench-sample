drools-demo
=============================

This is a simple demo application for integrating Drools rule engine as web service in Spring.

###Quick Start###

```bash
#Build the application
mvn clean install

#Run the application
mvn tomcat:run
```

To send request to the app, you may use the curl command in your terminal or your favorite REST client.

For example when sending POST request in [http://localhost:8080/drools-sample/courseadvisor/suggest-course/]()
with JSON body: 
```
[
  {"subjectCode":"MATH", "rating":8},
  {"subjectCode":"ECONOMICS", "rating":8}
]
```
that will return the following result:
```
{"suggestedCourses":[{"code":"BSA","description":"BS in Accountancy"}]}
```

Additionally, this request:
```
[
  {"subjectCode":"MATH", "rating":8},
  {"subjectCode":"COMPUTER", "rating":7}
]
```
will return the following response:
```
{"suggestedCourses":[{"code":"BSCS","description":"BS in Computer Science"}]}
```
