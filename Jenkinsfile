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
                bat 'mvn clean'
                bat 'mvn install'
            }
        }
        stage('Test') {

            steps{
                echo 'testing...'
//                junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
            }
        }
        stage('Deploy') {
            steps{
                echo 'deploying...'
            }
        }
    }
}