pipeline {
    agent any

    tools {
        git 'Adam Camille'
        jdk 'Java 8.171'
        maven 'Maven 3.6.0'
    }

    triggers {
        pollSCM '* * * * * '
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
            steps{
                echo 'deploying...'
            }
        }
    }
}