# java-springboot-app

 

Required Tools
1.	AWS
2.	TERRAFORM
3.	ANSIBLE
4.	JENKINS
5.	SONARQUBE
6.	JFROG
7.	DOCKER
8.	KUBERNETES(EKS)
9.	HELM


1.	AWS:
Amazon Web Services (AWS) is a comprehensive cloud computing platform offered by Amazon.com. Launched in 2006, AWS provides a vast array of scalable and reliable services, including computing power, storage, and databases, along with tools for machine learning, analytics, and IoT. 
It has become a leading choice for businesses and developers to build, deploy, and manage applications in the cloud, offering flexibility, cost-effectiveness, and global reach. AWS plays a crucial role in powering a wide range of online services and applications across various industries.

2.	TERRAFORM:
Terraform is an open-source infrastructure as code (IaC) tool developed by HashiCorp. It enables users to define and provision infrastructure resources in a declarative configuration language. 
With Terraform, you can manage and automate the deployment of infrastructure across various cloud providers, as well as on-premises environments. Its modular and version-controlled approach allows for efficient collaboration and reproducibility in infrastructure deployments. 
Terraform has gained widespread adoption for its ability to create, update, and manage infrastructure in a consistent and scalable manner, making it a valuable tool for DevOps practices.

	TERRAFORM VARIABLE:
In Terraform, variables serve as placeholders for values that can be customized to suit different environments or configurations. 
They enhance flexibility by allowing users to parameterize their infrastructure code. Terraform variables can be defined within configuration files or external files, and their values can be assigned during runtime, enabling easy reuse and maintainability of code. 
This feature is particularly useful for managing configurations across multiple deployments or environments by providing a centralized way to modify settings without altering the core infrastructure code.

	TERRAFORM STATE FILE:
Terraform must store the state of your managed infrastructure and configuration. Terraform uses this state to map real-world resources to your configuration, track information, and boost efficiency for huge infrastructures. This state is stored by default in a local file named “terraform.tfstate”.
Terraform uses the state to decide which infrastructure changes to make. Terraform does a refresh before any operation to update the state with the actual infrastructure. 
Bindings between resources declared in your configuration and objects in a remote system are mostly stored in the Terraform state. 
When Terraform generates a remote object in reaction to a configuration change, it records the identification of that remote object against a specific resource instance. Later, in response to subsequent configuration changes, terraform may update or delete that object.

	TERRAFORM MODULE:
In Terraform,  Modules are groups of .tf files that are kept in a different directory from the configuration as a whole. A module’s scope encompasses all of its resources. So, if the user needs information about the resources that a module creates, the module must be explicitly stated. To do this, declare an output on the module that exposes the necessary data and permits references to that output from outside the module.
A typical module would resemble this:
. 
├── LICENSE 
├── README.md 
├── main.tf 
├── variables.tf 
├── outputs.tf



Types of Terraform Modules:
With Terraform, you are most likely to come across one of three main categories of modules:
1.	Root Module
2.	Child Module
3.	Published Modules








Modules – Local and Remote
Both local and distant sources can be used to load modules. The majority of version control systems, HTTP URLs, the Terraform Registry, and private module registries in Terraform Cloud or Terraform Enterprise are just a few of the external sources that Terraform supports.
What does a module do?
By building logical abstraction on top of a resource set, you may use  modules in terraform. To put it another way, a module enables the grouping of resources for subsequent reuse—possibly repeatedly.
Assume we have a cloud-hosted virtual server with various functionalities. Which group of resources would best sum up that server? For instance:
A virtual machine built from a picture
A block device with a connected storage space that is a specific size.
A public static IP address that is assigned to the server’s virtual network interface
A set of firewall guidelines that should be attached to the server
Other factors, such as an extra network interface or block device.
Let’s now imagine that you will frequently need to establish this server with a certain set of resources. You don’t want to keep repeating the same setup code, do you? That’s where modules come in incredibly handy.

Why Modules?
•	Organise Configuration: Easier to navigate, understand, and update your configuration
•	Encapsulate Configuration: Helps prevent unintended consequences
•	Re-use Configuration: Share modules that you have written with your team or the general public
•	Consistency: help to provide consistency in your configurations

Module: Input
•	Serve as parameters for a module in terraform
•	Input variables are the API of the Modules
•	For variables in child modules, the calling module should pass values in the module block.
•	Each input variable accepted by a child module must be declared using a variable block
•	the variable declaration can also include a default argument
      resource "aws_instance" "appserver" { 
    ami = var.ami
    instance_type = "t2.medium"
    tags = { 
        name = "${var.app_region}-app-server" 
    }
}
module "primaryapp" { 
    source = "./modules/appstorage"
    app_region = "us-east-2"
    ami = "ami-0010d386b82bc06f0"
}

Module: Output
•	The module can also return values
•	access module output variables using the module. <MODULE_NAME>.<OUTPUT_NAME>
•	Description argument is used to inform the module user what is contained in the output
•	value argument takes an expression whose result is to be returned to the user
output "subnetid" {
    value = "aws_instnace.appserver.subnet_id"
}
3.	Module best practices
1.	Modules in terraform offer many of the same advantages as the notions of libraries, packages, or modules present in most programming languages. Real-world Terraform setups should nearly always employ modules to give the aforementioned advantages, much like practically any non-trivial computer application.
2.	We advise that all Terraform practitioners employ modules while adhering to the following best practices:
3.	Your provider should be named Terraform-<PROVIDER>-<NAME>. This protocol must be followed in order to publish to the Terraform Cloud or Terraform Enterprise module registries.
4.	Start by considering modules as you write your setup. You’ll discover that the advantages of utilizing modules outweigh the effort required to utilize them effectively, even for somewhat complicated Terraform settings handled by a single person.
5.	To structure and contain your code, employ local modules. Even if you don’t use or publish remote modules, structuring your configuration in terms of modules from the start will significantly lessen the work required to maintain and update your configuration as your infrastructure becomes more complex.\
6.	To locate relevant modules, utilize the Terraform Registry. By using the efforts of others to construct typical infrastructure scenarios, you may implement your setup more quickly and confidently.
7.	Modules may be shared and published with your team. The majority of infrastructure is maintained by teams, and modules are a crucial tool for teams to collaborate while building and maintaining infrastructure. You have the option to publish modules privately or openly, as was already described.

4.	ANSIBLE:
Ansible is a software tool that provides simple but powerful automation for cross-platform computer support. It is primarily intended for IT professionals, who use it for application deployment, updates on workstations and servers, cloud provisioning, configuration management, intra-service orchestration, and nearly anything a systems administrator does on a weekly or daily basis. Ansible doesn't depend on agent software and has no additional security infrastructure, so it's easy to deploy.
Because Ansible is all about automation, it requires instructions to accomplish each job. With everything written down in simple script form, it's easy to do version control. The practical result of this is a major contribution to the "infrastructure as code" movement in IT: the idea that the maintenance of server and client infrastructure can and should be treated the same as software development, with repositories of self-documenting, proven, and executable solutions capable of running an organization regardless of staff changes.
While Ansible may be at the forefront of automation, systems administration, and DevOps, it's also useful to everyday users. Ansible allows you to configure not just one computer, but potentially a whole network of computers at once, and using it requires no programming skills. Instructions written for Ansible are human-readable. Whether you're entirely new to computers or an expert, Ansible files are easy to understand.

5.	JENKINS:
Jenkins is an open-source automation server widely used for continuous integration and continuous delivery (CI/CD) processes. Developed in Java, Jenkins facilitates the automation of building, testing, and deploying software projects. 
It supports the integration of various plugins, enabling seamless connections with different tools and technologies. 
Jenkins allows developers to set up pipelines, automate repetitive tasks, and promote collaboration in software development by providing a centralized and customizable platform for managing and monitoring the entire software delivery lifecycle. Its extensibility and robust community support make Jenkins a popular choice for automating and streamlining the software development process.

6.	SONARQUBE:
SonarQube is a code quality assurance tool that performs in-depth code analysis and generates an analysis report to ensure code reliability. SonarQube combines static and dynamic code analysis to empower continuous code quality practices. 
SonarQube was founded in 2007, initially under the name Sonar, with the driving philosophy that “continuous inspection must become mainstream as continuous integration.”  
The SonarQube server processes more than one programming language. As applications advance, code complexity increases. As a result, many applications are built with multiple languages. 
The SonarQube server can test and analyze 29 popular programming languages, from Python and PHP to Kotlin and Swift. 
With SonarQube, your developers can ensure source code quality and application security by identifying and rectifying code duplications and potential bugs. Take a closer look at how the Sonar scanner ensures code reliability, detects bugs, and alerts developers to other source code issues.

	USES OF SONARQUBE
Here are some common use cases and features of SonarQube:
1.	Code Quality Analysis: SonarQube analyzes your codebase to identify and highlight areas that may need improvement in terms of maintainability, reliability, and efficiency.
2.	Code Smells Detection: It identifies code smells, which are indicators of potential issues in the code that might lead to bugs or other problems.
3.	Bug Detection: SonarQube detects and reports bugs in the code, helping developers address issues early in the development process.
4.	Security Vulnerabilities Detection: It includes security analysis rules to identify potential security vulnerabilities in the code, such as SQL injection, cross-site scripting, and more.
5.	Code Duplication Detection: SonarQube can identify and highlight duplicated code, helping developers maintain a cleaner and more maintainable codebase.
6.	Integration with CI/CD: It can be integrated into continuous integration and continuous delivery (CI/CD) pipelines, providing feedback on code quality at each stage of the development process.
7.	Customizable Rules: SonarQube allows you to customize rules and quality profiles based on your project's specific coding standards and requirements.
8.	Dashboard and Reporting: Provides a web-based dashboard with comprehensive reports, making it easy to track code quality metrics over time.
9.	Support for Multiple Languages: SonarQube supports a variety of programming languages, including Java, C#, JavaScript, Python, and many others.
10.	Community and Plugin Ecosystem: Being open-source, SonarQube has an active community and supports a wide range of plugins, allowing you to extend its functionality based on your needs.
To use SonarQube, you typically integrate it into your development workflow, run analyses on your codebase, and leverage the feedback provided to improve the overall quality of your software.

7.	JGROG:
JFrog is a leading DevOps technology company that provides solutions for managing and optimizing the end-to-end software release cycle. 
Renowned for its Artifactory binary repository manager, JFrog facilitates efficient and secure artifact management, supporting various package formats across diverse technologies. 
JFrog's platform empowers developers with tools for artifact version control, distribution, and automation, enhancing collaboration within modern DevOps environments. By streamlining software releases, JFrog contributes to accelerating development cycles and ensuring the reliability and scalability of software delivery pipelines.

8.	DOCKER:
Docker is an open source software platform used to create, deploy and manage virtualized application containers on a common operating system (OS), with an ecosystem of allied tools. 
Docker container technology debuted in 2013. At that time, Docker Inc. was formed to support a commercial edition of container management software and be the principal sponsor of an open source version. Mirantis acquired the Docker Enterprise business in November 2019.
Docker gives software developers a faster and more efficient way to build and test containerized portions of an overall software application. This lets developers in a team concurrently build multiple pieces of software. 
Each container contains all elements needed to build a software component and ensure it's built, tested and deployed smoothly. Docker enables portability for when these packaged containers are moved to different servers or environments.

How Docker works
Docker packages, provisions and runs containers. Container technology is available through the operating system: A container packages the application service or function with all of the libraries, configuration files, dependencies and other necessary parts and parameters to operate. Each container shares the services of one underlying OS. 
Docker images contain all the dependencies needed to execute code inside a container, so containers that move between Docker environments with the same OS work with no changes.
Docker uses resource isolation in the OS kernel to run multiple containers on the same OS. This is different than virtual machines (VMs), which encapsulate an entire OS with executable code on top of an abstracted layer of physical hardware resources.

9.	KUBERNETES(EKS):
Amazon Elastic Kubernetes Service (EKS) is a managed Kubernetes service by AWS, simplifying the deployment, scaling, and operation of containerized applications using Kubernetes. 
EKS eliminates the need for manual cluster management, providing a secure, reliable, and scalable platform for running container workloads. 
It seamlessly integrates with other AWS services, streamlining application development and enhancing the overall Kubernetes experience.
(FOLLOW MY PREVIOUS DOCS FOR DETAI ABOUT KUBERNETES)

PROCEDURE TO PERFORM CICD PIPELINE:

First, we can write a terraform script to create vpc, subnet, route table,igw, sg, and 3 ec2-virtual machine (ansible-slave, jenkins-master, Jenkins-slave)
i, e.;

Install Terraform
•	Download Terraform
•	Create a folder and store downloaded terraform file
•	Set Environment Variable
o	Edit the system environment variable 
-> Environment variables
 -> system variable
 -> path
Install AWS CLI
•	Install AWS CLI
•	Open power shell as admin
msiexec.exe /i https://awscli.amazonaws.com/AWSCLIV2.msi
aws -version
•	Create IAM user with administrator access
•	Create IAM user (e.g. terraform-user)
•	Set permission
	Permission Options:
•	Attach Policies directly (AdministrativeAccess)
•	Go inside terraform-user
	Go to security credential
•	Access key
•	Click on Create Access Key
•	Choose Command line interface (CLI)
•	Tag value – terraform credential
•	Download .csv file [access key and secret key]

provider "aws" {
  region = "ap-southeast-1"
}

resource "aws_instance" "app-vm" {
  ami                    = "ami-0fa377108253bf620"
  instance_type          = "t2.micro"
  key_name               = "vm2-key"
  subnet_id              = aws_subnet.my-public-subnet-1.id
  vpc_security_group_ids = [aws_security_group.my-sg.id]  # Corrected to use a list

  for_each = toset(["ansible-server", "jenkins-master", "jenkins-slave"])
  tags = {
    Name = "${each.key}"
  }

}

resource "aws_vpc" "my-vpc" {
  cidr_block = "192.168.0.0/16"

  tags = {
    Name = "my-vpc"
  }
}

resource "aws_subnet" "my-public-subnet-1" {
  vpc_id                  = aws_vpc.my-vpc.id
  cidr_block              = "192.168.1.0/24"
  map_public_ip_on_launch = true
  availability_zone       = "ap-southeast-1a"

  tags = {
    Name = "my-public-subnet-1"
  }
}
resource "aws_security_group" "my-sg" {
  vpc_id = aws_vpc.my-vpc.id

  ingress {
    description = "ssh access"
    from_port    = 22
    to_port      = 22
    protocol     = "tcp"
    cidr_blocks  = ["0.0.0.0/0"]
  }

  ingress {
    description = "8080 access"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    description = "ssh access"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "my-sg"
  }
}

resource "aws_internet_gateway" "my-igw" {
  vpc_id = aws_vpc.my-vpc.id

  tags = {
    Name = "my-igw"
  }
}

resource "aws_route_table" "my-public-rtb" {
  vpc_id = aws_vpc.my-vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.my-igw.id
  }
}

resource "aws_route_table_association" "my-rta-public-subnet-1" {
  subnet_id      = aws_subnet.my-public-subnet-1.id
  route_table_id = aws_route_table.my-public-rtb.id
}

After writing the terraform script then initiate the terraform
terraform init
After initiate then validate
terraform validate
After validate the script then plan the the sript
terraform plan
After plan the script then apply the script
terraform apply
Copy public ip of ansible-server & go to mobaxterm access the ansible-sever vm and set up the ansible.
 Ansible setup
apt update
apt install software-properties-common
add-apt-repository --yes --update ppa:ansible/ansible
apt install ansible
ansible –version
After setup the ansible then create inventory file
•	Create hosts file inside /opt
[jenkinsmaster]
192.168.1.181
[jenkinsmaster:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=/opt/vm2-Key.pem

[jenkinsslave]
192.168.1.170
[jenkinsslave:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=/opt/vm2-Key.pem

After creating the hosts file the then go to your key.pem file and drag and drop into mobaxterm /home/ubuntu folder and this key.pem file copy to the /opt folder and give the permission to this key.pem file
Cp /home/ubuntu/key.pem /opt
Chmod 400 key.pem
Then ping this hosts file
ansible -i hosts all  -m ping
After ping we should write two ansible playbook script for installation of java, Jenkins, in Jenkins-master vm and java and maven in Jenkins-slave vm.
So, script is here
vi Jenkins-master-setup.yml
---
- hosts: jenkinsmaster
  become: true 
  tasks: 
  - name: add jenkins key 
    apt_key: 
      url:  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
      state: present 

  - name: add jenkins repo 
    apt_repository: 
      repo: 'deb https://pkg.jenkins.io/debian-stable binary/'
      state: present 

  - name: install java 
    apt: 
      name: openjdk-17-jre
      state: present

  - name: install jenkins 
    apt: 
      name: jenkins 
      state: present 

  - name: start jenkins service 
    service: 
      name: jenkins 
      state: started 

  - name: enable jenkins to start at boot time 
    service: 
      name: jenkins 
      enabled: yes 
...

For Jenkins master run this command
ansible-playbook -i hosts jenkins-master-setup.yml
vi Jenkins-slave-setup.yml
---
- hosts: jenkinsslave
  become: true 
  tasks: 
  - name: update ubuntu repo and cache 
    apt: 
      update_cache: yes 

  - name: install java 
    apt: 
      name: openjdk-8-jre
      state: present

  - name: download maven packages 
    get_url:
      url: https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
      dest: /opt

  - name: extract maven packages 
    unarchive:
      src: /opt/apache-maven-3.9.6-bin.tar.gz
      dest: /opt 
      remote_src: yes

For Jenkins slave run this command
ansible-playbook -i hosts jenkins-slave-setup.yml
After installation we check the version of java, maven
Jenkins-master
 
Jenkins-salve
 
 
After installation java, Jenkins, maven then we are going to Jenkins-master vm copy the public ip then go to browser accsess the Jenkins and 
Add Jenkins Slave to Jenkins Master
Go to Jes copy the path then go to Jenkins-master 
cat /var/lib/jenkins/secrets/initialAdminPassword
 
After enter into the Jenkins go to admin and change the password
Jenkinsadminconfigchange passwd
 
Go to Jenkins and add credential and node
Jenkinsmanage JenkinscredentialSystemglobal credentialadd credential
Add Credentials
Provide the below info to add credentials
kind: ssh username with private key
Scope: Global
ID: jenkins_slave_cred
Username: ubuntu
private key: content of Project_Key.pem key

 
Add Node
Jenkinsmanage Jenkinstoolsadd tools
•	Node Name: Jenkins-Slave-Node
•	Type: Permanent Agent
•	Description: build java-based project
•	Number of executors: 3
•	Remote root directory: /home/ubuntu/Jenkins
•	Labels: Jenkins-slave-node
•	Usage: Use this node as much as possible
•	Launch method: Launch agents via SSH
•	Host: <Private_IP_of_Jenkins_Slave>
•	Credentials: <Jenkins_Slave_Credentials>
•	Host Key Verification Strategy: Non verifying Verification Strategy
•	Availability: Keep this agent online as much as possible

 
After add credential and node then we create first job of this project
Create job
JenkinsCreate job












Build now
Create Jenkinsfile
pipeline {
    agent {
        node {
            label 'Jenkins-Slave-Node'
        }
    }
    environment {
        PATH = "/opt/maven/bin:$PATH"
    }
    stages {
        stage("Build Code") {
            steps {
                echo "Build started"
                script {
                    sh 'mvn clean deploy -Dmaven.test.skip=true'
                }
                echo "Build completed successfully"
            }
        }
    }
}

For auto triggered we can set github webhook
Githubreposettingwebhook












Code Analysis:
For code analysis we can use sonarqube
SonarQube Configuration
•	Create Sonar cloud account on https://sonarcloud.io
 
Go to SonarQube signup through GitHub
After signup then login into sonarqube account & create authentication token
•	Generate an Authentication token on SonarQube
	Account --> my account --> Security --> Generate Tokens
Add credential for sonarqube
Jenkinsmanage Jenkinscredentialadd credentialsystemglobal credential
- Credentials type: Secret text  
- Scope: Global
- Secret - <copy token from sonar cloud>
- ID: sonar-cred

 
Install SonarQube Scanner plugin
Jenkinsmanage JenkinspluginsAvailable pluginssnarqube scanner
 
Configure sonarqube server
JenkinsManage JenkinsSystemAdd sonarqube
 
Configure SonarQube scanner
JenkinsManage JenkinsToolsAdd sonarqube scanner
Name- Sonarqube-scanner-meportal









Create SonarQube Properties File
•	Create Organization in Sonar Cloud
SonarQubeMy Account -> Organization -> Create an Organization
 
Create project
Analyze new project
















sonar-project.properties
sonar.verbose=true
sonar.organization=meportal-org-key2
sonar.projectKey=meportal-sc-org-key_springbootapp-project
sonar.projectName=springbootapp-project
sonar.language=java
sonar.sourceEncoding=UTF-8
sonar.sources=.
sonar.java.binaries=target/classes
sonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml

After analysis sonarqube project then we create quality gate for this project
Create Quality Gate
Sonarqube accountMy projectProjectOrganisationQuality GateCreateAdd Condition
 

After set quality get run this script
stage("Quality Gate") {
            steps {
                script {
                    timeout(time: 1, unit: 'HOURS') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure:${qg.status}"
                        }
                    }
                }
            }
        }

    }
}


After SonarQube integration we are going to JFrog integration
JFrog Integration
Create JFrog Account
•	Go to https://jfrog.com/artifactory/
•	Click on Start Free
•	Login with Google Account

 


 













Login to jfrog
https://meportal.jfrog.io/ 
Generate Access Token
JfrogPlatform configurationAccess tokenGenerate token: eyJ2ZXIiOiIyIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYiLCJraWQiOiIzRjBCMEF0SXpzektmbTdJUkYwYV9qYkU1SUtHaUJ1ZWd1cjc5TmRCMFVZIn0.eyJzdWIiOiJqZmFjQDAxaG0wZnFwY3p0azJyMXZkOGFqc3gwbmI0L3VzZXJzL2Jsb2dodXNzYWluMjRAZ21haWwuY29tIiwic2NwIjoiYXBwbGllZC1wZXJtaXNzaW9ucy9hZG1pbiIsImF1ZCI6IipAKiIsImlzcyI6ImpmZmVAMDFobTBmcXBjenRrMnIxdmQ4YWpzeDBuYjQiLCJpYXQiOjE3MDUyNjI2NzMsImp0aSI6IjNhYjIyOTA4LWM1NTItNDgzNS04N2IzLWU3M2U4ZTUxZTM4MyJ9.IN25vIluSDfbmrSHuZZyN7UufKCjHUdZVwwI9CYY8LLyyKC_SHVw30SUVyF4UVvYJTXOFtqxV3i7cdh-BlisafZmTEWci1lvgLBvt-_XDEaOd49wNSjNtTEGl3mr2i8nqmpBcjW9VIV0eFhhoBu--Nnyr44fz72vcWUp9Q7t4CW6stjRIwk3UYQ5__b7CcissudMsZNJKGfiry5_MqIIpQRtn3lw4KPrgyQYnvQgSgUvs-jmaVMIKqMrKd_tajE7R8DAz8Ud4jwhDCTOjsSUQq65WJhwws8R52aWxVtzYyknw1_yhwtO7OkUJ_8FBUBeqLu8mCnNUKQ8vpz69jq4yw

























After creating token then go to jenkins set up jfrog credential
Jenkinsmanagejenkinscredentialsystem globaladd credential
Install Artifactory plugin
Jenkinsmanagepluginavailable plugin Artifactory pipeline-->Install 

Create Local Repository in JFrog








After creating repository in jfrog then run the Artifactory script in pipeline i. e.;
stage("Artifact Publish") {
            steps {
                script {
                    echo '------------- Artifact Publish Started ------------'
                    def server = Artifactory.newServer url:"https://hussains.jfrog.io//artifactory" ,  credentialsId:"Jfrog-credential"
                    def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}";
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "staging/(*)",
                                "target": "release-local-artifacts/{1}",
                                "flat": "false",
                                "props" : "${properties}",
                                "exclusions": [ "*.sha1", "*.md5"]
                            }
                        ]
                    }"""
                    def buildInfo = server.upload(uploadSpec)
                    buildInfo.env.collect()
                    server.publishBuildInfo(buildInfo)
                    echo '------------ Artifact Publish Ended -----------'  
                }
            }   
        }

    }
}

Docker Integration
For docker integration first we are going to install docker in Jenkins-slave vm 
Vi jenkins-slave-setup.yml
---
- hosts: jenkinsslave
  become: true 
  tasks: 
  - name: update ubuntu repo and cache 
    apt: 
      update_cache: yes 

  - name: install java 
    apt: 
      name: openjdk-17-jre
      state: present

  - name: download maven packages 
    get_url:
      url: https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
      dest: /opt

  - name: extract maven packages 
    unarchive:
      src: /opt/apache-maven-3.9.6-bin.tar.gz
      dest: /opt 
      remote_src: yes

  - name: install docker 
    apt: 
      name: docker.io 
      state: present

  - name: change file permissions
    file: 
      path: /var/run/docker.sock
      state: file 
      mode: 0777

  - name: start docker services 
    service: 
      name: docker 
      state: started 
      
  - name: start docker on boot time 
    service: 
      name: docker 
      enabled: yes 

check docker version:



Create Dockerfile
FROM ubuntu
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
WORKDIR /opt
COPY staging/com/meportal/springboot-app/1.0/springboot-app-1.0.war welcomeapp.war
CMD ["java", "-jar", "welcomeapp.war"]

For docker integration create a repository in jfrog
jfrogUser Menu Quick Repository Creation Select Docker Click on Nextrepo prefixcreate























URL: https://hussains.jfrog.io/artifactory/mymeportal-docker/
After creating repository then go to jenkins & install docker plugin
Jenkinsmanage jenkinspluginavailable plugindocker pipelineinstall

After install docker plugin then run docker pipeline script i. e.;
stage(" Create Docker Image ") {
            steps {
                script {
                    echo '-------------- Docker Build Started -------------'
                    app = docker.build("hussains.jfrog.io/mymeportal-docker-local/myapp:1.0.1")
                    echo '-------------- Docker Build Ended -------------'
                }
            }
        }

        stage (" Docker Publish "){
            steps {
                script {
                        echo '---------- Docker Publish Started --------'  
                        docker.withRegistry("https://hussains.jfrog.io", 'Jfrog-credential'){
                        app.push()
                        echo '------------ Docker Publish Ended ---------'  
                    }    
                }
            }
        }

    }
}

KUBERNETES INTEGRATION
After creation of docker image then goes for terraform integration. For terraform integration we should write terraform script i. e.;
1.	Create-EKS-cluster
•	Eks.tf
•	resource "aws_iam_role" "master" {
•	    name = "ed-eks-master"
•	  assume_role_policy = <<POLICY
•	{
•	  "Version": "2012-10-17",
•	  "Statement": [
•	    {
•	      "Effect": "Allow",
•	      "Principal": {
•	        "Service": "eks.amazonaws.com"
•	      },
•	      "Action": "sts:AssumeRole"
•	    }
•	  ]
•	}
•	POLICY
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEKSClusterPolicy" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
•	  role       = aws_iam_role.master.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEKSServicePolicy" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSServicePolicy"
•	  role       = aws_iam_role.master.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEKSVPCResourceController" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSVPCResourceController"
•	  role       = aws_iam_role.master.name
•	}
•	
•	resource "aws_iam_role" "worker" {
•	  name = "ed-eks-worker"
•	
•	  assume_role_policy = <<POLICY
•	{
•	  "Version": "2012-10-17",
•	  "Statement": [
•	    {
•	      "Effect": "Allow",
•	      "Principal": {
•	        "Service": "ec2.amazonaws.com"
•	      },
•	      "Action": "sts:AssumeRole"
•	    }
•	  ]
•	}
•	POLICY
•	}
•	
•	resource "aws_iam_policy" "autoscaler" {
•	  name   = "ed-eks-autoscaler-policy"
•	  policy = <<EOF
•	{
•	  "Version": "2012-10-17",
•	  "Statement": [
•	    {
•	      "Action": [
•	        "autoscaling:DescribeAutoScalingGroups",
•	        "autoscaling:DescribeAutoScalingInstances",
•	        "autoscaling:DescribeTags",
•	        "autoscaling:DescribeLaunchConfigurations",
•	        "autoscaling:SetDesiredCapacity",
•	        "autoscaling:TerminateInstanceInAutoScalingGroup",
•	        "ec2:DescribeLaunchTemplateVersions"
•	      ],
•	      "Effect": "Allow",
•	      "Resource": "*"
•	    }
•	  ]
•	}
•	EOF
•	
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEKSWorkerNodePolicy" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSWorkerNodePolicy"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEKS_CNI_Policy" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonSSMManagedInstanceCore" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonSSMManagedInstanceCore"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "AmazonEC2ContainerRegistryReadOnly" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "x-ray" {
•	  policy_arn = "arn:aws:iam::aws:policy/AWSXRayDaemonWriteAccess"
•	  role       = aws_iam_role.worker.name
•	}
•	resource "aws_iam_role_policy_attachment" "s3" {
•	  policy_arn = "arn:aws:iam::aws:policy/AmazonS3ReadOnlyAccess"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_role_policy_attachment" "autoscaler" {
•	  policy_arn = aws_iam_policy.autoscaler.arn
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_iam_instance_profile" "worker" {
•	  depends_on = [aws_iam_role.worker]
•	  name       = "ed-eks-worker-new-profile"
•	  role       = aws_iam_role.worker.name
•	}
•	
•	resource "aws_eks_cluster" "eks" {
•	  name = "my-cluster"
•	  role_arn = aws_iam_role.master.arn
•	
•	  vpc_config {
•	    subnet_ids = [var.subnet_ids[0],var.subnet_ids[1]]
•	  }
•	  
•	  depends_on = [
•	    aws_iam_role_policy_attachment.AmazonEKSClusterPolicy,
•	    aws_iam_role_policy_attachment.AmazonEKSServicePolicy,
•	    aws_iam_role_policy_attachment.AmazonEKSVPCResourceController,
•	    aws_iam_role_policy_attachment.AmazonEKSVPCResourceController,
•	  ]
•	
•	}
•	
•	resource "aws_eks_node_group" "backend" {
•	  cluster_name    = aws_eks_cluster.eks.name
•	  node_group_name = "dev"
•	  node_role_arn   = aws_iam_role.worker.arn
•	  subnet_ids = [var.subnet_ids[0],var.subnet_ids[1]]
•	  capacity_type = "ON_DEMAND"
•	  disk_size = "20"
•	  instance_types = ["t2.small"]
•	  remote_access {
•	    ec2_ssh_key = "Project_Key"
•	    source_security_group_ids = [var.sg_ids]
•	  } 
•	  
•	  labels =  tomap({env = "dev"})
•	  
•	  scaling_config {
•	    desired_size = 2
•	    max_size     = 3
•	    min_size     = 1
•	  }
•	
•	  update_config {
•	    max_unavailable = 1
•	  }
•	
•	  depends_on = [
•	    aws_iam_role_policy_attachment.AmazonEKSWorkerNodePolicy,
•	    aws_iam_role_policy_attachment.AmazonEKS_CNI_Policy,
•	    aws_iam_role_policy_attachment.AmazonEC2ContainerRegistryReadOnly,
•	  ]
•	}

•	Outpu.tf
•	output "endpoint" {
•	  value = aws_eks_cluster.eks.endpoint
•	}

•	Variable.tf
•	variable "sg_ids" {
•	type = string
•	}
•	
•	variable "subnet_ids" {
•	  type = list
•	}
•	
•	variable "vpc_id" {
•	   type = string
•	}

2.	Create-vpc
•	Create-vpc.tf
•	provider "aws" {
•	  region = "us-east-1"
•	}
•	
•	resource "aws_instance" "app-vm" {
•	    ami = "ami-0c7217cdde317cfec"
•	    instance_type = "t2.micro"
•	    key_name = "vm2-key"
•	
•	    subnet_id = aws_subnet.my-public-subnet-1.id 
•	    vpc_security_group_ids = [aws_security_group.my-sg1.id]
•	
•	    for_each = toset(["ansible-server", "jenkins-master", "jenkins-slave"])
•	  tags = {
•	    Name = "${each.key}"
•	  }
•	}
•	resource "aws_vpc" "my-vpc" { 
•	  cidr_block = "192.168.0.0/16"
•	  tags = {
•	    Name = "my-vpc"
•	  }
•	}
•	
•	resource "aws_subnet" "my-public-subnet-1" {
•	  vpc_id = aws_vpc.my-vpc.id
•	  cidr_block = "192.168.1.0/24"
•	  map_public_ip_on_launch = "true"
•	  availability_zone = "us-east-1a"
•	  tags = {
•	    Name = "my-public-subent-01"
•	  }
•	}
•	resource "aws_subnet" "my-public-subnet-2" {
•	  vpc_id = aws_vpc.my-vpc.id
•	  cidr_block = "192.168.1.0/24"
•	  map_public_ip_on_launch = "true"
•	  availability_zone = "us-east-1b"
•	  tags = {
•	    Name = "my-public-subent-01"
•	  }
•	}
•	
•	resource "aws_security_group" "my-sg1" {
•	  name        = "my-sg1"
•	  description = "SSH Access"
•	  vpc_id = aws_vpc.my-vpc.id 
•	  
•	  ingress {
•	    description      = "Shh access"
•	    from_port        = 22
•	    to_port          = 22
•	    protocol         = "tcp"
•	    cidr_blocks      = ["0.0.0.0/0"]
•	    }
•	    ingress {
•	    description      = "Shh access"
•	    from_port        = 8080
•	    to_port          = 8080
•	    protocol         = "tcp"
•	    cidr_blocks      = ["0.0.0.0/0"]
•	    }
•	
•	  egress {
•	    from_port        = 0
•	    to_port          = 0
•	    protocol         = "-1"
•	    cidr_blocks      = ["0.0.0.0/0"]
•	  }
•	
•	  tags = {
•	    Name = "ssh-prot"
•	  }
•	}
•	
•	resource "aws_internet_gateway" "my-igw" {
•	  vpc_id = aws_vpc.my-vpc.id 
•	  tags = {
•	    Name = "my-igw"
•	  } 
•	}
•	
•	resource "aws_route_table" "my-public-rt" {
•	  vpc_id = aws_vpc.my-vpc.id 
•	  route {
•	    cidr_block = "0.0.0.0/0"
•	    gateway_id = aws_internet_gateway.my-igw.id 
•	  }
•	}
•	
•	resource "aws_route_table_association" "my-rta-public-subnet-1" {
•	  subnet_id = aws_subnet.my-public-subnet-1.id
•	  route_table_id = aws_route_table.my-public-rt.id   
•	}
•	resource "aws_route_table_association" "my-rta-public-subnet-2" {
•	  subnet_id = aws_subnet.my-public-subnet-1.id
•	  route_table_id = aws_route_table.my-public-rt.id   
•	}
•	
•	 /*module "sgs" {
•	    source = "../sg-eks"
•	    vpc_id     =     aws_vpc.my-vpc.id
•	 }
•	
•	  module "eks" {
•	       source = "../create-eks-cluster"
•	       vpc_id     =     aws_vpc.my-vpc.id
•	       subnet_ids = [aws_subnet.my-public-subnet-1.id,aws_subnet.my-public-subnet-2.id]
•	       sg_ids = module.sgs.security_group_public
•	 }*/
•	

3.	Create-Sg
•	Sg.tf
•	resource "aws_security_group" "worker_node_sg" {
•	  name        = "eks-test"
•	  description = "Allow ssh inbound traffic"
•	  vpc_id      =  var.vpc_id
•	
•	  ingress {
•	    description      = "ssh access to public"
•	    from_port        = 22
•	    to_port          = 22
•	    protocol         = "tcp"
•	    cidr_blocks      = ["0.0.0.0/0"]
•	  }
•	
•	  egress {
•	    from_port        = 0
•	    to_port          = 0
•	    protocol         = "-1"
•	    cidr_blocks      = ["0.0.0.0/0"]
•	  }
•	
•	}

•	Outpu.tf
output "security_group_public" {
   value = "${aws_security_group.worker_node_sg.id}"
}

•	Variable.tf
•	variable "vpc_id" {
•	   type = string
•	}

Procedure to apply terraform
1st go to create-vpc folder & 
cut the Create-vpc.tf file and paste outside of your folder 
 go to your previous folder where you create ec2-env here copy all the content and paste it in Create-vpc folder 
Here add on create.tf file one extra subnet (my-public-subnet-2) & add one extra route-table-assciation (my-rta-public-subnet-2)
Go to Eks.tf file then replce key with your actual key
Run the initiate command i. e.; terraform init
Run terraform validate command i. e.; terraform validate
Run terraform plan command i. e.; terraform plan
Run terraform apply command I. e.; terraform apply
Before apply this command make sure your previous three instances are in running mode
Integrate Jenkins Slave with Kubernetes cluster
All commands run on Jenkins slave server

Install kubectl on Jenkins Slave
curl -LO https://dl.k8s.io/release/v1.29.0/bin/linux/amd64/kubectl
chmod +x ./kubectl
mv ./kubectl /usr/local/bin
kubectl version
Install AWS CLI
apt remove awscli 
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
apt install unzip
unzip awscliv2.zip
sudo ./aws/install --update
aws --version
Configure awscli to connect with aws account [with ubuntu user]
aws configure
access_key: ...
secret_key: ...
region: ...
format: ...
Download Kubernetes credentials and cluster configuration [with ubuntu user]
aws eks list-clusters
aws eks update-kubeconfig --region us-east-1 --name my-cluster
kubectl get nodes








Create Kubernetes Spec Files
namespace.yml
apiVersion: v1
kind: Namespace
metadata:
  name: meportal

secretspec.yml
apiVersion: v1
kind: Secret
metadata:
  name: jfrogcred
  namespace: meportal
data:
  .dockerconfigjson: 
ewoJImF1dGhzIjogewoJCSJtZXBvcnRhbC5qZnJvZy5pbyI6IHsKCQkJImF1dGgiOiAiWW1Ga1lXeHdZWFJsYkRrME9UQkFaMjFoYVd3dVkyOXRPa0ZrYldsdUl6RXlNdz09IgoJCX0KCX0KfQ==
type: kubernetes.io/dockerconfigjson

deployspec.yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: meportal-deploy
  namespace: meportal
spec:
  replicas: 2
  selector:
    matchLabels:
      app:  meportal-deploy
  template:
    metadata:
      labels:
        app:  meportal-deploy
    spec:
      imagePullSecrets:
      - name: jfrogcred
      containers:
      - name:  meportal-deploy
        image: meportal.jfrog.io/meportal-docker-local/myapp:1.0
        imagePullPolicy: Always
        ports:
        - containerPort: 8080

servicespec.yml
apiVersion: v1
kind: Service
metadata:
  name:  meportal-service
  namespace: meportal
spec:
  type: NodePort
  selector:
    app: meportal-deploy
  ports:
  - nodePort: 30082
    port: 8080
    targetPort: 8080

deploy.sh
#!/bin/sh
kubectl apply -f namespace.yml
kubectl apply -f secretspec.yml
kubectl apply -f deployspec.yml
kubectl apply -f servicespec.yml

After creating the Kubernetes spes file then give permission to deploy.sh file for run the Kubernetes commands.
chmod +x deploy.sh
Before run these commands first we are going to integrate jfrog with Kubernetes.
Integrate JFrog with Kubernetes cluster
Login to jfrog account through google account
Create user to use for docker login
Go to user management select new user
Give user name= jfrog-cred
Give email id= abc@gmail.com
Give role= Administrator Ploatform
Give password=fdrhhi1233











After giving this information then login in the Jenkins-slave vm
docker login https://meportal.jfrog.io
           username: abd@gmail.com
password: 

genarate encode value for ~/.docker/config.json file
cat ~/.docker/config.json | base64 -w0

Here we find
data:
  .dockerconfigjson: ewoJImF1dGhzIjogewoJCSJodXNzYWlucy5qZnJvZy5pbyI6IHsKCQkJImF1dGgiOiAiYW1aeWIyZGtiMk5yWlhKamNtVmtPa2gxYzNOaGFXNHhNak09IgoJCX0KCX0KfQ==

After paste this in secrectspec.yml then for testing purpose drag the kube-spec folder into moaxter /home/ubuntu path then give the permission to deploy.sh file I. e.;
chmod u+x deploy.sh
After giving permission then apply it
./deploy.sh
After applying this command the going to run another command to find the right port i. e.;
kubectl get all -n meportal
Then copy Nodeport port & goes to ec2 instance copy the public ip of any of worker node paste it in browser with NodePort port i. e.;
34.205.37.30:30082 & get the output
After testing we going to prepare Jenkins pipeline script i. e.;
Add Deploy Stage to Jenkins file
pipeline {
       agent {
        node {
            label 'jenkins-slave-node'
        }
    }
 
    
    environment {
        PATH = "/opt/apache-maven-3.9.6/bin:$PATH"
    }
    stages {
        stage("Build Stage"){
            steps {
                echo "----------- build started ----------"
                sh 'mvn clean deploy -Dmaven.test.skip=true'
                echo "----------- build completed ----------"
            }
        }
        /* 
        stage("Test Stage"){
            steps{
                echo "----------- unit test started ----------"
                sh 'mvn surefire-report:report'
                echo "----------- unit test Completed ----------"
            }
        }
        
        stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'sonar-scanner-meportal'
            }
            steps{
                withSonarQubeEnv('sonar-server-meportal') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }

        stage("Quality Gate"){
            steps {
                script {
                    timeout(time: 1, unit: 'HOURS') { 
                        def qg = waitForQualityGate() 
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }
        */
        stage("Artifact Publish") {
            steps {
                script {
                    echo '------------- Artifact Publish Started ------------'
                    def server = Artifactory.newServer url:"https://meportal.jfrog.io/artifactory" ,  credentialsId:"jfrog-cred"
                    def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}";
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "staging/(*)",
                                "target": "libs-release-local/{1}",
                                "flat": "false",
                                "props" : "${properties}",
                                "exclusions": [ "*.sha1", "*.md5"]
                            }
                        ]
                    }"""
                    def buildInfo = server.upload(uploadSpec)
                    buildInfo.env.collect()
                    server.publishBuildInfo(buildInfo)
                    echo '------------ Artifact Publish Ended -----------'  
                }
            }   
        }

        stage(" Create Docker Image ") {
            steps {
                script {
                    echo '-------------- Docker Build Started -------------'
                    app = docker.build("meportal.jfrog.io/meportal-docker-local/myapp:1.0")
                    echo '-------------- Docker Build Ended -------------'
                }
            }
        }

        stage (" Docker Publish "){
            steps {
                script {
                        echo '---------- Docker Publish Started --------'  
                        docker.withRegistry("https://meportal.jfrog.io", 'jfrog-cred'){
                        app.push()
                        echo '------------ Docker Publish Ended ---------'  
                    }    
                }
            }
        }

        stage ("Deploy Stage"){
            steps {
                script {
                        sh './deploy.sh'
                    }    
                }
            }
        }

    }
}


Before push this code into github first we give permission through git bash i.e.;
git add --chmod=+x deploy.sh
At time of deploy stage one error occurred i. e.;
permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Post "http://%2Fvar%2Frun%2Fdocker.sock/v1.24/build?buildargs=%7B%7D&cachefrom=%5B%5D&cgroupparent=&cpuperiod=0&cpuquota=0&cpusetcpus=&cpusetmems=&cpushares=0&dockerfile=Dockerfile&labels=%7B%7D&memory=0&memswap=0&networkmode=default&rm=1&shmsize=0&t=hussains.jfrog.io%2Fmymeportal-docker-local%2Fmyapp%3A1.0.1&target=&ulimits=null&version=1": dial unix /var/run/docker.sock: connect: permission denied

 
To resolve this error you should run this command i. e.;
sudo chmod 666 /var/run/docker.sock
