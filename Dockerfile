FROM ubuntu:12.04

RUN apt-get update

# install wget
RUN apt-get install -y wget

# get maven 3.2.2
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

# verify checksum
#RUN echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c

#-------- install maven---------------------

RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.2.2 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven
#-----------------------------------



#----------Install Java---------------------------------------------
RUN apt-get update && apt-get install -y software-properties-common
RUN apt-get update && apt-get install -y python-software-properties
#RUN add-apt-repository ppa:openjdk-r/ppa
#RUN add-apt-repository ppa:webupd8team/java
#RUN apt-get update && apt-get install -y oracle-java8-installer
#RUN apt-get update && apt-get install -y openjdk-8-jdk

#ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
#RUN export JAVA_HOME

RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
RUN export JAVA_HOME
#---------------------------------------------------------------------



#----------install XVFB-------------------------
RUN apt-get update && apt-get  install -y xvfb x11vnc x11-xkb-utils xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic x11-apps
RUN xvfb :1 -screen 0 640x480x24 -fbdir /var/tmp&
RUN export DISPLAY=localhost:1.0
#-----------------------------------------------

#--------install git-----------------------
RUN apt-get update && apt-get install -y git
#-------------------------------------------

RUN apt-get update && apt-get install -y libstartup-notification0 

#-------install firefox 22---------------
RUN  apt-get purge -y firefox
RUN apt-get update && apt-get install -y x11vnc xvfb firefox=48.0+build2-0ubuntu0.12.04.1
RUN mkdir ~/.vnc
RUN x11vnc -storepasswd 1234 ~/.vnc/passwd
RUN apt-get update && apt-get install xvfb


#RUN  wget -O firefox_22.0+build2-0ubuntu0.12.04.2_amd64.deb https://launchpad.net/~ubuntu-mozilla-security/+archive/ubuntu/ppa/+build/4751637/+files/firefox_22.0%2Bbuild2-0ubuntu0.12.04.2_amd64.deb
#RUN  dpkg -i firefox_22.0+build2-0ubuntu0.12.04.2_amd64.deb

#RUN wget -O firefox_22.0+build2-0ubuntu0.12.04.2_i386.deb https://launchpad.net/~ubuntu-mozilla-security/+archive/ubuntu/ppa/+build/4751640/+files/firefox_22.0%2Bbuild2-0ubuntu0.12.04.2_i386.deb
#RUN dpkg -i firefox_22.0+build2-0ubuntu0.12.04.2_i386.deb
#RUN  apt-mark unhold firefox

#RUN wget -O /tmp/firefox45.tar.bz2  https://ftp.mozilla.org/pub/firefox/releases/45.0/linux-x86_64/en-US/firefox-45.0.tar.bz2
#RUN ls
#RUN cd /tmp && ls
#RUN tar -xvjf firefox45.tar.bz2
#RUN rm -rf  /opt/firefox
#RUN mv firefox /opt/firefox45
#RUN mv /usr/bin/firefox /usr/bin/firefoxold
#RUN ln -s /opt/firefox45/firefox /usr/bin/firefox

#RUN apt-get -qqy purge firefox

#RUN add-apt-repository ppa:ubuntu-mozilla-daily/ppa
#RUN apt-get update && install firefox /opt/


RUN apt-cache show firefox | grep Version 
#-----------------------------------------

WORKDIR /app

RUN git clone https://github.com/igor7301/TestNGMultithread.git /app

RUN firefox -version
RUN git pull  https://github.com/igor7301/TestNGMultithread.git


#RUN bash -c 'echo "firefox" >> /.bashrc'

#RUN xvfb-run --auto-servernum --server-num=0 nohup java - jar X.jar
CMD DISPLAY=:99 xvfb-run -a -n 1 -l -s "-screen 0, 1024x768x8" mvn test -Dspring.profiles.active=web
