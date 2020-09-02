pipeline {
    //agent {
      //  docker { image 'maven:3.6.3-slim' }
    //}
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/site/jacoco/index.html'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                sh 'mvn spring-boot:run'

            }
            post {
                always {
                    echo 'Saving artifacts..'
                    archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
    }
}
