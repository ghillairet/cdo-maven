##Maven distribution for Eclipse CDO
===

###Usage

Clone this repository and run the following command inside the cdo-maven folder:

```
$ mvn clean install
```

You can now use the cdo dependencies from your maven project:

```
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.h2</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```
