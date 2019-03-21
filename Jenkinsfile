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

//            git credentialsId: '51ca3047-f62f-4250-9ab0-7d1f2e83ba99', url: 'https://github.com/camilleAdam/MicroCommerceJenkins'

            bat 'git fetch'
            bat 'git checkout origin/dev'
            bat 'git pull origin dev'
            bat 'git status'
            bat 'git merge origin/dev'
            bat 'git status'
            bat 'git push origin/dev'
            bat 'git status'

        }
    }
}