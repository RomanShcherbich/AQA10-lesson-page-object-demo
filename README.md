# Page object practice. Saucedemo lab.

Description

Education projects to demonstrate maven feature for automated testing.

Note:

Use the following cmd command to run test suite Groups.xml
```shell
mvn clean test -DtestNgSuiteFileName=Groups -DtestProp=MAVEN_TEST test
```

### Checklist

| Name | Test | Result |
| --- | --- | --- |
| Login form | valid login | Success |
| Catalog | add product to cart | Success |
| Cart | remove product  | Success |