##Maven distribution for Eclipse CDO

###Usage

You can build it yourself with following command inside the cdo-maven folder:

```
$ mvn clean install
```

You can now use the cdo dependencies from your maven project:

```xml
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>cdo</artifactId>
	<version>4.3.0-SNAPSHOT</version>
	<type>pom</type>
</dependency>
<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>net4j.h2</artifactId>
	<version>4.3.0-SNAPSHOT</version>
	<type>pom</type>
</dependency>
```

Builds are published to maven snapshot repository. To download them, add this to your pom.xml file or settings.xml file.

```xml
<repositories>
	<repository>
		<id>Maven Snapshots</id>
		<url>https://oss.sonatype.org/content/repositories/snapshots</url>
	</repository>
</repositories>
```
