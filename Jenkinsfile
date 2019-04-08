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
            }
        }
        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('SonarServer'){
                    sh 'mvn clean package sonar:sonar '
//                    
                }
            }
        }
    }

    post {
        always {
            step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
        }

        success {

            echo 'Passed, will be pushed...'
            sh 'git fetch'
            sh 'git config user.name'
            sh 'git checkout dev'
            sh 'git pull origin dev'
            sh 'git status'
            sh 'git pull origin test1'
            sh 'git status'
            sh 'git push origin dev'
            sh 'git status'

        }
    }
}
