##Maven distribution for Eclipse CDO

###Usage

You can build it yourself with following command inside the cdo-maven folder:

```
$ mvn clean install
```

You can now use choose which cdo dependencies you want to use in your maven project.

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.h2</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.mysql</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.postgresql</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.jvm</artifactId>
	<version>4.3.0</version>
	<type>pom</type>
</dependency>
```
