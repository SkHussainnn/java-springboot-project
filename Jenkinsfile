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
                echo "Build completed"   // This is Iftekhar
            }
        }
    }
}
