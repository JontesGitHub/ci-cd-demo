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
                        reportDir: 'target/site/',
                        reportFiles: 'surefire-report.html',
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
                }
            }
        }
        stage('Save .jar file (run with: java -jar JARFILE.jar in terminal') {
            steps {
                echo 'Saving Archives..'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }
        }
    }
}
