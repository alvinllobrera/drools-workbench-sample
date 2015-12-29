drools-demo
=============================

This is a simple demo application implementing Drools rule engine via Drools workbench as web service in Spring.


###Running the Application###

```bash
mvn clean install
```

The project should compile successfully. Take note that the project contains two project modules:
1. drools-workbench-commons - app library for the facts needed in Drools.
2. drools-workbench-ws - the web service app integrating into the Drools workbench

####Setup Drools workbench####

1. Install an application server 
[Wildfly](https://docs.jboss.org/author/display/WFLY8/Getting+Started+Guide), the latest version of JBoss is recommended since Drools is also from JBoss

2. [Setup Drools workbench](https://docs.jboss.org/drools/release/6.0.0.Final/drools-docs/html/wb.Workbench.html)
After the setup, upload the jar generated from drools-workbench-commons.
Then, create a project containing your rule. You may check the sample_course_adviser_rule.drl as reference.
Build and deploy the newly created project and take note of its artifact information.



#####Build the web service app####

```bash
cd drools-workbench-ws
```

Replace the values in drools-workbench-ws/src/main/webapp/configs/drools-workbench.properties file with the 
appropriate information from your installed application server and created drools workbench project.

####Run the application####

```bash
#Rebuild the ws app to take effect the new config
mvn clean install

#Run the web service app
mvn tomcat:run
```

To send request to the app, you may use the curl command in your terminal or your favorite REST client.

For example when sending POST request in [http://localhost:8080/drools-workbench-ws/courseadvisor/suggest-course/]()
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
