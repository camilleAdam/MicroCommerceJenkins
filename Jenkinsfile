pipeline {
    agent any

    tools {
        git 'Default'
        jdk 'JDK11'
        maven 'Maven 3.6'
    }

    triggers {
        pollSCM '* * * * * '
    }

    stages {
        stage('Build') {
            steps {
                echo 'building...'
                sh 'mvn clean'
                sh 'mvn install'
            }
        }
        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('SonarQubeServeur'){
                    sh 'mvn clean package sonar:sonar '
                    waitForQualityGate abortPipeline: true
//                    -Dsonar.host.url=http://localhost:9000 -Dsonar.login=8b34b13421bd212f1e0b79aa1d4e3ba7faafdb5b
                }
            }
        }
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
//                sh 'mvn install'
            }
        }
    }

//    post {
//        always {
////            junit '**/target/surefire-reports/*.xml'
////            step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
//        }

//        success {
////
//            echo 'Passed, will be pushed...'
//            sh 'git fetch'
//            sh 'git checkout dev'
//            sh 'git pull origin dev'
//            sh 'git status'
//            sh 'git merge origin/test1'
//            sh 'git status'
//            sh 'git push origin dev'
//            sh 'git status'
////
//        }
//    }
}