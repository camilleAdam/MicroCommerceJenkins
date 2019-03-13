pipeline {
    agent any

    tools{
        maven 'Maven 3.6.0'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Test') {

            steps{
                junit '**/target/surefire-reports/*.xml'
                testResults '**/target/surefire-reports/*.xml'
                allowEmptyResults 'true'
            }
        }
        stage('Deploy') {

        }
    }
}