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
                sh 'mvn clean package -Dmaven.test.skip=true'
                echo "Build completed"
            }
        }
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
    }
}

