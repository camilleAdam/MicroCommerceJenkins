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
                bat 'mvn install'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }

        success {
            stage('Git'){
                when {
                    branch 'dev'
                }
                steps{
                    bat 'git merge dev'
                    bat 'git commit -am "Merged branch to master"'
                    bat 'git push origin master'
                }
            }
        }
    }
}