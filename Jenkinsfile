pipeline {
    agent any

    tools{
        maven 'Maven 3.6.0'
    }

    stages {
        stage('Build') {
            steps {
                echo 'building...'
//                bat 'mvn clean'
            }
        }
        stage('Test') {

            steps{
                echo 'testing...'
//                junit '**/target/surefire-reports/*.xml'
//                testResults '**/target/surefire-reports/*.xml'
//                allowEmptyResults 'true'
            }
        }
        stage('Deploy') {
                echo 'deploying...'
        }
    }
}