# Maven distribution for Eclipse CDO

This repository contains the maven files necessary to build and release Eclipse [CDO](http://wiki.eclipse.org/CDO) onto maven central or
to simply build it on your machine.

You can find the builds on maven central [here](http://search.maven.org/#search|ga|1|g%3A%22org.eclipselabs%22%20AND%20%28a%3Acdo.*%20OR%20a%3Anet4j.*%29).

## Usage

You can now use choose which cdo dependencies you want to use in your maven project. You can look at an example setup using the embedded repository in the [tests project](https://github.com/ghillairet/cdo-maven/tree/master/cdo-tests).

### CDO

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

### Net4J

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

### DB Stores

H2

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.h2</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

MySQL

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.mysql</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

PostgreSQL

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.postgresql</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

Oracle

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.oracle</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

### CDO Hibernate

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo.hibernate</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

### CDO MongoDB

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo.mongodb</artifactId>
	<version>4.7.1</version>
	<type>pom</type>
</dependency>
```

## Build steps

### Versioning

When building you should first make sure that the pom and manifest versions are compatible.

When pom versions end with `-SNAPSHOT`, `Bundle-Version` in al MANIFEST.MF files should end with `.qualifier`.
When pom versions don't have `-SNAPSHOT`, remove `.qualifier` in MANIFEST files.

### Building

You can build it yourself with following command inside the cdo-maven folder:

```
$ mvn clean install
```

### Releasing

> Only for contributors.

Before releasing on maven central, make sure that pom versions end with `-SNAPSHOT` and
MANIFEST versions <i>do not end</i> with `.qualifier`, but have the correct release version number.

To release on maven central.

```
mvn release:clean release:prepare
```

follow by

```
mvn release:perform
```
