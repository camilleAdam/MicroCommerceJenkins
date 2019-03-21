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
            }
        }
        stage('Test') {

            steps{
                echo 'testing...'
                step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
            }
        }
        stage('Deploy') {
            steps{
                echo 'deploying...'
//                bat 'mvn install'
            }
        }
    }

    post {
//        always {
//            junit '**/target/surefire-reports/*.xml'
//        }

        success {

            git branch: '', credentialsId: 'ba012e23-83bb-4d28-930c-b6e32747e46c', url: 'https://github.com/camilleAdam/MicroCommerceJenkins.git'
            bat 'git fetch'
            bat 'git checkout dev'
            bat 'git pull origin dev'
            bat 'git status'
            bat 'git merge origin/test1'
            bat 'git status'
            bat 'git push'
            bat 'git status'

        }
    }
}