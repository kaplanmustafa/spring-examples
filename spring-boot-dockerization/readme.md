### dockerfile

FROM <br>
The base image for building a new image. This command must be on top of the dockerfile.
MAINTAINER <br>
Optional, it contains the name of the maintainer of the image.
RUN <br>
Used to execute a command during the build process of the docker image.
ADD <br>
Copy a file from the host machine to the new docker image. There is an option to use a URL for the file, docker will
then download that file to the destination directory.
ENV <br>
Define an environment variable.
CMD <br>
Used for executing commands when we build a new container from the docker image.
ENTRYPOINT <br>
Define the default command that will be executed when the container is running.
WORKDIR <br>
This is directive for CMD command to be executed.
USER <br>
Set the user or UID for the container created with the image.
VOLUME <br>
Enable access/linked directory between the container and the host machine.
Now let's start to create our first dockerfile.

FROM java:8-jdk-alpine<br>
COPY ./target/app.jar /usr/app/<br>
WORKDIR /usr/app<br>
RUN sh -c 'touch app.jar'<br>
ENTRYPOINT ["java","-jar”,”app.jar"]

#### maven plugin

<plugin>
    <groupId>io.fabric8</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>0.26.0</version>
    <extensions>true</extensions>
    <configuration>
        <verbose>true</verbose>
        <images>
            <image>
                <name>${project.artifactId}</name>
                <build>
                    <from>java:8-jdk-alpine</from>
                    <entryPoint>
                        <exec>
                            <args>java</args>
                            <args>-jar</args>
                            <args>/maven/${project.artifactId}-${project.version}.jar</args>
                        </exec>
                    </entryPoint>
                    <assembly>
                        <descriptorRef>artifact</descriptorRef>
                    </assembly>
                </build>
            </image>
        </images>
    </configuration>
    <executions>
        <execution>
            <id>build</id>
            <phase>post-integration-test</phase>
            <goals>
                <goal>build</goal>
            </goals>
        </execution>
    </executions>
</plugin>


