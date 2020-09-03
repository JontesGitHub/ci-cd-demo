pipeline {
    //agent {
      //  docker { image 'maven:3.6.3-slim' }
    //}
    agent any
    stages {
        stage('Build and Test') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
        }
        stage('Test Reports') {
            steps {
                echo 'Publishing Tests Reports..'
                sh 'mvn surefire-report:report-only'
            }
            post {
                always {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/surefire-reports/',
                        reportFiles: 'index.html',
                        reportName: 'Surefire Reports',
                        reportTitles: 'Surefire Reports'
                    ])

                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/jacoco/',
                        reportFiles: 'index.html',
                        reportName: 'Jacoco Reports',
                        reportTitles: 'Jacoco Reports'
                    ])

                    archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
        stage('Save .jar file') {
            steps {
                echo 'Saving Archives..'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                sh 'mvn spring-boot:run'
            }
        }
    }
}
