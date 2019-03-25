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
//        stage('SonarQube analysis'){
//            steps{
//                withSonarQubeEnv('SonarQubeServeur'){
//                    bat 'mvn clean package sonar:sonar '
//                    waitForQualityGate abortPipeline: true
////                    -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d375d300225818aa5cd32f06fe02ad8e4aaa5d90
//                }
//            }
//        }
//        stage('Test') {
//
//            steps{
//                echo 'testing...'
//                step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
//            }
//        }
        stage('Deploy') {
            steps{
                echo 'deploying...'
//                bat 'mvn install'
            }
        }
    }

    post {
//        always {
////            junit '**/target/surefire-reports/*.xml'
////            step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
//        }

        success {
//
            echo 'Passed, will be pushed...'
//            git  credentialsId: 'ba012e23-83bb-4d28-930c-b6e32747e46c', url: 'https://github.com/camilleAdam/MicroCommerceJenkins.git'
            bat 'git fetch'
            bat 'git checkout dev'
            bat 'git pull origin dev'
            bat 'git status'
            bat 'git merge origin/test1'
            bat 'git status'
            bat 'git push'
            bat 'git status'
//
        }
    }
}