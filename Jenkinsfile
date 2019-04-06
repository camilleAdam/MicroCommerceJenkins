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
//                sh 'mvn install'
            }
        }
        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('SonarServer'){
                    sh 'mvn clean package sonar:sonar '
//                    -Dsonar.host.url=http://localhost:9000 -Dsonar.login=5b4428569bcfa3a0286df2179664d435ded1bd28
                }
            }
        }
    }

    post {
        always {
//            junit '**/target/surefire-reports/*.xml'
            step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
        }

        success {

            echo 'Passed, will be pushed...'
            sh 'git fetch'
            sh 'git checkout dev'
            sh 'git pull origin dev'
            sh 'git status'
            sh 'git merge origin/test1'
            sh 'git status'
            sh 'git push'
            sh 'git status'

        }
    }
}