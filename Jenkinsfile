pipeline {
    agent {
        docker {image: 'maven:3-alpine'}
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                mvn clean compile
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                mvn test
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                mvn package -Dmaven.test.skip=true && java -jar target/ci-cd-demo-SNAPSHOT.jar
            }
            post {
                always {
                    echo 'Saving artifacts..'
                    archiveArtifacts artifacts: '**/*.jar', onlyIfSuccessful: true
                }
            }
        }
    }
}
