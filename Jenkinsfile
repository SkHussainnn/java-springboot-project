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
                echo "Build completed"
            }
        }

        stage("Test Stage") {
            steps {
                echo "----------- Unit Test Started ----------"
                script {
                    sh 'mvn surefire-report:report'
                }
                echo "----------- Unit Test Completed ----------"
            }
        }

        /*stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'sonar-scanner-meportal'
            }
            steps {
                script {
                    withSonarQubeEnv('sonar-server-meportal') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }

        stage("Quality Gate") {
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
        }*/
        
        stage("Artifact Publish") {
            steps {
                script {
                    echo '------------ Artifact Publish Started -----------'
                    def server = Artifactory.newServer url:"https://avdmeportal.jfrog.io//artifactory" ,  credentialsId:"jfrog-cred"
                    def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}";
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "staging/(*)",
                                "target": "release-local-artifacts1/{1}",
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


        stage("Create Docker Image") {
            steps {
                script {
                    echo '-------------- Docker Build Started -------------'
                    app = docker.build("avdmeportal.jfrog.io/docker-meportal-docker-local/myapp:1.0")
                    echo '-------------- Docker Build Ended -------------'
                }
            }
        }

        stage("Docker Publish") {
            steps {
                script {
                    echo '---------- Docker Publish Started --------'  
                    docker.withRegistry("https://avdmeportal.jfrog.io", 'jfrog-cred') {
                        app.push()
                    }
                    echo '--------- Docker Publish Ended ------'
                }
            }
        }
        
    }
}
