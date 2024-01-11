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
                sh 'mvn clean deploy -Dmaven.test.skip=true'
                echo "Build completed"
            }
        }
        /*
        stage("Test Stage") {
            steps {
                echo "----------- Unit Test Started ----------"
                sh 'mvn surefire-report:report'
                echo "----------- Unit Test Completed ----------"
            }
        }
        stage('SonarQube analysis') {
            environment {
                scannerHome = tool 'Sonar-Scanner-meportal'
            }
            steps {
                withSonarQubeEnv('SonrQube-Server-meportal') {
                    sh "${scannerHome}/bin/sonar-scanner"
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
        }
        */
        stage("Artifact Publish") {
            steps {
                script {
                    echo '------------- Artifact Publish Started ------------'
                    def server = Artifactory.newServer url: "https://avdmeportal.jfrog.io/artifactory", credentialsId: "jfrog-jenkins-cred"
                    def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}"
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "staging/*",
                                "target": "release-local-artifacts/",
                                "flat": "false",
                                "props" : "${properties}",
                                "exclusions": ["*.sha1", "*.md5"]
                            }
                        ]
                    }"""
                    def buildInfo = server.upload(uploadSpec)

                    // Collect environment variables from buildInfo for Jenkins build information
                    def buildEnv = buildInfo.env.collect()

                    // Use buildEnv to display build-related information
                    echo "Build Number: ${buildEnv.BUILD_NUMBER}"
                    echo "Build URL: ${buildEnv.BUILD_URL}"

                    // Publish buildInfo to Artifactory
                    server.publishBuildInfo(buildInfo)

                    echo '------------ Artifact Publish Ended -----------'
                }
            }
        }
    }
}
