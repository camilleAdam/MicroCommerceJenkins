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
                sh 'mvn test'
            }
        }
        stage('Test') {

            steps{
                echo 'testing...'
                step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'])
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }

//        success {
//
//            bat 'git checkout origin/master'
//            bat 'git pull origin/master'
//            bat 'git merge dev'
//            bat 'git push origin/master'
//
//        }
    }
}