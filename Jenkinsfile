pipeline {
    agent any

    tools {
        maven 'maven-3.9.6'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Spring Boot App') {
            steps {
                sh '''
                pkill -f "java -jar" || true  # Stop previous instance (Linux/Mac only)
                nohup java -jar target/*.jar > app.log 2>&1 &
                '''
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
