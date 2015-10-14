# Maven distribution for Eclipse CDO

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

## Usage

You can now use choose which cdo dependencies you want to use in your maven project.

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo</artifactId>
	<version>4.4.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.h2</artifactId>
	<version>4.4.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.mysql</artifactId>
	<version>4.4.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.postgresql</artifactId>
	<version>4.4.0</version>
	<type>pom</type>
</dependency>
```

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.jvm</artifactId>
	<version>4.4.0</version>
	<type>pom</type>
</dependency>
```
